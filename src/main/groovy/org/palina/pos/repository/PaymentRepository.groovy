package org.palina.pos.repository

import org.palina.pos.model.PaymentModel
import org.springframework.data.jpa.repository.JpaRepository

interface PaymentRepository extends JpaRepository<PaymentModel, Long>{
}
