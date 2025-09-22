package com.cibertec.ModuloStandsSAC.Service;

import com.cibertec.ModuloStandsSAC.DTO.Categoria.CategoriaMessage;
import com.cibertec.ModuloStandsSAC.DTO.Categoria.CategoriaRequestDTO;
import com.cibertec.ModuloStandsSAC.DTO.Categoria.CategoriaResponseDTO;
import com.cibertec.ModuloStandsSAC.DTO.Cliente.ClienteMessage;
import com.cibertec.ModuloStandsSAC.DTO.Cliente.ClienteRequestDTO;
import com.cibertec.ModuloStandsSAC.DTO.Cliente.ClienteResponseDTO;

import java.util.List;

public interface ClienteService {

    public List<ClienteResponseDTO> listarClientes();

    public ClienteResponseDTO guardarCliente (ClienteRequestDTO clienteRequestDTO);

    public ClienteResponseDTO atualizarCategoria(ClienteRequestDTO clienteRequestDTO);

    public ClienteMessage eliminarPorId (Integer id);

    public ClienteResponseDTO buscarPorId (Integer id);
}
