package org.palina.pos.mapper

import org.palina.pos.dto.ProductDto
import org.palina.pos.model.ProductModel

class ProductMapper {

    static ProductDto toDto(ProductModel model) {
        if (model == null) return null;

        return new ProductDto(
                code: model.code,
                description: model.description,
                category1: model.category1,
                category2: model.category2,
                barcode: model.barcode,
                purchasePrice: model.purchasePrice,
                salePrice: model.salePrice,
                currentStock: model.currentStock,
                outletId: model.outlet?.id
        )
    }

    static ProductModel toModel(ProductDto dto){
        if (dto == null) return null;

        ProductModel model = new ProductModel(
                code: dto.code,
                description: dto.description,
                category1: dto.category1,
                category2: dto.category2,
                barcode: dto.barcode,
                purchasePrice: dto.purchasePrice,
                salePrice: dto.salePrice,
                currentStock: dto.currentStock
        )
        return model
    }
}
