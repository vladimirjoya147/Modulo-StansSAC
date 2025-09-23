package com.cibertec.ModuloStandsSAC.DTO.RegistroProyecto;

import com.cibertec.ModuloStandsSAC.Entity.Cliente;
import com.cibertec.ModuloStandsSAC.Entity.Evento;
import lombok.Data;

@Data
public class ProyectoResponse {
    private Integer idProyecto;
    private String nombreProyecto;
    private String nombreEvento;
    private String nombreCliente;
    private Boolean estado;

}
