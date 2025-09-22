package com.cibertec.ModuloStandsSAC.Entity;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;

@Entity
@Data
@Table(name = "detallealquiler")
public class DetalleAlquiler {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idDetalle;

    @ManyToOne
    @JoinColumn(name = "id_alquiler", nullable = false)
    private RegistroAlquiler alquiler;

    @ManyToOne
    @JoinColumn(name = "id_mobiliario", nullable = false)
    private Mobiliario mobiliario;

    @Column(nullable = false)
    private Integer cantidad;

    @Column(nullable = false, precision = 18, scale = 2)
    private BigDecimal precioUnitario;

    @Column(nullable = false, precision = 18, scale = 2)
    private BigDecimal subtotal;

    @Column(nullable = false)
    private Boolean estado = true;
}
