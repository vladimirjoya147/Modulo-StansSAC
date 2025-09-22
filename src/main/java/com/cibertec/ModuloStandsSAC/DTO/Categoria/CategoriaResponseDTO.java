package com.cibertec.ModuloStandsSAC.DTO.Categoria;

import lombok.Data;

@Data
public class CategoriaResponseDTO {

    private Integer idCategoria;
    private String nombreCategoria;
    private String descripcion;
    private boolean estado;

}
