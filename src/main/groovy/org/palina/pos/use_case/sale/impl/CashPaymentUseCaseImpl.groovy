package org.palina.pos.use_case.sale.impl

import org.palina.pos.dto.GeneralResponseDto
import org.palina.pos.dto.OutletDto
import org.palina.pos.dto.SaleDto
import org.palina.pos.mapper.SaleMapper
import org.palina.pos.model.PaymentModel
import org.palina.pos.model.SaleModel
import org.palina.pos.service.OutletService
import org.palina.pos.service.SaleService
import org.palina.pos.use_case.sale.CashPaymentUseCase

import java.time.LocalDateTime

class CashPaymentUseCaseImpl implements CashPaymentUseCase{

    private final OutletService outletService
    private final SaleService saleService

    CashPaymentUseCaseImpl(OutletService outletService, SaleService saleService) {
        this.outletService = outletService
        this.saleService = saleService
    }

    @Override
    GeneralResponseDto<SaleDto> execute(SaleDto sale) {
        OutletDto outletDto = outletService.getById(sale.outletId)

        LocalDateTime fecha = LocalDateTime.now()
        sale.outletId = outletDto.id

        SaleModel model = SaleMapper.toModel(sale)
        model.saleDate = fecha.toLocalDate()
        double total = model.saleDetails.stream().mapToDouble(detalle -> detalle.getSubtotal().doubleValue() ).sum();
        model.setTotal(new BigDecimal(total))

        if ( model?.saleType?.equalsIgnoreCase("CONTADO")){
            model.saleClosed = true
            PaymentModel paymentModel = new PaymentModel()
            paymentModel.paymentDate  = fecha.toLocalDate()
            paymentModel.amountPaid   = new BigDecimal(total)
            paymentModel.sale         = model
            paymentModel.paymentType  = sale.paymentType
            List<PaymentModel> pagos  = new ArrayList<>()
            pagos.add(paymentModel)
            model.payments = pagos
        }

        return GeneralResponseDto.ok( saleService.create(sale) )
   }
}
