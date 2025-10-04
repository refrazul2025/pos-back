package org.palina.pos.use_case.producto.impl

import org.palina.pos.dto.GeneralResponseDto
import org.palina.pos.dto.ProductDto
import org.palina.pos.service.ProductService
import org.palina.pos.use_case.producto.GetProductByCodeUseCase

class GetProductByCodeUseCaseImpl implements GetProductByCodeUseCase{

    private final ProductService productService

    GetProductByCodeUseCaseImpl(ProductService productService) {
        this.productService = productService
    }

    @Override
    GeneralResponseDto<ProductDto> execute(ProductDto productDto) {
        ProductDto res = productService.findByName(productDto)
        return GeneralResponseDto.ok(res)
    }

    @Override
    GeneralResponseDto<List<ProductDto>> execute(List<ProductDto> code) {
        List<ProductDto> productDtoList = code.stream().map { productDto->
            return productService.findByName(productDto)
        }.toList()

        return GeneralResponseDto.ok(productDtoList)
    }
}
