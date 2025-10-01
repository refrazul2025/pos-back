package org.palina.pos.use_case.producto

import org.palina.pos.dto.GeneralResponseDto
import org.palina.pos.dto.ProductDto

interface ListProductUseCase {
    GeneralResponseDto<List<ProductDto>> execute(Long outletId)
}