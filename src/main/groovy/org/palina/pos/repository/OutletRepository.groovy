package org.palina.pos.repository

import org.palina.pos.model.OutletModel
import org.springframework.data.jpa.repository.JpaRepository

interface OutletRepository extends JpaRepository<OutletModel,Long>{
    OutletModel findByName(String name)
}