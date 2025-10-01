package org.palina.pos.use_case.user_outlet.impl

import org.palina.pos.dto.UserOutletDto
import org.palina.pos.service.UserOutletService
import org.palina.pos.use_case.user_outlet.GetByOutletUseCase

class GetByOutletUseCaseImpl implements GetByOutletUseCase{

    private final UserOutletService userOutletService

    GetByOutletUseCaseImpl(UserOutletService userOutletService) {
        this.userOutletService = userOutletService
    }

    UserOutletDto exectue(Long outletId) {
        return userOutletService.findByOutlet(outletId)
    }
}
