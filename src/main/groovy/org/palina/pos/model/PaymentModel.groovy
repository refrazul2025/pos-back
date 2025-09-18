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
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_sale", nullable = false)
    private SaleModel sale

    @Column(name = "amount_paid")
    private BigDecimal amountPaid

    @Column(name = "payment_date")
    private LocalDate paymentDate

    @Column(name = "payment_type")
    private String paymentType
}
