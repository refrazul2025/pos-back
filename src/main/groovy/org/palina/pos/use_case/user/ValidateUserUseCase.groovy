package org.palina.pos.use_case.user

import org.palina.pos.dto.GeneralResponseDto
import org.palina.pos.model.UserModel

interface ValidateUserUseCase {

    GeneralResponseDto<UserModel> execute(UserModel user)

}