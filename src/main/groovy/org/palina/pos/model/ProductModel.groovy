package org.palina.pos.model

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne
import jakarta.persistence.Table

import java.time.LocalDate
import java.time.LocalDateTime

@Entity
@Table(name = "product")
class ProductModel {

    @Id
    @Column
    String code

    @Column
    String description

    @Column
    String category2

    @Column
    String category1

    @Column
    String barcode

    @Column(name = "purchase_price")
    BigDecimal purchasePrice

    @Column(name = "sale_price")
    BigDecimal salePrice;

    @Column(name = "current_stock")
    Integer currentStock

    @ManyToOne
    @JoinColumn(name = "outlet_id", nullable = false)
    OutletModel outlet

    @Column(name = "create_at")
    LocalDateTime createAt

    @Column(name = "update_at")
    LocalDateTime updateAt

}
