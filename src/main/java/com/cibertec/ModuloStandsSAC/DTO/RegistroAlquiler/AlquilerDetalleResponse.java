package com.cibertec.ModuloStandsSAC.DTO.RegistroAlquiler;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@AllArgsConstructor
public class AlquilerDetalleResponse {
    private Integer idAlquiler;
    private Integer idDetalle;
    private LocalDate fechaAlquiler;
    private String nombreMobiliario;
    private int cantidad;
    private BigDecimal precioUnitario;
    private BigDecimal subtotal;
}
