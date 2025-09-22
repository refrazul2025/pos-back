package org.palina.pos.service

import org.palina.pos.dto.OutletDto
import org.palina.pos.dto.SaleDto
import org.palina.pos.mapper.SaleMapper
import org.palina.pos.model.PaymentModel
import org.palina.pos.model.SaleModel
import org.palina.pos.repository.SaleRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

import java.time.LocalDateTime

@Service
class SaleService {

    @Autowired
    private SaleRepository saleRepository

    @Autowired
    private OutletService outletService

    SaleDto create(SaleDto sale){
        SaleModel model = SaleMapper.toModel(sale)
        return SaleMapper.toDto( saleRepository.save(model))
    }
}