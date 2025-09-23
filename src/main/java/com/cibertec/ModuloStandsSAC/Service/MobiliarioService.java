package com.cibertec.ModuloStandsSAC.Service;

import com.cibertec.ModuloStandsSAC.DTO.Evento.EventoMessage;
import com.cibertec.ModuloStandsSAC.DTO.Evento.EventoRequest;
import com.cibertec.ModuloStandsSAC.DTO.Evento.EventoResponse;
import com.cibertec.ModuloStandsSAC.DTO.Mobiliario.MobiliarioMessage;
import com.cibertec.ModuloStandsSAC.DTO.Mobiliario.MobiliarioRequest;
import com.cibertec.ModuloStandsSAC.DTO.Mobiliario.MobiliarioResponse;
import com.cibertec.ModuloStandsSAC.Entity.Mobiliario;

import java.util.List;

public interface MobiliarioService {

    public List<MobiliarioResponse> listarMobiliario();

    public MobiliarioResponse guardarMobiliario(MobiliarioRequest mobiliarioRequest);

    public MobiliarioResponse actualizarMobiliario(MobiliarioRequest mobiliarioRequest);

    public MobiliarioMessage eliminarMobiliarioPorId (Integer id);

    public MobiliarioResponse buscarMobiliarioPorId (Integer id);
}
