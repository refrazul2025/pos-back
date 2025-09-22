package org.palina.pos.dto

import java.time.LocalDate

class PaymentDto{

    Long id
    Long idSale
    BigDecimal amountPaid
    LocalDate paymentDate
    String paymentType
}