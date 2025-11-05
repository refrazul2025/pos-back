package org.palina.pos.repository

import org.palina.pos.model.AsistenciaModel
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;

interface AsistenciaRepository extends JpaRepository<AsistenciaModel, Long> {
    List<AsistenciaModel> findByUsuario(String usuario)
    AsistenciaModel findByUsuarioAndFecha(String usuario, LocalDate fecha)
}
