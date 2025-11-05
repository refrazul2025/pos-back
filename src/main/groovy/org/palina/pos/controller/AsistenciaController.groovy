package org.palina.pos.controller

import org.palina.pos.dto.GeneralResponseDto
import org.palina.pos.model.AsistenciaModel
import org.palina.pos.use_case.asistencia.RegistrarAsistenciaUseCase
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/v1/asistencias")
class AsistenciaController {

    private static final Logger log = LoggerFactory.getLogger(AsistenciaController.class);

    private final RegistrarAsistenciaUseCase registrarAsistenciaUseCase

    AsistenciaController(RegistrarAsistenciaUseCase registrarAsistenciaUseCase) {
        this.registrarAsistenciaUseCase = registrarAsistenciaUseCase
    }

    // ✅ Registrar asistencia (entrada automática con fecha y hora actual)
    @PostMapping("/registrar")
    GeneralResponseDto<AsistenciaModel> registrarAsistencia(@RequestParam("idUser") Long idUser) {
        log.info("registrarAsistencia req {}", idUser)

        def res = registrarAsistenciaUseCase.execute(idUser)
        log.info("registrarAsistencia res {}", res)
        return res
    }

   /* @GetMapping
    public ResponseEntity<List<Asistencia>> listarAsistencias() {
        return ResponseEntity.ok(asistenciaService.listarAsistencias());
    }

    // ✅ Buscar asistencias por usuario
    @GetMapping("/usuario/{usuario}")
    public ResponseEntity<List<Asistencia>> obtenerPorUsuario(@PathVariable String usuario) {
        List<Asistencia> asistencias = asistenciaService.obtenerAsistenciasPorUsuario(usuario);
        if (asistencias.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(asistencias);
    }*/
}