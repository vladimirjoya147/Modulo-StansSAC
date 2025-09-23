package com.cibertec.ModuloStandsSAC.DTO.Evento;

import lombok.Data;

import java.time.LocalDate;
@Data
public class EventoRequest {
    private Integer idEvento;
    private String nombreEvento;
    private LocalDate fechaInicio;
    private LocalDate fechaFin;
    private String lugar;
    private boolean estado;
}
