package org.palina.pos.service

import org.palina.pos.model.CajaModel
import org.palina.pos.repository.CajaRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class CajaService {

    @Autowired
    private CajaRepository cajaRepository

    CajaModel getCaja(){
        return cajaRepository.findById(1).get()
    }

    CajaModel save(CajaModel cajaModel){
        return cajaRepository.save(cajaModel)
    }

    CajaModel getCajaVentas(){
        return cajaRepository.findByTipoCaja("VENTAS")
    }

    CajaModel getCajaChica(){
        return cajaRepository.findByTipoCaja("CAJA_CHICA")
    }
}
