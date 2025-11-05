package org.palina.pos.use_case.producto

import org.palina.pos.dto.GeneralResponseDto
import org.palina.pos.dto.ProductDto

interface AddFastProductUseCase {

    GeneralResponseDto<ProductDto> execute(ProductDto product)

}
