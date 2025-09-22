package org.palina.pos.controller

import org.palina.pos.dto.GeneralResponseDto
import org.palina.pos.model.UserModel
import org.palina.pos.use_case.user.impl.ValidateUserUseCaseImpl
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/v1/sale")
class UserController {

    private static final Logger log = LoggerFactory.getLogger(UserController.class);

    private final ValidateUserUseCaseImpl validateUserUseCase

    GeneralResponseDto<UserModel> validate(@RequestBody UserModel req){
        log.info("validate req {}", req)
        GeneralResponseDto res = validateUserUseCase.execute(req)
        log.info("... validate res {}", res)
        return res
    }
}
