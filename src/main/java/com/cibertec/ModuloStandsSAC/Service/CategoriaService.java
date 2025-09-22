package com.cibertec.ModuloStandsSAC.Service;

import com.cibertec.ModuloStandsSAC.DTO.Categoria.CategoriaMessage;
import com.cibertec.ModuloStandsSAC.DTO.Categoria.CategoriaRequestDTO;
import com.cibertec.ModuloStandsSAC.DTO.Categoria.CategoriaResponseDTO;

import java.util.List;

public interface CategoriaService {

    public List<CategoriaResponseDTO> listarCategorias();

    public CategoriaResponseDTO guardarCategoria(CategoriaRequestDTO categoriaRequestDTO);

    public CategoriaResponseDTO atualizarCategoria(CategoriaRequestDTO categoriaRequestDTO);

    public CategoriaMessage eliminarPorId (Integer id);

    public CategoriaResponseDTO buscarPorId (Integer id);
}
