package org.palina.pos.use_case.sale

import org.palina.pos.dto.GeneralResponseDto
import org.palina.pos.dto.SaleInfoDto

interface GetSalesInfoUseCase {

    GeneralResponseDto<List<SaleInfoDto>> execute(Long user, Long outleId)
}