package org.palina.pos.controller

import org.palina.pos.dto.GeneralResponseDto
import org.palina.pos.dto.ReconciliationDto
import org.palina.pos.model.UserModel
import org.palina.pos.use_case.accounting.CashReconciliationUseCase
import org.palina.pos.use_case.outlet.GetOutletByUserUseCase
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
@RequestMapping("/api/v1/accounting")
class AccountingController {

    private static final Logger log = LoggerFactory.getLogger(AccountingController.class);

    private final CashReconciliationUseCase cashReconciliationUseCase

    AccountingController(CashReconciliationUseCase cashReconciliationUseCase) {
        this.cashReconciliationUseCase = cashReconciliationUseCase
    }

    @ResponseBody
    @PostMapping("reconciliation")
    ResponseEntity<GeneralResponseDto> reconciliation(@RequestBody ReconciliationDto req) {
        log.info("reconciliation req {}", req)
        cashReconciliationUseCase.execute(req)
        log.info("...ok")
        return new ResponseEntity<GeneralResponseDto>(null, HttpStatus.OK)
    }
}
