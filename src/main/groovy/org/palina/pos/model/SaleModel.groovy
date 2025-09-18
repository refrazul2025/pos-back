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
    private Long id

    @Column(name = "sale_date")
    private LocalDate saleDate

    @Column(name = "sale_type")
    private String saleType

    private BigDecimal total

    @Column(name = "sale_closed")
    private boolean saleClosed

    @Column
    private String customer

    @ManyToOne
    @JoinColumn(name = "id_outlet", nullable = false)
    private OutletModel outlet

    @OneToMany(mappedBy = "sale", cascade = CascadeType.ALL)
    private List<SaleDetailModel> saleDetails

    @OneToMany(mappedBy = "sale", cascade = CascadeType.ALL)
    private List<PaymentModel> payments
}
