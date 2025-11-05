package org.palina.pos.model

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Table

import java.time.LocalDate
import java.time.LocalDateTime

@Entity
@Table(name = "asistencias")
class AsistenciaModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String usuario;

    @Column(name = "fecha", nullable = false)
    private LocalDate fecha;

    @Column(name = "hora", nullable = false)
    private Integer hora;

    AsistenciaModel() {}

    AsistenciaModel(String usuario, LocalDate fecha, Integer hora) {
        this.usuario = usuario;
        this.fecha = fecha;
        this.hora = hora;
    }

    // Getters y Setters
    Long getId() { return id; }
    void setId(Long id) { this.id = id; }

    String getUsuario() { return usuario; }
    void setUsuario(String usuario) { this.usuario = usuario; }

    LocalDateTime getFechaHoraEntrada() { return fechaHoraEntrada; }
     void setFechaHoraEntrada(LocalDateTime fechaHoraEntrada) { this.fechaHoraEntrada = fechaHoraEntrada; }

}
