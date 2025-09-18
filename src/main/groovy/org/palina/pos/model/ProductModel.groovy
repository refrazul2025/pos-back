package org.palina.pos.model

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne
import jakarta.persistence.Table

@Entity
@Table(name = "product")
class ProductModel {

    @Id
    @Column
    private String code

    @Column
    private String description

    @Column
    private String category1

    @Column
    private String category2

    @Column
    private String barcode

    @Column(name = "purchase_price")
    private BigDecimal purchasePrice

    @Column(name = "sale_price")
    private BigDecimal salePrice;

    @Column(name = "current_stock")
    private Integer currentStock

    @ManyToOne
    @JoinColumn(name = "outlet_id", nullable = false)
    private OutletModel outlet;
}
