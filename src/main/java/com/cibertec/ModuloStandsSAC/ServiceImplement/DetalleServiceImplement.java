package com.cibertec.ModuloStandsSAC.ServiceImplement;

import com.cibertec.ModuloStandsSAC.DTO.DetalleAlquiler.DetalleMessage;
import com.cibertec.ModuloStandsSAC.DTO.DetalleAlquiler.DetalleRequest;
import com.cibertec.ModuloStandsSAC.DTO.DetalleAlquiler.DetalleResponse;
import com.cibertec.ModuloStandsSAC.Entity.DetalleAlquiler;
import com.cibertec.ModuloStandsSAC.Entity.Mobiliario;
import com.cibertec.ModuloStandsSAC.Entity.RegistroAlquiler;
import com.cibertec.ModuloStandsSAC.Mapper.CategoriaMapper;
import com.cibertec.ModuloStandsSAC.Mapper.DetalleMapper;
import com.cibertec.ModuloStandsSAC.Repository.ClienteRepository;
import com.cibertec.ModuloStandsSAC.Repository.DetalleRepository;
import com.cibertec.ModuloStandsSAC.Repository.MonbiliarioRepository;
import com.cibertec.ModuloStandsSAC.Repository.RegistroAlquilerRepository;
import com.cibertec.ModuloStandsSAC.Service.DetalleService;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.concurrent.ExecutionException;

@Service
public class DetalleServiceImplement implements DetalleService {

    private final DetalleRepository detalleRepository;
    private final MonbiliarioRepository monbiliarioRepository;
    private final RegistroAlquilerRepository registroAlquilerRepository;

    public DetalleServiceImplement(DetalleRepository detalleRepository, MonbiliarioRepository monbiliarioRepository, RegistroAlquilerRepository registroAlquilerRepository) {
        this.detalleRepository = detalleRepository;
        this.monbiliarioRepository = monbiliarioRepository;
        this.registroAlquilerRepository = registroAlquilerRepository;
    }


    @Override
    @Transactional
    public DetalleResponse guardarDetalle(DetalleRequest detalleRequest) {

        Mobiliario mobiliario = monbiliarioRepository.findById(detalleRequest.getIdMobiliario())
                .orElseThrow(()->new EntityNotFoundException("No se econtro mobiliario con el id "+detalleRequest.getIdMobiliario()));
        RegistroAlquiler regAlquiler = registroAlquilerRepository.findById(detalleRequest.getIdRegistroAlquiler())
                .orElseThrow(()->new EntityNotFoundException("No se econtro reg alquiler con el id "+detalleRequest.getIdRegistroAlquiler()));
        if(mobiliario.getStock()<detalleRequest.getCantidad()){
            throw new ArithmeticException("No hay suficiente stock para realizar esta operacion ");
        }
        int nuevoStock = mobiliario.getStock()-detalleRequest.getCantidad();
        mobiliario.setStock(nuevoStock);
        monbiliarioRepository.save(mobiliario);
        BigDecimal precioUnitario = mobiliario.getPrecioUnitario();
        BigDecimal subtotal = precioUnitario.multiply(BigDecimal.valueOf(detalleRequest.getCantidad()));
        
        DetalleAlquiler alquiler = new DetalleAlquiler();
        alquiler.setAlquiler(regAlquiler);
        alquiler.setMobiliario(mobiliario);
        alquiler.setCantidad(detalleRequest.getCantidad());
        alquiler.setEstado(detalleRequest.getEstado());
        alquiler.setPrecioUnitario(precioUnitario);
        alquiler.setSubtotal(subtotal);

        return DetalleMapper.toDTO(detalleRepository.save(alquiler));
    }

    @Override
    @Transactional
    public DetalleResponse atualizarDetalle(DetalleRequest detalleRequest) {
        DetalleAlquiler detalleExistente = detalleRepository.findById(detalleRequest.getIdDetalle())
                .orElseThrow(() -> new EntityNotFoundException(
                        "No se encontró detalle con id " + detalleRequest.getIdDetalle()));

        Mobiliario mobiliarioAnterior = detalleExistente.getMobiliario();
        mobiliarioAnterior.setStock(mobiliarioAnterior.getStock() + detalleExistente.getCantidad());
        monbiliarioRepository.save(mobiliarioAnterior);

        Mobiliario nuevoMobiliario = monbiliarioRepository.findById(detalleRequest.getIdMobiliario())
                .orElseThrow(() -> new EntityNotFoundException(
                        "No se encontró mobiliario con id " + detalleRequest.getIdMobiliario()));
        if(nuevoMobiliario.getStock()<detalleRequest.getCantidad()){
            throw new ArithmeticException("No hay suficiente stock para realizar esta operacion ");
        }
        int nuevoStock = nuevoMobiliario.getStock()-detalleRequest.getCantidad();
        nuevoMobiliario.setStock(nuevoStock);
        monbiliarioRepository.save(nuevoMobiliario);
        BigDecimal precioUnitario = nuevoMobiliario.getPrecioUnitario();
        BigDecimal subtotal = precioUnitario.multiply(BigDecimal.valueOf(detalleRequest.getCantidad()));

        detalleExistente.setMobiliario(nuevoMobiliario);
        detalleExistente.setCantidad(detalleRequest.getCantidad());
        detalleExistente.setEstado(detalleRequest.getEstado());
        detalleExistente.setPrecioUnitario(precioUnitario);
        detalleExistente.setSubtotal(subtotal);
        return DetalleMapper.toDTO(detalleRepository.save(detalleExistente));
    }

    @Override
    @Transactional
    public DetalleMessage eliminarPorId(Integer id) {
        DetalleAlquiler detalleAlquiler = detalleRepository.findById(id)
                .orElseThrow(()->new EntityNotFoundException("No se contro detalle con el id "+id));

        Mobiliario mobiliarioActual = detalleAlquiler.getMobiliario();
        mobiliarioActual.setStock(mobiliarioActual.getStock()+detalleAlquiler.getCantidad());
        monbiliarioRepository.save(mobiliarioActual);

        detalleAlquiler.setEstado(false);
        detalleRepository.save(detalleAlquiler);

        DetalleMessage detalleMessage = new DetalleMessage();
        detalleMessage.setMessage("DetalleMobiliario eliminado con exito!");
        return detalleMessage;
    }

    @Override
    public DetalleResponse buscarPorId(Integer id) {
        DetalleAlquiler detalle = detalleRepository.findById(id)
                .orElseThrow(()->new EntityNotFoundException("mo se contro el detalle " + id));
        return DetalleMapper.toDTO(detalle);
    }
}
