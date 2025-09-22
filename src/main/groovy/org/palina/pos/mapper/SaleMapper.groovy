package org.palina.pos.mapper

import org.palina.pos.dto.PaymentDto
import org.palina.pos.dto.SaleDetailDto
import org.palina.pos.dto.SaleDto
import org.palina.pos.model.OutletModel
import org.palina.pos.model.PaymentModel
import org.palina.pos.model.SaleDetailModel
import org.palina.pos.model.SaleModel

class SaleMapper {
    public static SaleDto toDto(SaleModel model) {
        if (model == null) return null;

        List<SaleDetailDto> saleDetails =
                model.getSaleDetails() != null
                        ? model.getSaleDetails().stream()
                        .map(SaleDetailMapper::toDto)
                        .toList()
                        : List.of()

        List<PaymentDto> payments =
                model.getPayments() != null
                ? model.getPayments().stream()
                .map (PaymentMapper::toDto)
                .toList()
                : List.of()

        return new SaleDto(
                id: model.getId(),
                saleDate:  model.getSaleDate(),
                saleType:  model.getSaleType(),
                total:  model.getTotal(),
                saleClosed:  model.isSaleClosed(),
                customer:  model.getCustomer(),
                outletId:  model?.outlet?.id,
                saleDetails: saleDetails,
                payments: payments
        )
    }

    static SaleModel toModel(SaleDto dto) {
        if (dto == null) return null;

        SaleModel entity = new SaleModel()
        entity.id = dto.id
        entity.saleDate = dto.saleDate
        entity.saleType = dto.saleType
        entity.total    = dto.total
        entity.saleClosed = dto.saleClosed
        entity.customer   = dto.customer

        // Mapear outlet usando solo el ID
        if (dto.outletId != null) {
            OutletModel outlet = new OutletModel()
            outlet.setId(dto.outletId)
            entity.setOutlet(outlet)
        }

        // Mapear saleDetails
        if (dto.saleDetails != null && !dto.saleDetails.isEmpty()) {
            List<SaleDetailModel> details = dto.saleDetails.stream()
                    .map(detailDto -> {
                        SaleDetailModel detail = SaleDetailMapper.toModel(detailDto);
                        detail.setSale(entity);  // asignar la venta padre
                        return detail
                    })
                    .toList()
            entity.setSaleDetails(details)
        } else {
            entity.setSaleDetails(List.of())
        }

        // Mapear payments
        if (dto.payments != null && !dto.payments.isEmpty()) {
            List<PaymentModel> payments = dto.payments.stream()
                    .map(paymentDto -> {
                        PaymentModel payment = PaymentMapper.toModel(paymentDto)
                        payment.setSale(entity)  // asignar la venta padre
                        return payment
                    })
                    .toList()
            entity.setPayments(payments)
        } else {
            entity.setPayments(List.of())
        }

        return entity
    }
}