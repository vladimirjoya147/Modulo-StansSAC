package com.cibertec.ModuloStandsSAC.Entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "Cliente")
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idCliente;
    private String nombreCliente;
    @ManyToOne
    @JoinColumn(name="pais_id")
    private Pais paisId;
    @Column(name = "Contacto")
    private String contacto;
    @Column(name = "Telefono")
    private String telefono;
    @Column(name = "Correo")
    private String correo;
    @Column(name="Estado")
    private boolean estado;
}
