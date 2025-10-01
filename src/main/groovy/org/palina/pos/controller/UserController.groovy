package org.palina.pos.controller

import org.palina.pos.dto.GeneralResponseDto
import org.palina.pos.dto.UserDto
import org.palina.pos.use_case.user.ValidateUserUseCase
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
@RequestMapping("/api/v1/user")
class UserController {

    private static final Logger log = LoggerFactory.getLogger(UserController.class);

    private ValidateUserUseCase validateUserUseCase

    UserController(ValidateUserUseCase validateUserUseCase) {
        this.validateUserUseCase = validateUserUseCase
    }

    @ResponseBody
    @PostMapping("validate")
    ResponseEntity<GeneralResponseDto> validate(@RequestBody UserDto req){
        log.info("validate req {}", req)
        def res = new ResponseEntity<GeneralResponseDto>(validateUserUseCase.execute(req), HttpStatus.OK)
        log.info("... validate res {}", res)
        return res
    }
}
