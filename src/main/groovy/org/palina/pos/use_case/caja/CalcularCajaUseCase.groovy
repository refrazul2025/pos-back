package org.palina.pos.use_case.caja

import org.palina.pos.dto.CajaDto
import org.palina.pos.dto.GeneralResponseDto

interface CalcularCajaUseCase {

    GeneralResponseDto<List<CajaDto>> execute()
}
