package org.palina.pos.service

import org.palina.pos.dto.OutletDto
import org.palina.pos.mapper.OutletMapper
import org.palina.pos.repository.OutletRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class OutletService {

    @Autowired
    private OutletRepository outletRepository

    OutletDto getById(Long id) {
        return OutletMapper.toDto(outletRepository.findById(id).get())
    }

    OutletDto getByName(String name) {
        return OutletMapper.toDto(outletRepository.findByName(name))
    }
}
