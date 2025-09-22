package org.palina.pos.config

import org.palina.pos.service.OutletService
import org.palina.pos.service.ProductService
import org.palina.pos.service.SaleService
import org.palina.pos.service.UserService
import org.palina.pos.use_case.producto.AddNewProductUseCase
import org.palina.pos.use_case.producto.UpdateStockUseCase
import org.palina.pos.use_case.producto.impl.AddNewProductUseCaseImpl
import org.palina.pos.use_case.producto.impl.UpdateStockUseCaseImpl
import org.palina.pos.use_case.sale.CashPaymentUseCase
import org.palina.pos.use_case.sale.impl.CashPaymentUseCaseImpl
import org.palina.pos.use_case.user.ValidateUserUseCase
import org.palina.pos.use_case.user.impl.ValidateUserUseCaseImpl
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class AppConfiguration {

    @Bean
    AddNewProductUseCase addNewProductUseCase(final ProductService productService,
                                            final OutletService outletService){
        return new AddNewProductUseCaseImpl(productService, outletService)
    }

    @Bean
    UpdateStockUseCase updateStockUseCase(final ProductService productService,
                                          final OutletService outletService){
        return new UpdateStockUseCaseImpl(productService, outletService)
    }

    @Bean
    CashPaymentUseCase cashPaymentUseCase(final OutletService outletService,
                                        final SaleService saleService){
        return new CashPaymentUseCaseImpl(outletService, saleService)
    }

    @Bean
    ValidateUserUseCase validateUserUseCase(final UserService userService){
        return new ValidateUserUseCaseImpl(userService)
    }


}
