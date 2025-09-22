package com.cibertec.ModuloStandsSAC.DTO.DetalleAlquiler;

import com.cibertec.ModuloStandsSAC.Entity.Mobiliario;
import com.cibertec.ModuloStandsSAC.Entity.RegistroAlquiler;
import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class DetalleRequest {

    private Integer idDetalle;
    private Integer idRegistroAlquiler;
    private Integer idMobiliario;
    private Integer cantidad;
    private BigDecimal precioUnitario;
    private BigDecimal subTotal;
    private Boolean estado;
}
