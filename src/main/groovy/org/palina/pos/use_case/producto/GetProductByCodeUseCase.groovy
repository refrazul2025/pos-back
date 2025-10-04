package org.palina.pos.use_case.producto

import org.palina.pos.dto.GeneralResponseDto
import org.palina.pos.dto.ProductDto

interface GetProductByCodeUseCase {

    GeneralResponseDto<ProductDto> execute(ProductDto productDto)

    GeneralResponseDto<List<ProductDto>> execute(List<ProductDto> productos)
}
