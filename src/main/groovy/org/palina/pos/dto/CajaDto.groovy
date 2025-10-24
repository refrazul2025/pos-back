package org.palina.pos.dto

import java.time.LocalDate

class CajaDto {

    private BigDecimal monto
    private LocalDate fecha
    private String tipo

    BigDecimal getMonto() {
        return monto
    }

    void setMonto(BigDecimal monto) {
        this.monto = monto
    }

    LocalDate getFecha() {
        return fecha
    }

    void setFecha(LocalDate fecha) {
        this.fecha = fecha
    }

    String getTipo() {
        return tipo
    }

    void setTipo(String tipo) {
        this.tipo = tipo
    }
}
