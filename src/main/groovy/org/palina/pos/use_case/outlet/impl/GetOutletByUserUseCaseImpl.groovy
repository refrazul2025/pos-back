package org.palina.pos.use_case.outlet.impl

import org.palina.pos.dto.GeneralResponseDto
import org.palina.pos.dto.OutletDto
import org.palina.pos.mapper.OutletMapper
import org.palina.pos.model.UserModel
import org.palina.pos.model.UserOutletModel
import org.palina.pos.repository.UserOutletRepository
import org.palina.pos.use_case.outlet.GetOutletByUserUseCase

class GetOutletByUserUseCaseImpl implements GetOutletByUserUseCase {

    private final UserOutletRepository userOutletRepository

    GetOutletByUserUseCaseImpl(UserOutletRepository userOutletRepository) {
        this.userOutletRepository = userOutletRepository
    }

    @Override
    GeneralResponseDto<OutletDto> execute(UserModel userModel) {
        UserOutletModel userOutletModel = userOutletRepository.findByIdUserId(userModel.id)
        OutletDto res = OutletMapper.toDto(userOutletModel.outlet)

        return GeneralResponseDto.ok(res)
    }
}
