package org.palina.pos.model

import jakarta.persistence.CascadeType
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne
import jakarta.persistence.OneToMany
import jakarta.persistence.Table

import java.time.LocalDate

@Entity
@Table(name = "sale")
class SaleModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id

    @Column(name = "sale_date")
    LocalDate saleDate

    @Column(name = "sale_type")
    String saleType

    @Column
    BigDecimal total

    @Column(name = "sale_closed")
    boolean saleClosed

    @Column
    String customer

    @Column
    Long userId

    @Column
    boolean reconciled

    @ManyToOne
    @JoinColumn(name = "outlet_id", nullable = false)
    OutletModel outlet

    @OneToMany(mappedBy = "sale", cascade = CascadeType.ALL)
    List<SaleDetailModel> saleDetails

    @OneToMany(mappedBy = "sale", cascade = CascadeType.ALL)
    List<PaymentModel> payments
}
