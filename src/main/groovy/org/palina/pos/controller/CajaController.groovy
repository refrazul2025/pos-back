package org.palina.pos.controller

import org.palina.pos.dto.GeneralResponseDto

import org.palina.pos.use_case.caja.CalcularCajaUseCase
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseBody
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/v1/caja")
class CajaController {

    private static final Logger log = LoggerFactory.getLogger(CajaController.class)

    private final CalcularCajaUseCase calcularCajaUseCase

    CajaController(CalcularCajaUseCase calcularCajaUseCase) {
        this.calcularCajaUseCase = calcularCajaUseCase
    }

    @ResponseBody
    @GetMapping
    ResponseEntity<GeneralResponseDto> getCaja(){
        log.info("getCaja req")
        def res = calcularCajaUseCase.execute()
        log.info("...getCaja res {}", res)
        return new ResponseEntity<GeneralResponseDto>(res, HttpStatus.OK)
    }
}