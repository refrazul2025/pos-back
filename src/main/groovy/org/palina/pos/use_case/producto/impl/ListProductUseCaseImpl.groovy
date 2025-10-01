package org.palina.pos.use_case.producto.impl

import org.palina.pos.dto.GeneralResponseDto
import org.palina.pos.dto.OutletDto
import org.palina.pos.dto.ProductDto
import org.palina.pos.service.ProductService
import org.palina.pos.use_case.producto.ListProductUseCase

class ListProductUseCaseImpl implements ListProductUseCase{

    private final ProductService productService

    ListProductUseCaseImpl(ProductService productService) {
        this.productService = productService
    }

    @Override
    GeneralResponseDto<List<ProductDto>> execute(Long outletId) {
        List<ProductDto> list =  productService.list(outletId)
        return GeneralResponseDto.ok(list)
    }
}
