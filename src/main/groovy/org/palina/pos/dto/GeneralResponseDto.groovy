package org.palina.pos.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import org.slf4j.MDC;

import java.io.Serializable;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public record GeneralResponseDto<T>(
        String codigo,
        String mensaje,
        T resultado,
        String folio,
        String info,
        boolean advertencias
) {
    // Constructor compacto con valores por defecto
    public GeneralResponseDto {
        if (mensaje == null) {
            mensaje = "Operación Exitosa.";
        }
        if (folio == null) {
            String traceId = MDC.get("traceId");
            String spanId = MDC.get("spanId");
            folio = (traceId != null && spanId != null) ? traceId + "-" + spanId : null;
        }
    }

    // Método de ayuda para respuestas exitosas
    public static <T> GeneralResponseDto<T> ok(T resultado) {
        return new GeneralResponseDto<>("000", "Operación Exitosa.", resultado, null, null, false);
    }

    // Método de ayuda para respuestas exitosas con mensaje personalizado
    public static <T> GeneralResponseDto<T> ok(T resultado, String mensaje) {
        return new GeneralResponseDto<>("000", mensaje, resultado, null, null, false);
    }

    // Método de ayuda para errores
    public static <T> GeneralResponseDto<T> error(String codigo, String mensaje) {
        return new GeneralResponseDto<>(codigo, mensaje, null, null, null, true);
    }
}
