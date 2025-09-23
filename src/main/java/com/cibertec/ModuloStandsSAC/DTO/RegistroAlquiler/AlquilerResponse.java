package com.cibertec.ModuloStandsSAC.DTO.RegistroAlquiler;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;
@Data
public class AlquilerResponse {

    private Integer idAlquiler;
    private String nombreProyecto;
    private LocalDate fechaAlquiler;
    private LocalDate fechaDevolucionEstimada;
    private String estadoAlquiler;
    private BigDecimal total;
    private Boolean estado;
}
