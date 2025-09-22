package org.palina.pos.model

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne
import jakarta.persistence.Table

@Entity
@Table(name = "sale_detail")
class SaleDetailModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id

    @ManyToOne
    @JoinColumn(name = "sale_id", nullable = false)
    SaleModel sale

    @Column(name = "product_code")
    String productCode

    Integer quantity

    @Column(name = "unit_price")
    BigDecimal unitPrice

    BigDecimal subtotal
}
