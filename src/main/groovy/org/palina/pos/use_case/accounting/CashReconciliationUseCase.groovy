package org.palina.pos.use_case.accounting

import org.palina.pos.dto.ReconciliationDto

interface CashReconciliationUseCase {

    void execute(ReconciliationDto reconciliationDto)
}
