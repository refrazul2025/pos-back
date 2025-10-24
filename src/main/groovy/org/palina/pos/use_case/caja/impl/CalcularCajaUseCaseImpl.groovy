package org.palina.pos.use_case.caja.impl

import org.palina.pos.dto.CajaDto
import org.palina.pos.dto.GeneralResponseDto
import org.palina.pos.dto.SaleDto
import org.palina.pos.model.CajaModel
import org.palina.pos.service.CajaService
import org.palina.pos.service.SaleService
import org.palina.pos.use_case.caja.CalcularCajaUseCase

import java.time.LocalDateTime

class CalcularCajaUseCaseImpl implements CalcularCajaUseCase {

    private CajaService cajaService
    private SaleService saleService

    CalcularCajaUseCaseImpl(CajaService cajaService, SaleService saleService) {
        this.cajaService = cajaService
        this.saleService = saleService
    }

    @Override
    GeneralResponseDto<List<CajaDto>> execute() {
        List<SaleDto> ventas = saleService.findUnreconciled()
        BigDecimal totalVentas = ventas.sum(v-> v.total)

        CajaModel cajaChica = cajaService.getCajaChica()
        CajaModel cajaVentas = cajaService.getCajaVentas()

        cajaVentas.monto = totalVentas
        cajaVentas.fechaHora = LocalDateTime.now()

        CajaModel res = cajaService.save(cajaVentas)

        List<CajaDto> resList = new ArrayList<>()

        CajaDto cajaChicaDto = new CajaDto(monto: cajaChica.monto,
                                           fecha: cajaChica.fechaHora.toLocalDate(),
                                            tipo: "CAJA CHICA")

        CajaDto cajaVentasDto = new CajaDto(monto: res.monto,
                                            fecha: res.fechaHora.toLocalDate(),
                                            tipo: "VENTAS")

        resList.add(cajaChicaDto)
        resList.add(cajaVentasDto)


        return GeneralResponseDto.ok(resList)
    }
}
