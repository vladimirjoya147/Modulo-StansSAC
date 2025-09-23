package com.cibertec.ModuloStandsSAC.DTO.Mobiliario;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;
@Data
public class MobiliarioRequest {
    private Integer idMobiliario;
    private String nombre;
    private Integer idCategoria;
    private String estadoMobiliario;
    private String material;
    private Integer vidaUtil;
    private LocalDate fechaAdquisicion;
    private BigDecimal precioUnitario;
    private Integer stock;
}
