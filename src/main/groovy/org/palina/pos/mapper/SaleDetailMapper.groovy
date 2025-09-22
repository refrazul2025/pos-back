package org.palina.pos.mapper

import org.palina.pos.dto.SaleDetailDto
import org.palina.pos.model.SaleDetailModel
import org.palina.pos.model.SaleModel

class SaleDetailMapper {

    static SaleDetailDto toDto(SaleDetailModel model) {
        if (model == null) return null;

        return new SaleDetailDto(
                id: model.id,
                idSlale: model?.sale?.id,
                productCode:model.productCode,
                quantity:model.quantity,
                unitPrice:model.unitPrice,
                subtotal:model.subtotal
        )
    }

    static SaleDetailModel toModel(SaleDetailDto dto) {
        if (dto == null) return null;

        SaleDetailModel model = new SaleDetailModel();
        model.id = dto.id

        if (dto.idSlale != null) {
            SaleModel sale = new SaleModel()
            sale.id = dto.idSlale
            model.sale = sale
        }

        model.productCode = dto.productCode
        model.quantity = dto.quantity
        model.unitPrice = dto.unitPrice
        model.subtotal = dto.subtotal

        return model
    }
}
