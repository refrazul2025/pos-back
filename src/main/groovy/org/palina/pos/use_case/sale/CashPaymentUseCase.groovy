package org.palina.pos.use_case.sale

import org.palina.pos.dto.GeneralResponseDto
import org.palina.pos.dto.SaleDto

interface CashPaymentUseCase {

    GeneralResponseDto<SaleDto> execute(SaleDto sale);
}
