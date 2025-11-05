package org.palina.pos.use_case.sale.impl

import org.palina.pos.dto.GeneralResponseDto
import org.palina.pos.dto.SaleInfoDto
import org.palina.pos.model.PaymentModel
import org.palina.pos.model.ProductModel
import org.palina.pos.model.SaleDetailModel
import org.palina.pos.repository.ProductRepository
import org.palina.pos.repository.SaleRepository
import org.palina.pos.use_case.sale.GetSalesInfoUseCase

import java.util.stream.Collectors

class GetSalesInfoUseCaseImpl implements GetSalesInfoUseCase{

    private final SaleRepository saleRepository
    private final ProductRepository productRepository

    GetSalesInfoUseCaseImpl(SaleRepository saleRepository, ProductRepository productRepository) {
        this.saleRepository = saleRepository
        this.productRepository = productRepository
    }

    @Override
    GeneralResponseDto<List<SaleInfoDto>> execute(Long userId, Long outleId) {
        def queryResponse = null

        if(userId && outleId){
            queryResponse = saleRepository.findTop15ByOutlet_IdAndUserIdOrderByIdDesc(outleId, userId)
        }else if(userId){
            queryResponse = saleRepository.findTop15ByUserIdOrderByIdDesc(userId)
        }else{
            queryResponse = saleRepository.findTop15ByOrderByIdDesc()
        }

        List<SaleInfoDto> transactions = queryResponse
                .stream()
                .map ( sale -> {
                    SaleInfoDto saleInfoDto = new SaleInfoDto()
                    saleInfoDto.saleDate = sale.saleDate
                    saleInfoDto.saleType = sale.saleType
                    saleInfoDto.total = sale.total
                    saleInfoDto.customer = sale.customer

                    String pagos = sale.payments.stream().map(PaymentModel::getPaymentType)
                            .collect(Collectors.joining("|"))


                    String productos = sale.saleDetails
                            .stream()
                            .map(SaleDetailModel::getProductCode)
                            .map(productId -> productRepository.findById(productId).orElse(null))
                            .filter(Objects::nonNull)
                            .map(ProductModel::getCategory2)
                            .collect(Collectors.joining("|"))

                    saleInfoDto.payments = pagos
                    saleInfoDto.products = productos
                    saleInfoDto.userId = sale.userId
                    saleInfoDto.outletId = sale.outlet.id
                    return saleInfoDto
                }
        ).toList()

        return GeneralResponseDto.ok(transactions)
    }
}
