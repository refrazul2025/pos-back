package org.palina.pos.dto

import java.time.LocalDate

class PaymentDto{

    private Long id
    private Long idSale
    private BigDecimal amountPaid
    private LocalDate paymentDate
    private String paymentType

    Long getId() {
        return id
    }

    void setId(Long id) {
        this.id = id
    }

    Long getIdSale() {
        return idSale
    }

    void setIdSale(Long idSale) {
        this.idSale = idSale
    }

    BigDecimal getAmountPaid() {
        return amountPaid
    }

    void setAmountPaid(BigDecimal amountPaid) {
        this.amountPaid = amountPaid
    }

    LocalDate getPaymentDate() {
        return paymentDate
    }

    void setPaymentDate(LocalDate paymentDate) {
        this.paymentDate = paymentDate
    }

    String getPaymentType() {
        return paymentType
    }

    void setPaymentType(String paymentType) {
        this.paymentType = paymentType
    }

    @Override
    public String toString() {
        return "PaymentDto{" +
                "id=" + id +
                ", idSale=" + idSale +
                ", amountPaid=" + amountPaid +
                ", paymentDate=" + paymentDate +
                ", paymentType='" + paymentType + '\'' +
                '}';
    }
}