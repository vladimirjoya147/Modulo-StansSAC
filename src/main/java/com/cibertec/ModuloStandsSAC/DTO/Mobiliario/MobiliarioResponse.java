package com.cibertec.ModuloStandsSAC.DTO.Mobiliario;

import com.cibertec.ModuloStandsSAC.Entity.Categoria;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;
@Data
public class MobiliarioResponse {

    private Integer idMobiliario;
    private String nombre;
    private String nombreCategoria;
    private String estadoMobiliario;
    private String material;
    private Integer vidaUtil;
    private LocalDate fechaAdquisicion;
    private Boolean estado;
    private BigDecimal precioUnitario;
    private Integer stock;
}
