package org.palina.pos.use_case.sale.impl

import org.palina.pos.dto.GeneralResponseDto
import org.palina.pos.dto.SaleDto
import org.palina.pos.service.SaleService
import org.palina.pos.use_case.sale.GetOpenSalesUseCase

class GetOpenSalesUseCaseImpl implements GetOpenSalesUseCase{

    GetOpenSalesUseCaseImpl(SaleService saleService) {
        this.saleService = saleService
    }
    private final SaleService saleService

    @Override
    GeneralResponseDto<List<SaleDto>> execute() {
        String apartado = "Apartado";
        return GeneralResponseDto.ok(saleService.findAllByType(apartado, false))
    }
}
