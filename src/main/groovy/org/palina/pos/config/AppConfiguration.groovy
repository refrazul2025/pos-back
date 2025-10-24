package org.palina.pos.config

import org.palina.pos.repository.SaleRepository
import org.palina.pos.repository.UserOutletRepository
import org.palina.pos.service.AsistenciaService
import org.palina.pos.service.CajaService
import org.palina.pos.service.OutletService
import org.palina.pos.service.ProductService
import org.palina.pos.service.SaleBalanceService
import org.palina.pos.service.SaleService
import org.palina.pos.service.UserOutletService
import org.palina.pos.service.UserService
import org.palina.pos.use_case.accounting.CashReconciliationUseCase
import org.palina.pos.use_case.accounting.impl.CashReconciliationUseCaseImpl
import org.palina.pos.use_case.asistencia.RegistrarAsistenciaUseCase
import org.palina.pos.use_case.asistencia.impl.RegistrarAsistenciaUseCaseImpl
import org.palina.pos.use_case.caja.CalcularCajaUseCase
import org.palina.pos.use_case.caja.impl.CalcularCajaUseCaseImpl
import org.palina.pos.use_case.outlet.GetOutletByUserUseCase
import org.palina.pos.use_case.outlet.impl.GetOutletByUserUseCaseImpl
import org.palina.pos.use_case.producto.AddNewProductUseCase
import org.palina.pos.use_case.producto.GetProductByCodeUseCase
import org.palina.pos.use_case.producto.ListProductUseCase
import org.palina.pos.use_case.producto.UpdateStockUseCase
import org.palina.pos.use_case.producto.impl.AddNewProductUseCaseImpl
import org.palina.pos.use_case.producto.impl.GetProductByCodeUseCaseImpl
import org.palina.pos.use_case.producto.impl.ListProductUseCaseImpl
import org.palina.pos.use_case.producto.impl.UpdateStockUseCaseImpl
import org.palina.pos.use_case.sale.AddPaymentUseCase
import org.palina.pos.use_case.sale.CashPaymentUseCase
import org.palina.pos.use_case.sale.GetOpenSalesUseCase
import org.palina.pos.use_case.sale.LayawayPaymentUseCase
import org.palina.pos.use_case.sale.impl.AddPaymentUseCaseImpl
import org.palina.pos.use_case.sale.impl.CashPaymentUseCaseImpl
import org.palina.pos.use_case.sale.impl.GetOpenSalesUseCaseImpl
import org.palina.pos.use_case.sale.impl.LayawayPaymentUseCaseImpl
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
    LayawayPaymentUseCase layawayPaymentUseCase(final UpdateStockUseCase updateStockUseCase,
                                             final OutletService outletService,
                                             final SaleService saleService,
                                             final ProductService productService,
                                             final UserOutletService userOutletService){
        return new LayawayPaymentUseCaseImpl(updateStockUseCase,
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

    @Bean
    GetProductByCodeUseCase getProductByCodeUseCase(final ProductService productService){
        return new GetProductByCodeUseCaseImpl(productService)
    }

    @Bean
    GetOpenSalesUseCase getOpenSalesUseCase(final SaleService saleService){
        return new GetOpenSalesUseCaseImpl(saleService);
    }

    @Bean
    AddPaymentUseCase addPaymentUseCase(final SaleRepository saleRepository){
        return new AddPaymentUseCaseImpl(saleRepository);
    }

    @Bean
    CashReconciliationUseCase cashReconciliationUseCase( final SaleService saleService,
                                        final SaleBalanceService saleBalanceService){
        return new CashReconciliationUseCaseImpl(saleService, saleBalanceService)
    }

    @Bean
    RegistrarAsistenciaUseCase registrarAsistenciaUseCase(final UserOutletService userOutletService,
                                        final UserService userService,
                                        final AsistenciaService asistenciaService){
        return new RegistrarAsistenciaUseCaseImpl(userOutletService, userService, asistenciaService)
    }

    @Bean
    CalcularCajaUseCase calcularCajaUseCase(CajaService cajaService,
                                            SaleService saleService){
        return new CalcularCajaUseCaseImpl(cajaService, saleService)
    }
}
