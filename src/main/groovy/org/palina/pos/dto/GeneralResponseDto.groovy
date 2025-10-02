package org.palina.pos.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import org.slf4j.MDC;

import java.io.Serializable;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class GeneralResponseDto<T> implements Serializable {

    private String codigo;
    private String mensaje;
    private T resultado;
    private String folio;
    private String info;
    private boolean advertencias;

    // 🔹 Constructor vacío (requerido por Jackson)
    public GeneralResponseDto() {
        this(null, null, null, null, null, false);
    }

    // 🔹 Constructor con todos los campos
    public GeneralResponseDto(String codigo,
                              String mensaje,
                              T resultado,
                              String folio,
                              String info,
                              boolean advertencias) {
        this.codigo = codigo;
        this.mensaje = (mensaje != null) ? mensaje : "Operación Exitosa.";
        this.resultado = resultado;

        if (folio != null) {
            this.folio = folio;
        } else {
            String traceId = MDC.get("traceId");
            String spanId = MDC.get("spanId");
            this.folio = (traceId != null && spanId != null) ? traceId + "-" + spanId : null;
        }

        this.info = info;
        this.advertencias = advertencias;
    }

    // 🔹 Métodos estáticos de ayuda
    public static <T> GeneralResponseDto<T> ok(T resultado) {
        return new GeneralResponseDto<>("000", "Operación Exitosa.", resultado, null, null, false);
    }

    public static <T> GeneralResponseDto<T> ok(T resultado, String mensaje) {
        return new GeneralResponseDto<>("000", mensaje, resultado, null, null, false);
    }

    public static <T> GeneralResponseDto<T> error(String codigo, String mensaje) {
        return new GeneralResponseDto<>(codigo, mensaje, null, null, null, true);
    }

    // 🔹 Getters & Setters
    public String getCodigo() { return codigo; }
    public void setCodigo(String codigo) { this.codigo = codigo; }

    public String getMensaje() { return mensaje; }
    public void setMensaje(String mensaje) { this.mensaje = mensaje; }

    public T getResultado() { return resultado; }
    public void setResultado(T resultado) { this.resultado = resultado; }

    public String getFolio() { return folio; }
    public void setFolio(String folio) { this.folio = folio; }

    public String getInfo() { return info; }
    public void setInfo(String info) { this.info = info; }

    public boolean getAdvertencias() { return advertencias; }
    public void setAdvertencias(boolean advertencias) { this.advertencias = advertencias; }

    @Override
    public String toString() {
        return "GeneralResponseDto{" +
                "codigo='" + codigo + '\'' +
                ", mensaje='" + mensaje + '\'' +
                ", resultado=" + resultado +
                ", folio='" + folio + '\'' +
                ", info='" + info + '\'' +
                ", advertencias=" + advertencias +
                '}';
    }
}