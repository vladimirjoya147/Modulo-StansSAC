package com.cibertec.ModuloStandsSAC.Entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "Categoria")
public class Categoria {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idCategoria;;
    private String nombreCategoria;
    private String descripcion;
    private boolean estado = true;

}
