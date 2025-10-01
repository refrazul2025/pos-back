package org.palina.pos.service

import org.palina.pos.dto.UserOutletDto
import org.palina.pos.mapper.UserOutletMaper
import org.palina.pos.repository.UserOutletRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class UserOutletService {

    @Autowired
    private UserOutletRepository userOutletRepository

    UserOutletDto findByOutlet(Long outletId){
        return UserOutletMaper.toDto(userOutletRepository.findByIdOutletId(outletId))
    }

}
