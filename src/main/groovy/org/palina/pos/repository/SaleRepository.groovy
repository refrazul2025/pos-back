package org.palina.pos.repository

import jakarta.transaction.Transactional
import org.palina.pos.model.SaleBalanceModel
import org.palina.pos.model.SaleModel
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Modifying
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param

import java.time.LocalDate

interface SaleRepository extends JpaRepository<SaleModel, Long>{

    List<SaleModel> findAllBySaleTypeAndSaleClosed(String saleType, boolean saleClosed)

    List<SaleModel> findAllByReconciled(boolean reconciled)


    @Query('''
        SELECT s FROM SaleModel s
        WHERE s.reconciled = false
        AND s.saleDate <= :date
    ''')
    List<SaleModel> findUnreconciledBeforeOrOn(@Param('date') LocalDate date)

    @Modifying
    @Transactional
    @Query('''
        UPDATE SaleModel s
        SET s.reconciled = true
        WHERE s.reconciled = false
        AND s.saleDate <= :date
    ''')
    int markAsReconciledBeforeOrOn(@Param('date') LocalDate date)
}