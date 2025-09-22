package com.cibertec.ModuloStandsSAC.Entity;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Data
@Table(name = "registroalquiler")
public class RegistroAlquiler {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idAlquiler;

    @ManyToOne
    @JoinColumn(name = "id_proyecto", nullable = false)
    private RegistroProyecto idProyecto;

    @Column(nullable = false)
    private LocalDate fechaAlquiler;

    @Column(nullable = false)
    private LocalDate fechaDevolucionEstimada;

    @Column(nullable = false, length = 50)
    private String estadoAlquiler;

    @Column(nullable = false, precision = 18, scale = 2)
    private BigDecimal total;

    @Column(nullable = false)
    private Boolean estado = true;
}
