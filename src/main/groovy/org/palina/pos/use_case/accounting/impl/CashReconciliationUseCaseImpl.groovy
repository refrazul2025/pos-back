package org.palina.pos.use_case.accounting.impl

import org.palina.pos.dto.ReconciliationDto
import org.palina.pos.model.SaleBalanceModel
import org.palina.pos.model.SaleModel
import org.palina.pos.service.SaleBalanceService
import org.palina.pos.service.SaleService
import org.palina.pos.use_case.accounting.CashReconciliationUseCase

import java.time.LocalDate
import java.time.format.DateTimeFormatter

class CashReconciliationUseCaseImpl implements CashReconciliationUseCase{

    private final SaleService saleService
    private final SaleBalanceService saleBalanceService

    CashReconciliationUseCaseImpl(SaleService saleService, SaleBalanceService saleBalanceService) {
        this.saleService = saleService
        this.saleBalanceService = saleBalanceService
    }

    @Override
    void execute(ReconciliationDto reconciliationDto) {
        if(!reconciliationDto?.date){
            return
        }

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd")
        LocalDate date = LocalDate.parse(reconciliationDto.date, formatter)

        BigDecimal total = saleService.findUnreconciledBeforeOrOn(date)
                    .stream()
                    .map(SaleModel::getTotal)
                    .reduce(BigDecimal.ZERO, BigDecimal::add)

        if(BigDecimal.ZERO == total ){
            return
        }

        BigDecimal saldo = BigDecimal.ZERO
        SaleBalanceModel saleBalanceModel = saleBalanceService.findSaleBalanceWithMaxId()

        if(null != saleBalanceModel){
            saldo = saleBalanceModel.saldo
        }

        BigDecimal newSaldo = saldo.add(total)

        SaleBalanceModel newBalanceSale = new SaleBalanceModel()
        newBalanceSale.abono = total
        newBalanceSale.description = "Ventas reliazasas al ${date.toString()}"
        newBalanceSale.balanceDate = date
        newBalanceSale.saldo = newSaldo

        saleBalanceService.save(newBalanceSale)

        int a  = saleService.markAsReconciledBeforeOrOn(date)

        return
    }
}