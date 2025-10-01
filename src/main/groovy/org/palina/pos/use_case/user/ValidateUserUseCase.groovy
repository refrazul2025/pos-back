package org.palina.pos.use_case.user

import org.palina.pos.dto.GeneralResponseDto
import org.palina.pos.dto.UserDto

interface ValidateUserUseCase {

    GeneralResponseDto<UserDto> execute(UserDto user)

}