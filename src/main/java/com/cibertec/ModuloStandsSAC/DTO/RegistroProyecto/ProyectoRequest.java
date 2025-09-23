package com.cibertec.ModuloStandsSAC.DTO.RegistroProyecto;

import com.cibertec.ModuloStandsSAC.Entity.Cliente;
import com.cibertec.ModuloStandsSAC.Entity.Evento;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Data
public class ProyectoRequest {

    private Integer idProyecto;
    private String nombreProyecto;
    private Integer idEvento;
    private Integer idCliente;
}
