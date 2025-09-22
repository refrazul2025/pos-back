package org.palina.pos.use_case

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.palina.pos.dto.ProductDto
import org.palina.pos.use_case.producto.UpdateStockUseCase
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class UpdateStockUseCaseTests {

    @Autowired
    private UpdateStockUseCase updateStockUseCase

    @Test
    void update_stock(){
        ProductDto productDto = new ProductDto()
        productDto.code = "0001"
        productDto.unitsDelete = 5

        ProductDto res = updateStockUseCase.execute("test", productDto)
        Assertions.assertNotNull(productDto)
    }
}
