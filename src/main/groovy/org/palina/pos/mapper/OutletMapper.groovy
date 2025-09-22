package org.palina.pos.mapper

import org.palina.pos.dto.OutletDto
import org.palina.pos.model.OutletModel

class OutletMapper {

    static OutletDto toDto(OutletModel model) {
        if (model == null) return null;

        return new OutletDto(
                id: model.id,
                name: model.name,
                prefix: model.prefix,
                creteAt: model.createAt,
                updateAt: model.updateAt
        );
    }

    static OutletModel toModel(OutletDto dto){
        if (dto == null) return null;

        OutletModel model = new OutletDto(
                id: dto.id,
                name: dto.name,
                prefix: dto.prefix,
                creteAt: dto.creteAt,
                updateAt: dto.updateAt
        )

        return model
    }
}
