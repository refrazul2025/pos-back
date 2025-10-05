package org.palina.pos.use_case.sale

import org.palina.pos.dto.GeneralResponseDto
import org.palina.pos.dto.SaleDto

interface GetOpenSalesUseCase {

    GeneralResponseDto<List<SaleDto>> execute();
}
