package org.palina.pos.repository

import org.palina.pos.model.SaleModel
import org.springframework.data.jpa.repository.JpaRepository

interface SaleRepository extends JpaRepository<SaleModel, Long>{

    List<SaleModel> findAllBySaleTypeAndSaleClosed(String saleType, boolean saleClosed)
}