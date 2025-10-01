package org.palina.pos.mapper

import org.palina.pos.dto.UserOutletDto
import org.palina.pos.model.OutletModel
import org.palina.pos.model.UserModel
import org.palina.pos.model.UserOutletModel

class UserOutletMaper {

    static UserOutletDto toDto(UserOutletModel model) {
        if (model == null) return null;

        return new UserOutletDto(
               userId: model?.user?.id,
               outletId: model?.outlet?.id,
               role: model?.role
        )
    }

    static UserOutletModel toModel(UserOutletDto dto) {
        if (dto == null) return null;

        return new UserOutletModel(
                user: new UserModel(id: dto?.userId),
                outlet: new OutletModel(id: dto?.outletId),
                role: dto?.role
        )
    }
}
