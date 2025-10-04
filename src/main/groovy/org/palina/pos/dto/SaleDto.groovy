package org.palina.pos.dto

import java.time.LocalDate

class SaleDto{

    Long id
    LocalDate saleDate
    String saleType
    BigDecimal total
    boolean saleClosed
    String customer
    Long outletId
    String paymentType
    List<SaleDetailDto> saleDetails
    List<PaymentDto> payments

    @Override
    public String toString() {
        return "SaleDto{" +
                "id=" + id +
                ", saleDate=" + saleDate +
                ", saleType='" + saleType + '\'' +
                ", total=" + total +
                ", saleClosed=" + saleClosed +
                ", customer='" + customer + '\'' +
                ", outletId=" + outletId +
                ", paymentType='" + paymentType + '\'' +
                ", saleDetails=" + saleDetails +
                ", payments=" + payments +
                '}';
    }
}