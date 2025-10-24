package org.palina.pos.model

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Table

import java.time.LocalDateTime


@Entity
@Table(name = "caja")
class CajaModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "monto")
    private BigDecimal monto

    @Column(name = "fecha_hora")
    private LocalDateTime fechaHora

    @Column(name = "tipo_caja")
    private String tipoCaja

    Long getId() {
        return id
    }

    void setId(Long id) {
        this.id = id
    }

    BigDecimal getMonto() {
        return monto
    }

    void setMonto(BigDecimal monto) {
        this.monto = monto
    }

    LocalDateTime getFechaHora() {
        return fechaHora
    }

    void setFechaHora(LocalDateTime fechaHora) {
        this.fechaHora = fechaHora
    }

    String getTipoCaja() {
        return tipoCaja
    }

    void setTipoCaja(String tipoCaja) {
        this.tipoCaja = tipoCaja
    }
}
