package com.cibertec.ModuloStandsSAC.Mapper;

import com.cibertec.ModuloStandsSAC.DTO.Categoria.CategoriaRequestDTO;
import com.cibertec.ModuloStandsSAC.DTO.Cliente.ClienteRequestDTO;
import com.cibertec.ModuloStandsSAC.DTO.Cliente.ClienteResponseDTO;
import com.cibertec.ModuloStandsSAC.Entity.Cliente;
import com.cibertec.ModuloStandsSAC.Entity.Pais;

public class ClienteMapper {
    public static Cliente dtoToCliente(ClienteRequestDTO cliDTO, Pais pais) {
        Cliente cliente = new Cliente();
        cliente.setIdCliente(cliDTO.getIdCliente());
        cliente.setNombreCliente(cliDTO.getNombreCliente());
        cliente.setContacto(cliDTO.getContacto());
        cliente.setPaisId(pais);
        cliente.setTelefono(cliDTO.getTelefono());
        cliente.setCorreo(cliDTO.getCorreo());
        cliente.setEstado(cliDTO.isEstado());
        return cliente;
    }

    public static ClienteResponseDTO entityToDTO(Cliente cliente) {
        ClienteResponseDTO dto = new ClienteResponseDTO();
        dto.setIdCliente(cliente.getIdCliente());
        dto.setNombreCliente(cliente.getNombreCliente());
        dto.setNombrePais(cliente.getPaisId().getNombrePais());
        dto.setContacto(cliente.getContacto());
        dto.setTelefono(cliente.getTelefono());
        dto.setCorreo(cliente.getCorreo());
        dto.setEstado(cliente.isEstado());
        return dto;
    }

}
