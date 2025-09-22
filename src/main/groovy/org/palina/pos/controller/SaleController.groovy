package org.palina.pos.controller

import org.palina.pos.dto.GeneralResponseDto
import org.palina.pos.dto.SaleDto
import org.palina.pos.use_case.sale.CashPaymentUseCase
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
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

    SaleController(CashPaymentUseCase cashPaymentUseCase) {
        this.cashPaymentUseCase = cashPaymentUseCase
    }

    @ResponseBody
    @PostMapping("cash")
    ResponseEntity<GeneralResponseDto> cash(@RequestBody SaleDto req) {
        log.info("cash req {}", req)
        GeneralResponseDto<SaleDto> res = cashPaymentUseCase.execute(req)
        log.info("... cash res {}", res)
        return new ResponseEntity<>(res,HttpStatus.CREATED)
    }
}