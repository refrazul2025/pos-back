package org.palina.pos.mapper

import org.palina.pos.dto.PaymentDto
import org.palina.pos.model.PaymentModel
import org.palina.pos.model.SaleModel

class PaymentMapper {

    static PaymentDto toDto(PaymentModel model) {
        if (model == null) return null;

        return new PaymentDto(
                id: model.id,
                idSale: model.sale?.id,
                amountPaid: model.amountPaid,
                paymentDate: model.paymentDate,
                paymentType: model.paymentType
        )
    }

    static PaymentModel toModel(PaymentDto dto){
        if (dto == null) return null;

        PaymentModel model = new PaymentModel()
        model.id = dto.id

        if (dto.idSale != null) {
            SaleModel sale = new SaleModel()
            sale.id = dto.idSale
            model.sale = sale;
        }

        model.amountPaid  = dto.amountPaid
        model.paymentDate = dto.paymentDate
        model.paymentType = dto.paymentType
        return model
    }
}
