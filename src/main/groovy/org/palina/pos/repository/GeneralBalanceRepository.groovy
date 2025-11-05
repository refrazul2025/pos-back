package org.palina.pos.repository

import org.palina.pos.model.GeneralBalanceModel
import org.springframework.data.jpa.repository.JpaRepository

interface GeneralBalanceRepository extends JpaRepository<GeneralBalanceModel, Long> {
}