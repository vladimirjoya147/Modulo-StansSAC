package com.cibertec.ModuloStandsSAC.ServiceImplement;

import com.cibertec.ModuloStandsSAC.DTO.Categoria.CategoriaMessage;
import com.cibertec.ModuloStandsSAC.DTO.Categoria.CategoriaRequestDTO;
import com.cibertec.ModuloStandsSAC.DTO.Categoria.CategoriaResponseDTO;
import com.cibertec.ModuloStandsSAC.DTO.Cliente.ClienteMessage;
import com.cibertec.ModuloStandsSAC.DTO.Cliente.ClienteRequestDTO;
import com.cibertec.ModuloStandsSAC.DTO.Cliente.ClienteResponseDTO;
import com.cibertec.ModuloStandsSAC.Entity.Categoria;
import com.cibertec.ModuloStandsSAC.Entity.Cliente;
import com.cibertec.ModuloStandsSAC.Entity.Pais;
import com.cibertec.ModuloStandsSAC.Mapper.ClienteMapper;
import com.cibertec.ModuloStandsSAC.Repository.CategoriaRepository;
import com.cibertec.ModuloStandsSAC.Repository.ClienteRepository;
import com.cibertec.ModuloStandsSAC.Repository.PaisRepository;
import com.cibertec.ModuloStandsSAC.Service.ClienteService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import static com.cibertec.ModuloStandsSAC.Mapper.CategoriaMapper.mapper;
@Service
public class ClienteServiceImplement implements ClienteService {

    private final ClienteRepository clienteRepository;
    private final PaisRepository paisRepository;

    public ClienteServiceImplement(ClienteRepository clienteRepository, PaisRepository paisRepository) {
        this.clienteRepository = clienteRepository;
        this.paisRepository = paisRepository;
    }

    @Override
    public List<ClienteResponseDTO> listarClientes() {

        return clienteRepository.listarClientes().stream()
                .map(ClienteMapper::entityToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public ClienteResponseDTO guardarCliente(ClienteRequestDTO clienteRequestDTO) {
        Pais pais = paisRepository.findById(clienteRequestDTO.getIdPais())
                .orElseThrow(()->new EntityNotFoundException("no se encontro pais con el id "+clienteRequestDTO.getIdPais()));
        Cliente cliente = ClienteMapper.dtoToCliente(clienteRequestDTO,pais);
        return ClienteMapper.entityToDTO(clienteRepository.save(cliente));
    }

    @Override
    public ClienteResponseDTO atualizarCategoria(ClienteRequestDTO clienteRequestDTO) {
        Pais pais = paisRepository.findById(clienteRequestDTO.getIdPais())
                .orElseThrow(()->new EntityNotFoundException("no se encontro pais con el id "+clienteRequestDTO.getIdPais()));
        Cliente cliente = clienteRepository.findById(clienteRequestDTO.getIdCliente())
                .orElseThrow(()->new EntityNotFoundException("cliente no encontrado con el id "+clienteRequestDTO.getIdCliente()));
        Cliente clientemap = ClienteMapper.dtoToCliente(clienteRequestDTO,pais);
        return ClienteMapper.entityToDTO(clienteRepository.save(clientemap));
    }

    @Override
    public ClienteMessage eliminarPorId(Integer id) {
        Cliente cliente = clienteRepository.findById(id).orElseThrow(
                ()->new EntityNotFoundException("No se encontro el cliente con el id "));
        cliente.setEstado(false);
        clienteRepository.save(cliente);
        ClienteMessage message = new ClienteMessage();
        message.setMessage("Categoria eliminada con exito");
        return message;
    }

    @Override
    public ClienteResponseDTO buscarPorId(Integer id) {
        if(!clienteRepository.existsById(id)){
            throw new EntityNotFoundException("Categoria con id "+id+" no encontrada");
        }
        Cliente cliente  =  clienteRepository.findById(id)
                .orElseThrow(()->new EntityNotFoundException("no se econtro categoria"));
        return ClienteMapper.entityToDTO(cliente);
    }
}
