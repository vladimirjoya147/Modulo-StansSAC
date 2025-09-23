package com.cibertec.ModuloStandsSAC.Mapper;

import com.cibertec.ModuloStandsSAC.DTO.Evento.EventoRequest;
import com.cibertec.ModuloStandsSAC.DTO.Evento.EventoResponse;
import com.cibertec.ModuloStandsSAC.Entity.Evento;
import org.hibernate.validator.spi.scripting.ScriptEvaluatorNotFoundException;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface EventoMapper {

    EventoMapper mapper = Mappers.getMapper(EventoMapper.class);

    Evento toEntiry (EventoRequest eventoRequest);

    EventoResponse toDTO(Evento evento);
}
