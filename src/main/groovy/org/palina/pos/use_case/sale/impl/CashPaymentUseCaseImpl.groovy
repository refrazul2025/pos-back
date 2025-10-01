package org.palina.pos.use_case.sale.impl

import org.palina.pos.dto.GeneralResponseDto
import org.palina.pos.dto.OutletDto
import org.palina.pos.dto.ProductDto
import org.palina.pos.dto.SaleDto
import org.palina.pos.dto.UserOutletDto
import org.palina.pos.mapper.SaleMapper
import org.palina.pos.model.PaymentModel
import org.palina.pos.model.SaleModel
import org.palina.pos.service.OutletService
import org.palina.pos.service.ProductService
import org.palina.pos.service.SaleService
import org.palina.pos.service.UserOutletService
import org.palina.pos.use_case.producto.UpdateStockUseCase
import org.palina.pos.use_case.sale.CashPaymentUseCase

import java.time.LocalDateTime

class CashPaymentUseCaseImpl implements CashPaymentUseCase{

    private final UpdateStockUseCase updateStockUseCase
    private final OutletService outletService
    private final SaleService saleService
    private final ProductService productService
    private final UserOutletService userOutletService

    CashPaymentUseCaseImpl(UpdateStockUseCase updateStockUseCase,
                            OutletService outletService,
                           SaleService saleService,
                            ProductService productService,
                            UserOutletService userOutletService) {
        this.updateStockUseCase = updateStockUseCase
        this.outletService = outletService
        this.saleService = saleService
        this.productService = productService
        this.userOutletService = userOutletService
    }

    @Override
    GeneralResponseDto<SaleDto> execute(SaleDto sale) {
        OutletDto outletDto = outletService.getById(sale.outletId)

        UserOutletDto userOutletDto = userOutletService.findByOutlet(outletDto.id)
        LocalDateTime fecha = LocalDateTime.now()
        sale.outletId = outletDto.id

        SaleModel model = SaleMapper.toModel(sale)
        model.saleDate = fecha.toLocalDate()
        model.userId = userOutletDto?.userId
        double total = model.saleDetails.stream().mapToDouble(detalle -> detalle.getSubtotal().doubleValue() ).sum();
        model.setTotal(new BigDecimal(total))

        if ( model?.saleType?.equalsIgnoreCase("CONTADO")){
            model.saleClosed = true

            if(!model.payments){
                PaymentModel paymentModel = new PaymentModel()
                paymentModel.paymentDate  = fecha.toLocalDate()
                paymentModel.amountPaid   = new BigDecimal(total)
                paymentModel.sale         = model
                paymentModel.paymentType  = sale.paymentType
                List<PaymentModel> pagos  = new ArrayList<>()
                pagos.add(paymentModel)
                model.payments = pagos
            }else{
                for(PaymentModel p : model.payments ){
                    p.setPaymentDate(fecha.toLocalDate())
                    p.userId = userOutletDto?.userId
                }
            }
        }

        SaleDto res = saleService.create(model)

        if(null == res){
            return GeneralResponseDto.error("002", "Error procesando venta")
        }

        sale.saleDetails.stream()
                .map(p -> {
                    ProductDto productDto = new ProductDto()
                    productDto.setCode(p.productCode)
                    productDto.setOutletId(sale.outletId)
                    productDto.setUnitsDelete(p.quantity)
                    return productDto
                })
                .forEach(ps -> updateStockUseCase.execute(outletDto.name, ps));

        return  GeneralResponseDto.ok(res)
   }
}