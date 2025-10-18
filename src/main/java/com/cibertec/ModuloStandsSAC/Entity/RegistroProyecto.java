package com.cibertec.ModuloStandsSAC.Entity;

import jakarta.persistence.*;
import lombok.Data;
//Registro
@Entity
@Data
@Table(name = "registroproyecto")
public class RegistroProyecto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idProyecto;

    @Column(nullable = false, length = 150)
    private String nombreProyecto;

    @ManyToOne
    @JoinColumn(name = "id_evento", nullable = false)
    private Evento idEvento;

    @ManyToOne
    @JoinColumn(name = "id_cliente")
    private Cliente cliente;

    @Column(nullable = false)
    private Boolean estado = true;

}
