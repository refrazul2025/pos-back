package org.palina.pos.model

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne
import jakarta.persistence.Table

import java.time.LocalDate

@Entity
@Table(name = "payment")
class PaymentModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @ManyToOne
    @JoinColumn(name = "sale_id", nullable = false)
    SaleModel sale

    @Column(name = "amount_paid")
    BigDecimal amountPaid

    @Column(name = "payment_date")
    LocalDate paymentDate

    @Column(name = "payment_type")
    String paymentType

    @Column(name = "user_id")
    Long userId
}
