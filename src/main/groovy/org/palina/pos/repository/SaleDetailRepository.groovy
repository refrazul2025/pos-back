package org.palina.pos.repository

import org.palina.pos.model.SaleDetailModel
import org.springframework.data.jpa.repository.JpaRepository

interface SaleDetailRepository extends JpaRepository<SaleDetailModel, Long>{

}