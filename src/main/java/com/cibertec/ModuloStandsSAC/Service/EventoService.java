package com.cibertec.ModuloStandsSAC.Service;

import com.cibertec.ModuloStandsSAC.DTO.Categoria.CategoriaMessage;
import com.cibertec.ModuloStandsSAC.DTO.Categoria.CategoriaRequestDTO;
import com.cibertec.ModuloStandsSAC.DTO.Categoria.CategoriaResponseDTO;
import com.cibertec.ModuloStandsSAC.DTO.Evento.EventoMessage;
import com.cibertec.ModuloStandsSAC.DTO.Evento.EventoRequest;
import com.cibertec.ModuloStandsSAC.DTO.Evento.EventoResponse;

import java.util.List;

public interface EventoService {

    public List<EventoResponse> listarEventos();

    public EventoResponse guardarEvento(EventoRequest eventoRequest);

    public EventoResponse actualizarEvento(EventoRequest eventoRequest);

    public EventoMessage eliminarEventoPorId (Integer id);

    public EventoResponse buscarEventoPorId (Integer id);
}
