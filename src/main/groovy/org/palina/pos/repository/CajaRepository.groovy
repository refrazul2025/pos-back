package org.palina.pos.repository

import org.palina.pos.model.CajaModel
import org.springframework.data.jpa.repository.JpaRepository

interface CajaRepository extends JpaRepository<CajaModel, Long>{

    CajaModel findByTipoCaja(String tipoCaja)
}