package org.palina.pos.use_case.asistencia.impl

import org.palina.pos.dto.GeneralResponseDto
import org.palina.pos.dto.UserOutletDto
import org.palina.pos.model.AsistenciaModel
import org.palina.pos.model.UserModel
import org.palina.pos.service.AsistenciaService
import org.palina.pos.service.UserOutletService
import org.palina.pos.service.UserService
import org.palina.pos.use_case.asistencia.RegistrarAsistenciaUseCase

import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

class RegistrarAsistenciaUseCaseImpl implements RegistrarAsistenciaUseCase{

    private final UserOutletService userOutletService
    private final UserService userService
    private final AsistenciaService asistenciaService

    RegistrarAsistenciaUseCaseImpl(UserOutletService userOutletService,
                                   UserService userService,
                                   AsistenciaService asistenciaService) {
        this.userOutletService = userOutletService
        this.userService = userService
        this.asistenciaService = asistenciaService
    }

    @Override
    GeneralResponseDto<AsistenciaModel> execute(Long idUser) {
        UserOutletDto userOutletDto = userOutletService.findByUser(idUser)
        if(!userOutletDto){
            return GeneralResponseDto.error("003", "Usuario no encontrado")
        }

        UserModel userModel = userService.findById(userOutletDto.userId)

        if(!userModel){
            return GeneralResponseDto.error("003", "Usuario no encontrado")
        }

        LocalDateTime fechaHora = LocalDateTime.now().minusHours(6)
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HHmmss");
        String horaString = fechaHora.format(formatter);

        AsistenciaModel asistenciaModel = asistenciaService.getByUserAndDate(userModel.getUsername(), fechaHora.toLocalDate())

        if(asistenciaModel){
            return GeneralResponseDto.error("004", "El dìa de hoy ya registro asistencia")
        }

        AsistenciaModel registro = new AsistenciaModel(usuario: userModel.getUsername(),
                                                        fecha: fechaHora.toLocalDate(),
                                                        hora: Integer.valueOf(horaString))


        return GeneralResponseDto.ok(asistenciaService.save(registro))
    }
}
