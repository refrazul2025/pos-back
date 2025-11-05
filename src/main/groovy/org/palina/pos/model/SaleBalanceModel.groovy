package org.palina.pos.model

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "sale_balance")
class SaleBalanceModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private BigDecimal cargo = BigDecimal.ZERO;
    private BigDecimal abono = BigDecimal.ZERO;
    private BigDecimal saldo = BigDecimal.ZERO;

    private String description;

    @Column(name = "balance_date", nullable = false)
    private LocalDate balanceDate;

    Long getId() {
        return id
    }

    void setId(Long id) {
        this.id = id
    }

    BigDecimal getCargo() {
        return cargo
    }

    void setCargo(BigDecimal cargo) {
        this.cargo = cargo
    }

    BigDecimal getAbono() {
        return abono
    }

    void setAbono(BigDecimal abono) {
        this.abono = abono
    }

    BigDecimal getSaldo() {
        return saldo
    }

    void setSaldo(BigDecimal saldo) {
        this.saldo = saldo
    }

    String getDescription() {
        return description
    }

    void setDescription(String description) {
        this.description = description
    }

    LocalDate getBalanceDate() {
        return balanceDate
    }

    void setBalanceDate(LocalDate balanceDate) {
        this.balanceDate = balanceDate
    }
}
