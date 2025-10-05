package org.palina.pos.use_case.sale.impl

import org.palina.pos.dto.GeneralResponseDto
import org.palina.pos.dto.PaymentDto
import org.palina.pos.dto.SaleDto
import org.palina.pos.mapper.SaleMapper
import org.palina.pos.model.PaymentModel
import org.palina.pos.model.SaleModel
import org.palina.pos.repository.SaleRepository
import org.palina.pos.use_case.sale.AddPaymentUseCase

class AddPaymentUseCaseImpl implements AddPaymentUseCase{

    private final SaleRepository saleRepository

    public AddPaymentUseCaseImpl(SaleRepository saleRepository) {
        this.saleRepository = saleRepository
    }

    @Override
    GeneralResponseDto<SaleDto> execute(Long saleId, PaymentDto payment) {
        SaleModel sale = saleRepository.findById(saleId).get()

        BigDecimal total = sale.getTotal()
        BigDecimal abonadoAcumulado = sale.payments*.amountPaid.sum()
        BigDecimal abonoNuevo = payment.amountPaid

        BigDecimal saldoRestante = total.subtract(abonadoAcumulado).subtract(abonoNuevo)

        if(saldoRestante >= BigDecimal.ZERO){
            sale.saleClosed = true
        }

        PaymentModel paymentModel = new PaymentModel()
        paymentModel.amountPaid = payment.amountPaid
        paymentModel.paymentDate = payment.paymentDate
        paymentModel.paymentType = payment.paymentType
        paymentModel.sale = sale

        sale.getPayments().add(paymentModel)

        SaleDto saleDto = SaleMapper.toDto(saleRepository.save(sale))

        return GeneralResponseDto.ok(saleDto)
    }
}
