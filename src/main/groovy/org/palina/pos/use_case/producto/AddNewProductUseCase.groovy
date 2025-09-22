package org.palina.pos.use_case.producto

import org.palina.pos.dto.GeneralResponseDto
import org.palina.pos.dto.ProductDto

interface AddNewProductUseCase {

    GeneralResponseDto<ProductDto> execute(String outlet, ProductDto product)
}