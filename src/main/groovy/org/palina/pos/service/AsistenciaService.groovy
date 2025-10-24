package org.palina.pos.service

import org.palina.pos.model.AsistenciaModel
import org.palina.pos.repository.AsistenciaRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

import java.time.LocalDate;

@Service
public class AsistenciaService {

    @Autowired
    private  AsistenciaRepository asistenciaRepository

    AsistenciaModel save(AsistenciaModel asistenciaModel) {
        return asistenciaRepository.save(asistenciaModel);
    }

    List<AsistenciaModel> listarAsistencias() {
        return asistenciaRepository.findAll();
    }

    List<AsistenciaModel> getByUser(String usuario) {
        return asistenciaRepository.findByUsuario(usuario);
    }

    AsistenciaModel getByUserAndDate(String user, LocalDate fecha){
        return asistenciaRepository.findByUsuarioAndFecha(user, fecha)
    }
}
