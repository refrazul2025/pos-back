package org.palina.pos.service

import org.palina.pos.model.GeneralBalanceModel
import org.palina.pos.repository.GeneralBalanceRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
public class GeneralBalanceService {

    @Autowired
    private GeneralBalanceRepository repository

    GeneralBalanceService(GeneralBalanceRepository repository) {
        this.repository = repository;
    }

    List<GeneralBalanceModel> findAll() {
        return repository.findAll();
    }

    Optional<GeneralBalanceModel> findById(Long id) {
        return repository.findById(id);
    }

    GeneralBalanceModel save(GeneralBalanceModel generalBalance) {
        return repository.save(generalBalance);
    }

    void delete(Long id) {
        repository.deleteById(id);
    }
}