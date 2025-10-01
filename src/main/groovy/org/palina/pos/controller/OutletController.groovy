package org.palina.pos.controller

import org.palina.pos.dto.GeneralResponseDto
import org.palina.pos.dto.OutletDto
import org.palina.pos.dto.ProductDto
import org.palina.pos.model.UserModel
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
@RequestMapping("/api/v1/outlet")
class OutletController {

    private static final Logger log = LoggerFactory.getLogger(OutletController.class);

    private final GetOutletByUserUseCase getOutletByUserUseCase

    OutletController(GetOutletByUserUseCase getOutletByUserUseCase) {
        this.getOutletByUserUseCase = getOutletByUserUseCase
    }

    @ResponseBody
    @PostMapping("getByUser")
    ResponseEntity<GeneralResponseDto> getByUser(@RequestBody UserModel req) {
        log.info("getByUser req {}", req)
        def res = new ResponseEntity<GeneralResponseDto>(getOutletByUserUseCase.execute(req), HttpStatus.OK)
        log.info("... getByUser res {}", res)
        return res
    }

}
