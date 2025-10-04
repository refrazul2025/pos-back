package org.palina.pos.controller

import org.palina.pos.dto.GeneralResponseDto
import org.palina.pos.dto.PaymentDto
import org.palina.pos.dto.SaleDto
import org.palina.pos.use_case.sale.AddPaymentUseCase
import org.palina.pos.use_case.sale.CashPaymentUseCase
import org.palina.pos.use_case.sale.GetOpenSalesUseCase
import org.palina.pos.use_case.sale.LayawayPaymentUseCase
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseBody
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/v1/sale")
class SaleController {

    private static final Logger log = LoggerFactory.getLogger(SaleController.class);

    private final CashPaymentUseCase cashPaymentUseCase
    private final LayawayPaymentUseCase layawayPaymentUseCase
    private final GetOpenSalesUseCase getOpenSalesUseCase
    private final AddPaymentUseCase addPaymentUseCase

    SaleController(CashPaymentUseCase cashPaymentUseCase,
                    LayawayPaymentUseCase layawayPaymentUseCase,
                    GetOpenSalesUseCase getOpenSalesUseCase,
                    AddPaymentUseCase addPaymentUseCase) {
        this.cashPaymentUseCase = cashPaymentUseCase
        this.layawayPaymentUseCase = layawayPaymentUseCase
        this.getOpenSalesUseCase = getOpenSalesUseCase
        this.addPaymentUseCase = addPaymentUseCase
    }

    @ResponseBody
    @PostMapping("cash")
    ResponseEntity<GeneralResponseDto> cash(@RequestBody SaleDto req) {
        log.info("cash req {}", req)
        GeneralResponseDto<SaleDto> res = cashPaymentUseCase.execute(req)
        log.info("... cash res {}", res)
        return new ResponseEntity<>(res,HttpStatus.CREATED)
    }

    @ResponseBody
    @PostMapping("layaway") //apartado
    ResponseEntity<GeneralResponseDto> apartado(@RequestBody SaleDto req) {
        log.info("layaway req {}", req)
        GeneralResponseDto<SaleDto> res = layawayPaymentUseCase.execute(req)
        log.info("... layaway res {}", res)
        return new ResponseEntity<>(res,HttpStatus.CREATED)
    }

    @ResponseBody
    @GetMapping("layaway")
    ResponseEntity<GeneralResponseDto> getAllApartados() {
        log.info("getAllApartados ")
        GeneralResponseDto<SaleDto> res = getOpenSalesUseCase.execute()
        log.info("... getAllApartados res {}", res)
        return new ResponseEntity<>(res,HttpStatus.OK)
    }

    @ResponseBody
    @PostMapping("addPayment/{saleId}")
    ResponseEntity<GeneralResponseDto> addPayment(@PathVariable("saleId") Long saleId,  @RequestBody PaymentDto req) {
        log.info("addPayment req {}", req)
        GeneralResponseDto<SaleDto> res = addPaymentUseCase.execute(saleId,req)
        log.info("... layaway res {}", res)
        return new ResponseEntity<>(res,HttpStatus.CREATED)
    }

}