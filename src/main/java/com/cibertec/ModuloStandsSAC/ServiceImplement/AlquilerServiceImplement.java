package com.cibertec.ModuloStandsSAC.ServiceImplement;

import com.cibertec.ModuloStandsSAC.DTO.DetalleAlquiler.AlquilerDetalleProjection;
import com.cibertec.ModuloStandsSAC.DTO.RegistroAlquiler.AlquilerDetalleResponse;
import com.cibertec.ModuloStandsSAC.DTO.RegistroAlquiler.AlquilerMessage;
import com.cibertec.ModuloStandsSAC.DTO.RegistroAlquiler.AlquilerRequest;
import com.cibertec.ModuloStandsSAC.DTO.RegistroAlquiler.AlquilerResponse;
import com.cibertec.ModuloStandsSAC.Entity.RegistroAlquiler;
import com.cibertec.ModuloStandsSAC.Entity.RegistroProyecto;
import com.cibertec.ModuloStandsSAC.Excepcion.MobiliarioInactivoException;
import com.cibertec.ModuloStandsSAC.Mapper.AlquilerMapper;
import com.cibertec.ModuloStandsSAC.Repository.RegistroAlquilerRepository;
import com.cibertec.ModuloStandsSAC.Repository.RegistroProyectoRepository;
import com.cibertec.ModuloStandsSAC.Service.AlquilerService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AlquilerServiceImplement implements AlquilerService {

    private final RegistroAlquilerRepository registroAlquilerRepository;
    private final RegistroProyectoRepository registroProyectoRepository;

    public AlquilerServiceImplement(RegistroAlquilerRepository registroAlquilerRepository, RegistroProyectoRepository registroProyectoRepository) {
        this.registroAlquilerRepository = registroAlquilerRepository;
        this.registroProyectoRepository = registroProyectoRepository;
    }

    @Override
    public List<AlquilerResponse> listarAlquilerActivos() {
        return registroAlquilerRepository.listarRegistroAlquiler()
                .stream().map(AlquilerMapper::alquilertoDTO).toList();
    }

    @Override
    public AlquilerResponse guardarAlquiler(AlquilerRequest alquilerRequest) {
        RegistroProyecto pro = registroProyectoRepository.findById(alquilerRequest.getIdProyecto()).orElseThrow(
                ()->new EntityNotFoundException("RegistroProyecto con el id "+alquilerRequest.getIdProyecto()));
        RegistroAlquiler alquiler = AlquilerMapper.toEntity(alquilerRequest,pro);
        return AlquilerMapper.alquilertoDTO(registroAlquilerRepository.save(alquiler));
    }

    @Override
    public AlquilerResponse actualizarAlquiler(AlquilerRequest alquilerRequest) {
        RegistroAlquiler reg = registroAlquilerRepository.findById(alquilerRequest.getIdAlquiler()).orElseThrow(
                ()->new EntityNotFoundException("RegistroAlquiler con el id "+alquilerRequest.getIdAlquiler()));
        RegistroProyecto pro = registroProyectoRepository.findById(alquilerRequest.getIdProyecto()).orElseThrow(
                ()->new EntityNotFoundException("RegistroProyecto con el id "+alquilerRequest.getIdProyecto()));
        RegistroAlquiler alquiler = AlquilerMapper.toEntity(alquilerRequest,pro);
        return AlquilerMapper.alquilertoDTO(registroAlquilerRepository.save(alquiler));
    }

    @Override
    public AlquilerMessage eliminarMessage(Integer id) {
        RegistroAlquiler registroAlquiler = registroAlquilerRepository.findById(id).orElseThrow(()
                -> new EntityNotFoundException("No se encontro el RegistroAlquiler con el id "+ id));
        registroAlquiler.setEstado(false);
        RegistroAlquiler guardado = registroAlquilerRepository.save(registroAlquiler);
        return new AlquilerMessage("Registro alquiler eliminado con exito");
    }

    @Override
    public AlquilerResponse buscarPorId(Integer id) {
        RegistroAlquiler registroAlquiler = registroAlquilerRepository.findById(id).orElseThrow(()
        -> new EntityNotFoundException("No se encontro el RegistroAlquiler con el id "+ id));
        if(!registroAlquiler.getEstado()){
            throw new MobiliarioInactivoException("El alquiler con el id "+id+ " esta inactivo");
        }
        return AlquilerMapper.alquilertoDTO(registroAlquiler);
    }

    @Override
    public List<AlquilerDetalleProjection> listarAlquilerPorid(Integer id) {
        return registroAlquilerRepository.listarAlquilerPorid(id);
    }
}
