package org.palina.pos.service

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.palina.pos.dto.ProductDto
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class ProductServiceTests {

    @Autowired
    private ProductService productService

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

        ProductDto res = productService.save(productDto)
        Assertions.assertNotNull(res)
    }

}
