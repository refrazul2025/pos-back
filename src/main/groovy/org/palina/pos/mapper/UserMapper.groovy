package org.palina.pos.mapper

import org.palina.pos.dto.UserDto
import org.palina.pos.model.UserModel

class UserMapper {
    static UserDto toDto(UserModel model) {
        if (model == null) return null;

        return new UserDto(
                id: model.id,
                username: model.username,
                password: model.password,
                email: model.email
        )
    }

    static UserModel toModel(UserDto dto) {
        if (dto == null) return null

        return new UserModel(
                id: dto.id,
                username: dto.username,
                password: dto.password,
                email: dto.email
        )
    }
}
