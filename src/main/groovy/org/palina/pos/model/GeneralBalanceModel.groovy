package org.palina.pos.model

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "general_balance")
class GeneralBalanceModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "reference_id")
    private Long referenceId;

    @Column(name = "reference_type", nullable = false, length = 50)
    private String referenceType;

    private BigDecimal cargo = BigDecimal.ZERO;
    private BigDecimal abono = BigDecimal.ZERO;
    private BigDecimal saldo = BigDecimal.ZERO;

    @Column(name = "balance_date", nullable = false)
    private LocalDate balanceDate;

    private String description;

    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt = LocalDateTime.now();

    Long getId() {
        return id
    }

    void setId(Long id) {
        this.id = id
    }

    Long getReferenceId() {
        return referenceId
    }

    void setReferenceId(Long referenceId) {
        this.referenceId = referenceId
    }

    String getReferenceType() {
        return referenceType
    }

    void setReferenceType(String referenceType) {
        this.referenceType = referenceType
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

    LocalDate getBalanceDate() {
        return balanceDate
    }

    void setBalanceDate(LocalDate balanceDate) {
        this.balanceDate = balanceDate
    }

    String getDescription() {
        return description
    }

    void setDescription(String description) {
        this.description = description
    }

    LocalDateTime getCreatedAt() {
        return createdAt
    }

    void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt
    }
}