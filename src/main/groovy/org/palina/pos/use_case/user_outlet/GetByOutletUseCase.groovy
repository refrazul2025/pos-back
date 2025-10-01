package org.palina.pos.use_case.user_outlet

import org.palina.pos.dto.UserOutletDto

interface GetByOutletUseCase {

    UserOutletDto exectue(Long outletId);
}