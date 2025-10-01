package org.palina.pos.use_case.user.impl

import org.palina.pos.dto.GeneralResponseDto
import org.palina.pos.dto.UserDto
import org.palina.pos.mapper.UserMapper
import org.palina.pos.model.UserModel
import org.palina.pos.service.UserService
import org.palina.pos.use_case.user.ValidateUserUseCase

class ValidateUserUseCaseImpl implements ValidateUserUseCase {

    private final UserService userService

    ValidateUserUseCaseImpl(UserService userService) {
        this.userService = userService
    }

    GeneralResponseDto<UserDto> execute(UserDto user){
        UserModel userModel = userService.findByUserName(user?.username)
        if(userModel.password != user?.password){
            return GeneralResponseDto.error("002", "Usuario / contrseña inválido")
        }

        return GeneralResponseDto.ok(UserMapper.toDto(userModel) )
    }

}
