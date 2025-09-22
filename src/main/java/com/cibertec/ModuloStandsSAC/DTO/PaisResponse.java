package com.cibertec.ModuloStandsSAC.DTO;

import jakarta.persistence.Column;
import lombok.Data;

@Data
public class PaisResponse {

    private Integer idPais;
    private String nombrePais;
    private boolean estado;
}
