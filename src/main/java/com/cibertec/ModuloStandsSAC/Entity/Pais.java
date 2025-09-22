package com.cibertec.ModuloStandsSAC.Entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "Pais")
public class Pais {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idPais;
    private String nombrePais;
    private boolean estado;
}
