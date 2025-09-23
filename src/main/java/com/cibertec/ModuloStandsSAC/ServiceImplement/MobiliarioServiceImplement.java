package com.cibertec.ModuloStandsSAC.ServiceImplement;

import com.cibertec.ModuloStandsSAC.DTO.Mobiliario.MobiliarioMessage;
import com.cibertec.ModuloStandsSAC.DTO.Mobiliario.MobiliarioRequest;
import com.cibertec.ModuloStandsSAC.DTO.Mobiliario.MobiliarioResponse;
import com.cibertec.ModuloStandsSAC.Entity.Categoria;
import com.cibertec.ModuloStandsSAC.Entity.Mobiliario;
import com.cibertec.ModuloStandsSAC.Excepcion.MobiliarioInactivoException;
import com.cibertec.ModuloStandsSAC.Mapper.MobiliarioMapper;
import com.cibertec.ModuloStandsSAC.Repository.CategoriaRepository;
import com.cibertec.ModuloStandsSAC.Repository.MobiliarioRepository;
import com.cibertec.ModuloStandsSAC.Service.MobiliarioService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MobiliarioServiceImplement implements MobiliarioService {

    private final MobiliarioRepository mobiliarioRepository;
    private final CategoriaRepository categoriaRepository;

    public MobiliarioServiceImplement(MobiliarioRepository mobiliarioRepository, CategoriaRepository categoriaRepository) {
        this.mobiliarioRepository = mobiliarioRepository;
        this.categoriaRepository = categoriaRepository;
    }

    @Override
    public List<MobiliarioResponse> listarMobiliario() {
        return mobiliarioRepository.listarMobiliarioActivas().stream()
                .map(MobiliarioMapper::toDTO).toList();
    }

    @Override
    public MobiliarioResponse guardarMobiliario(MobiliarioRequest mobiliarioRequest) {
        Categoria categoria = categoriaRepository.findById(mobiliarioRequest.getIdCategoria()).orElseThrow(()->
                new EntityNotFoundException("Mobiliario no encontrado"));
        Mobiliario mapeo = MobiliarioMapper.toEntity(mobiliarioRequest,categoria);
        return MobiliarioMapper.toDTO(mobiliarioRepository.save(mapeo));
    }

    @Override
    public MobiliarioResponse actualizarMobiliario(MobiliarioRequest mobiliarioRequest) {
        Mobiliario mobiliario = mobiliarioRepository.findById(mobiliarioRequest.getIdMobiliario()).orElseThrow(()->
                new EntityNotFoundException("Mobiliario no encontrado"));
        Categoria categoria = categoriaRepository.findById(mobiliarioRequest.getIdCategoria()).orElseThrow(()->
                new EntityNotFoundException("Mobiliario no encontrado"));
        Mobiliario mapeo = MobiliarioMapper.toEntity(mobiliarioRequest,categoria);
        return MobiliarioMapper.toDTO(mobiliarioRepository.save(mapeo));
    }

    @Override
    public MobiliarioMessage eliminarMobiliarioPorId(Integer id) {
        Mobiliario mobiliario = mobiliarioRepository.findById(id).orElseThrow(()->
                new EntityNotFoundException("Mobiliario no encontrado"));
        mobiliario.setEstado(false);
        mobiliarioRepository.save(mobiliario);
        MobiliarioMessage message = new MobiliarioMessage("Producto eliminado con exito!");
        return message;
    }

    @Override
    public MobiliarioResponse buscarMobiliarioPorId(Integer id) {
        Mobiliario mobiliario = mobiliarioRepository.findById(id).orElseThrow(()->
                new EntityNotFoundException("Mobiliario no encontrado"));
        if(!mobiliario.getEstado()){
            throw new MobiliarioInactivoException("El mobiliario con id " + id + " está inactivo");
        }
        return MobiliarioMapper.toDTO(mobiliario);
    }
}
