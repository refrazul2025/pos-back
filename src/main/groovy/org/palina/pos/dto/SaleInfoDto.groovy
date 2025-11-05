package org.palina.pos.dto

import java.time.LocalDate

class SaleInfoDto {

    LocalDate saleDate
    String saleType
    BigDecimal total
    String customer
    String payments
    String products
    Long userId
    Long outletId

}
