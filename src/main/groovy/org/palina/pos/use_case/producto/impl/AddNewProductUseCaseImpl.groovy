package org.palina.pos.use_case.producto.impl

import org.palina.pos.dto.GeneralResponseDto
import org.palina.pos.dto.OutletDto
import org.palina.pos.dto.ProductDto
import org.palina.pos.service.OutletService
import org.palina.pos.service.ProductService
import org.palina.pos.use_case.producto.AddNewProductUseCase

import java.time.LocalDateTime

class AddNewProductUseCaseImpl implements AddNewProductUseCase{

    private final ProductService productService
    private final OutletService outletService

    AddNewProductUseCaseImpl(ProductService productService,
                            OutletService outletService) {
        this.productService = productService
        this.outletService  = outletService
    }

    @Override
    GeneralResponseDto<ProductDto> execute(String outlet, ProductDto product) {
        LocalDateTime fecha = LocalDateTime.now()
        OutletDto outletDto = outletService.getByName(outlet)

        if ( null != productService.findByName(product)){
            return GeneralResponseDto.error("001", "Producto ya registrado")
        }

        ProductDto newProduct = new ProductDto(
                      code    :  product?.code?: product.code.toUpperCase(),
                description   :  product?.description,
                category1     :  product?.category1?: product.category1.toUpperCase(),
                category2     :  product?.category2?: product.category2.toUpperCase(),
                barcode       :  product.barcode,
                purchasePrice :  product.purchasePrice,
                    salePrice :  product.salePrice,
                currentStock  :  product.currentStock,
                outletId      :  outletDto.id,
                createAt      :  fecha
        )

        return GeneralResponseDto.ok( productService.save(newProduct))
    }
}
