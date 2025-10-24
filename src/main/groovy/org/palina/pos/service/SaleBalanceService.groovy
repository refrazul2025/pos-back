package org.palina.pos.service

import org.palina.pos.model.SaleBalanceModel
import org.palina.pos.repository.SaleBalanceRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service;

@Service
class SaleBalanceService {

    @Autowired
    private SaleBalanceRepository repository


    List<SaleBalanceModel> findAll() {
        return repository.findAll()
    }

    Optional<SaleBalanceModel> findById(Long id) {
        return repository.findById(id)
    }

    SaleBalanceModel save(SaleBalanceModel saleBalance) {
        return repository.save(saleBalance)
    }

    void delete(Long id) {
        repository.deleteById(id)
    }

    SaleBalanceModel findSaleBalanceWithMaxId(){
        return repository.findSaleBalanceWithMaxId()
    }

}