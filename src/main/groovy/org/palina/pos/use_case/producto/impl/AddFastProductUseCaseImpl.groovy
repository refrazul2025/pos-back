package org.palina.pos.use_case.producto.impl

import jakarta.persistence.EntityManager
import org.palina.pos.dto.GeneralResponseDto
import org.palina.pos.dto.OutletDto
import org.palina.pos.dto.ProductDto
import org.palina.pos.service.OutletService
import org.palina.pos.service.ProductService
import org.palina.pos.use_case.producto.AddFastProductUseCase

import java.time.LocalDateTime

class AddFastProductUseCaseImpl implements AddFastProductUseCase{

    private final ProductService productService
    private final OutletService outletService
    private final EntityManager entityManager

    AddFastProductUseCaseImpl(ProductService productService,
                             OutletService outletService,
                              EntityManager entityManager) {
        this.productService = productService
        this.outletService  = outletService
        this.entityManager = entityManager
    }

    @Override
    GeneralResponseDto<ProductDto> execute(ProductDto product) {
        LocalDateTime fecha = LocalDateTime.now()
        OutletDto outletDto = outletService.getById(product.outletId)

        Long nextVal = ((Number) entityManager
                .createNativeQuery("SELECT NEXT VALUE FOR product_seq")
                .getSingleResult())
                .longValue()

        /*Long nextVal = ((Number) entityManager
                .createNativeQuery("SELECT nextval('product_seq')")
                .getSingleResult())
                .longValue();
        */

        String code = "P-${nextVal}"

        ProductDto newProduct = new ProductDto(
                code    :  code.toUpperCase(),
                description   :  product?.description,
                category1     :  "Product".toUpperCase(),
                category2     :  product?.category2?: product.category2.toUpperCase(),
                barcode       :  code,
                purchasePrice :  product.salePrice.divide(BigDecimal.TWO),
                salePrice     :  product.salePrice,
                currentStock  :  1,
                outletId      :  outletDto.id,
                createAt      :  fecha
        )

        return GeneralResponseDto.ok( productService.save(newProduct))
    }

}
