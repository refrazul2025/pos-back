package org.palina.pos.use_case.producto.impl

import org.palina.pos.dto.OutletDto
import org.palina.pos.dto.ProductDto
import org.palina.pos.service.OutletService
import org.palina.pos.service.ProductService
import org.palina.pos.use_case.producto.UpdateStockUseCase

class UpdateStockUseCaseImpl implements UpdateStockUseCase{

    private final ProductService productService
    private final OutletService outletService

    UpdateStockUseCaseImpl(ProductService productService, OutletService outletService) {
        this.productService = productService
        this.outletService = outletService
    }

    @Override
    ProductDto execute(String outlet, ProductDto product){
        OutletDto outletDto = outletService.getByName(outlet)
        product.outletId = outletDto.id
        ProductDto original = productService.findByName(product)

        int unidadesModificadas = 0;

        if(product?.unitsAdd){
            unidadesModificadas+=product.unitsAdd
        }

        if(product?.unitsDelete){
            unidadesModificadas-=product.unitsDelete
        }

        original.currentStock = original.currentStock + unidadesModificadas

        return productService.update(original)
    }
}
