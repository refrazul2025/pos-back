package org.palina.pos.use_case.sale

import org.palina.pos.dto.GeneralResponseDto
import org.palina.pos.dto.PaymentDto
import org.palina.pos.dto.SaleDto

interface AddPaymentUseCase {

    GeneralResponseDto<SaleDto> execute(Long saleId, PaymentDto payment)

}