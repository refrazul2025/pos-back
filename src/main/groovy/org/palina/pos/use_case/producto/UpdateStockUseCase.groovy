package org.palina.pos.use_case.producto

import org.palina.pos.dto.OutletDto
import org.palina.pos.dto.ProductDto

interface UpdateStockUseCase {
    ProductDto execute(String outlet, ProductDto product)
}
