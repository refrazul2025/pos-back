package org.palina.pos.use_case

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.palina.pos.dto.GeneralResponseDto
import org.palina.pos.dto.ProductDto
import org.palina.pos.use_case.producto.AddNewProductUseCase
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class AddNewProductUseCaseTests {

    @Autowired
    private AddNewProductUseCase addNewProductUseCase

    @Test
    void save_product(){
        ProductDto productDto = new ProductDto(
                code:  "0004",
                description: "reloj rojo",
                category1: "relojes",
                category2: "relojes",
                barcode: "654542221",
                purchasePrice: new BigDecimal(50),
                salePrice: new BigDecimal(120),
                currentStock: 5,
                outletId: 1
        )

        GeneralResponseDto res = addNewProductUseCase.execute("test",productDto)
        Assertions.assertEquals("001",res.codigo())
    }

    @Test
    void save_product2(){
        ProductDto productDto = new ProductDto(
                code:  "0005",
                description: "reloj azul",
                category1: "relojes",
                category2: "relojes",
                barcode: "654542221",
                purchasePrice: new BigDecimal(50),
                salePrice: new BigDecimal(120),
                currentStock: 5,
                outletId: 1
        )

        GeneralResponseDto res = addNewProductUseCase.execute("test",productDto)
        Assertions.assertEquals("000",res.codigo())
    }
}
