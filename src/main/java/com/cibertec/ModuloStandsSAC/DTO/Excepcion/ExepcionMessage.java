package com.cibertec.ModuloStandsSAC.DTO.Excepcion;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ExepcionMessage {
    private String mensaje;
    private int codigo;
}
