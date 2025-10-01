package org.palina.pos.use_case.outlet

import org.palina.pos.dto.GeneralResponseDto
import org.palina.pos.dto.OutletDto
import org.palina.pos.model.UserModel

interface GetOutletByUserUseCase {

    GeneralResponseDto<OutletDto> execute(UserModel userModel)
}