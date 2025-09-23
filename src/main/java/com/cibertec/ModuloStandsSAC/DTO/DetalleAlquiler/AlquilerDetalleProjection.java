package com.cibertec.ModuloStandsSAC.DTO.DetalleAlquiler;

import java.time.LocalDate;

public interface AlquilerDetalleProjection {

    Integer getIdAlquiler();
    Integer getIdDetalle();
    LocalDate getFechaAlquiler();
    String getNombreMobiliario();
    Integer getCantidad();
    Double getPrecioUnitario();
    Double getSubtotal();
}
