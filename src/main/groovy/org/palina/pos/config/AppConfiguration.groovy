package org.palina.pos.config

import org.palina.pos.repository.UserOutletRepository
import org.palina.pos.service.OutletService
import org.palina.pos.service.ProductService
import org.palina.pos.service.SaleService
import org.palina.pos.service.UserOutletService
import org.palina.pos.service.UserService
import org.palina.pos.use_case.outlet.GetOutletByUserUseCase
import org.palina.pos.use_case.outlet.impl.GetOutletByUserUseCaseImpl
import org.palina.pos.use_case.producto.AddNewProductUseCase
import org.palina.pos.use_case.producto.ListProductUseCase
import org.palina.pos.use_case.producto.UpdateStockUseCase
import org.palina.pos.use_case.producto.impl.AddNewProductUseCaseImpl
import org.palina.pos.use_case.producto.impl.ListProductUseCaseImpl
import org.palina.pos.use_case.producto.impl.UpdateStockUseCaseImpl
import org.palina.pos.use_case.sale.CashPaymentUseCase
import org.palina.pos.use_case.sale.impl.CashPaymentUseCaseImpl
import org.palina.pos.use_case.user.ValidateUserUseCase
import org.palina.pos.use_case.user.impl.ValidateUserUseCaseImpl
import org.palina.pos.use_case.user_outlet.GetByOutletUseCase
import org.palina.pos.use_case.user_outlet.impl.GetByOutletUseCaseImpl
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
    CashPaymentUseCase cashPaymentUseCase(final UpdateStockUseCase updateStockUseCase,
                                          final OutletService outletService,
                                          final SaleService saleService,
                                          final ProductService productService,
                                          final UserOutletService userOutletService){
        return new CashPaymentUseCaseImpl(updateStockUseCase,
                                        outletService,
                                        saleService,
                                        productService,
                                        userOutletService)
    }

    @Bean
    ValidateUserUseCase validateUserUseCase(final UserService userService){
        return new ValidateUserUseCaseImpl(userService)
    }

    @Bean
    GetOutletByUserUseCase getOutletByUserUseCase(final UserOutletRepository userOutletRepository){
        return new GetOutletByUserUseCaseImpl(userOutletRepository)
    }

    @Bean
    ListProductUseCase listProductUseCase(final ProductService productService){
        return new ListProductUseCaseImpl(productService)
    }

    @Bean
    GetByOutletUseCase getByOutletUseCase(final UserOutletService userOutletService){
        return new GetByOutletUseCaseImpl(userOutletService)
    }
}
