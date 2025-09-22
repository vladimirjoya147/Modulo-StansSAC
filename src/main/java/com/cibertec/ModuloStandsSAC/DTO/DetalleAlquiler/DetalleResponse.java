package com.cibertec.ModuloStandsSAC.DTO.DetalleAlquiler;

import com.cibertec.ModuloStandsSAC.Entity.RegistroAlquiler;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
public class DetalleResponse {
    private Integer idDetalle;
    private LocalDate RegistroAlquilerDevolucion;
    private String nombreMobiliario;
    private Integer cantidad;
    private BigDecimal precioUnitario;
    private BigDecimal subTotal;
    private Boolean estado;
}
