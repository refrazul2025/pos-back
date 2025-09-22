package org.palina.pos.service

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.palina.pos.dto.OutletDto
import org.palina.pos.dto.SaleDetailDto
import org.palina.pos.dto.SaleDto
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

import java.time.LocalDate

@SpringBootTest
class SaleServiceTests {

    @Autowired
    private SaleService saleService

    @Test
    void sale(){
        LocalDate fecha = LocalDate.now()

        SaleDetailDto saleDetailDto = new SaleDetailDto()
        saleDetailDto.productCode = "0001"
        saleDetailDto.quantity = 5
        saleDetailDto.unitPrice = new BigDecimal(38)
        saleDetailDto.subtotal = saleDetailDto.unitPrice * saleDetailDto.quantity

        List<SaleDetailDto> details = new ArrayList<>()
        details.add(saleDetailDto)

        OutletDto outletDto = new OutletDto(name: "test")
        SaleDto saleDto = new SaleDto()
        saleDto.saleType = "CONTADO"
        saleDto.paymentType = "EFECTIVO"
        saleDto.customer = "Francisco Resendiz"
        saleDto.saleDetails = details

      SaleDto res =  saleService.create(outletDto, saleDto)
        Assertions.assertNotNull(res)
    }
}
