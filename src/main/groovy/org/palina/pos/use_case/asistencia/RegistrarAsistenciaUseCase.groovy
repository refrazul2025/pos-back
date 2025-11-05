package org.palina.pos.use_case.asistencia

import org.palina.pos.dto.GeneralResponseDto
import org.palina.pos.model.AsistenciaModel

interface RegistrarAsistenciaUseCase {

    GeneralResponseDto<AsistenciaModel> execute(Long idUser)

}