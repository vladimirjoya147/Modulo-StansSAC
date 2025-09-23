package com.cibertec.ModuloStandsSAC.ServiceImplement;

import com.cibertec.ModuloStandsSAC.DTO.Evento.EventoMessage;
import com.cibertec.ModuloStandsSAC.DTO.Evento.EventoRequest;
import com.cibertec.ModuloStandsSAC.DTO.Evento.EventoResponse;
import com.cibertec.ModuloStandsSAC.Entity.Evento;
import com.cibertec.ModuloStandsSAC.Repository.EventoRepository;
import com.cibertec.ModuloStandsSAC.Service.EventoService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.cibertec.ModuloStandsSAC.Mapper.EventoMapper.mapper;

@Service
public class EventoServiceImplement implements EventoService {

    private final EventoRepository eventoRepository;

    public EventoServiceImplement(EventoRepository eventoRepository) {
        this.eventoRepository = eventoRepository;
    }

    @Override
    public List<EventoResponse> listarEventos() {
        return eventoRepository.listarEventosActivas()
                .stream().map(mapper::toDTO)
                .toList();
    }

    @Override
    public EventoResponse guardarEvento(EventoRequest eventoRequest) {
        Evento evento = mapper.toEntiry(eventoRequest);
        return mapper.toDTO(eventoRepository.save(evento));
    }

    @Override
    public EventoResponse actualizarEvento(EventoRequest eventoRequest) {
        Evento evento =  eventoRepository.findById(eventoRequest.getIdEvento()).orElseThrow(
                ()->new EntityNotFoundException("No se encontro el evento con el id "+eventoRequest.getIdEvento()));
        Evento eventomap = mapper.toEntiry(eventoRequest);
        return mapper.toDTO(eventoRepository.save(eventomap));
    }

    @Override
    public EventoMessage eliminarEventoPorId(Integer id) {
        Evento evento =  eventoRepository.findById(id).orElseThrow(
                ()->new EntityNotFoundException("No se encontro el evento con el id "+id));
        evento.setEstado(false);
        Evento guardado = eventoRepository.save(evento);
        EventoMessage message = new EventoMessage();
        message.setMensaje("Evento eliminado con exito!");
        return message;
    }

    @Override
    public EventoResponse buscarEventoPorId(Integer id) {
        Evento evento =  eventoRepository.findById(id).orElseThrow(
                ()->new EntityNotFoundException("No se encontro el evento con el id "+id));
        return mapper.toDTO(evento);
    }


}
