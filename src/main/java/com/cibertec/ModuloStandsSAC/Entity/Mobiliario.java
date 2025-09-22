package com.cibertec.ModuloStandsSAC.Entity;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Data
@Table(name = "Mobiliario")
public class Mobiliario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idMobiliario;

    @Column(nullable = false, length = 150)
    private String nombre;

    @ManyToOne
    @JoinColumn(name = "categoria_id", nullable = false)
    private Categoria categoriaId;

    @Column(nullable = false, length = 50)
    private String estadoMobiliario;

    @Column(length = 100)
    private String material;

    private Integer vidaUtil;

    private LocalDate fechaAdquisicion;

    @Column(nullable = false)
    private Boolean estado = true;

    @Column(nullable = false, precision = 18, scale = 2)
    private BigDecimal precioUnitario;

    @Column(nullable = false)
    private Integer stock;
}
