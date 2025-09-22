package org.palina.pos.use_case.user.impl

import org.palina.pos.dto.GeneralResponseDto
import org.palina.pos.model.UserModel
import org.palina.pos.service.UserService
import org.palina.pos.use_case.user.ValidateUserUseCase

class ValidateUserUseCaseImpl implements ValidateUserUseCase{

    private final UserService userService


    GeneralResponseDto<UserModel> execute(UserModel user){
        UserModel userModel = userService.findByUserName(user?.username)
        if(!userModel.password.equals(user?.password)){
            return GeneralResponseDto.error("002", "Usuario / contrseña inválido")
        }

        return GeneralResponseDto.ok(userModel)
    }

}
