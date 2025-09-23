package com.cibertec.ModuloStandsSAC.ServiceImplement;

import com.cibertec.ModuloStandsSAC.DTO.RegistroProyecto.ProyectoMessage;
import com.cibertec.ModuloStandsSAC.DTO.RegistroProyecto.ProyectoRequest;
import com.cibertec.ModuloStandsSAC.DTO.RegistroProyecto.ProyectoResponse;
import com.cibertec.ModuloStandsSAC.Entity.Cliente;
import com.cibertec.ModuloStandsSAC.Entity.Evento;
import com.cibertec.ModuloStandsSAC.Entity.RegistroProyecto;
import com.cibertec.ModuloStandsSAC.Excepcion.MobiliarioInactivoException;
import com.cibertec.ModuloStandsSAC.Excepcion.ProyectoInactivoExcepcion;
import com.cibertec.ModuloStandsSAC.Mapper.RegistroMapper;
import com.cibertec.ModuloStandsSAC.Repository.ClienteRepository;
import com.cibertec.ModuloStandsSAC.Repository.EventoRepository;
import com.cibertec.ModuloStandsSAC.Repository.RegistroProyectoRepository;
import com.cibertec.ModuloStandsSAC.Service.ProyectoService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ProyectoServiceImplement implements ProyectoService {

    private final RegistroProyectoRepository registroProyectoRepository;
    private final EventoRepository eventoRepository;
    private final ClienteRepository clienteRepository;

    public ProyectoServiceImplement(RegistroProyectoRepository registroProyectoRepository, EventoRepository eventoRepository, ClienteRepository clienteRepository) {
        this.registroProyectoRepository = registroProyectoRepository;
        this.eventoRepository = eventoRepository;
        this.clienteRepository = clienteRepository;
    }

    @Override
    public List<ProyectoResponse> listarProyectoActivos() {
        return registroProyectoRepository.listarRegistroProyecto().stream()
                .map(RegistroMapper::registroToDTO).toList();
    }

    @Override
    public ProyectoResponse guardarProyecto(ProyectoRequest proReq) {
        Evento evento = eventoRepository.findById(proReq.getIdEvento()).orElseThrow(()
                ->new EntityNotFoundException("No se encontro evento con el id "+proReq.getIdEvento()));
        Cliente cliente = clienteRepository.findById(proReq.getIdCliente()).orElseThrow(()
                ->new EntityNotFoundException("No se encontro evento con el id "+proReq.getIdEvento()));
        RegistroProyecto registroProyecto = RegistroMapper.registroToEntity(proReq,cliente,evento);
        return RegistroMapper.registroToDTO(registroProyectoRepository.save(registroProyecto));
    }

    @Override
    public ProyectoResponse actualizarProyecto(ProyectoRequest proReq) {
        RegistroProyecto registroProyecto = registroProyectoRepository.findById(proReq.getIdCliente()).orElseThrow(()
                ->new EntityNotFoundException("No se encontro registroProyecto con el id "+proReq.getIdProyecto()));

        Evento evento = eventoRepository.findById(proReq.getIdEvento()).orElseThrow(()
                ->new EntityNotFoundException("No se encontro evento con el id "+proReq.getIdEvento()));

        Cliente cliente = clienteRepository.findById(proReq.getIdCliente()).orElseThrow(()
                ->new EntityNotFoundException("No se encontro cliente con el id "+proReq.getIdCliente()));
        RegistroProyecto registroProyectomap = RegistroMapper.registroToEntity(proReq,cliente,evento);
        return RegistroMapper.registroToDTO(registroProyectoRepository.save(registroProyectomap));
    }

    @Override
    public ProyectoMessage eliminarProyecto(Integer id) {

        RegistroProyecto registroProyecto = registroProyectoRepository.findById(id).orElseThrow(()
                ->new EntityNotFoundException("No se encontro registroProyecto con el id "+id));
        if(!registroProyecto.getEstado()){
            throw new ProyectoInactivoExcepcion("el proyecto con el id "+id+ " esta inactivo");
        }
        registroProyecto.setEstado(false);
        registroProyectoRepository.save(registroProyecto);
        return new ProyectoMessage("RegistroProducto eliminado con exito!");
    }

    @Override
    public ProyectoResponse buscarProyectoPorId(Integer id) {
        RegistroProyecto registroProyecto = registroProyectoRepository.findById(id).orElseThrow(()
                ->new EntityNotFoundException("No se encontro registroProyecto con el id "+id));
        if(!registroProyecto.getEstado()){
            throw new ProyectoInactivoExcepcion("el proyecto con el id "+id+ " esta inactivo");
        }
        return RegistroMapper.registroToDTO(registroProyecto);
    }
}
