package org.palina.pos.repository

import org.palina.pos.model.SaleBalanceModel
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query;

interface SaleBalanceRepository extends JpaRepository<SaleBalanceModel, Long> {

    @Query("SELECT s FROM SaleBalanceModel s WHERE s.id = (SELECT MAX(s2.id) FROM SaleBalanceModel s2)")
    SaleBalanceModel findSaleBalanceWithMaxId()
}
