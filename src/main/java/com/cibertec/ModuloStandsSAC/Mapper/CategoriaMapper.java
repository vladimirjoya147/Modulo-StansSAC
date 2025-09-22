package com.cibertec.ModuloStandsSAC.Mapper;

import com.cibertec.ModuloStandsSAC.DTO.Categoria.CategoriaRequestDTO;
import com.cibertec.ModuloStandsSAC.DTO.Categoria.CategoriaResponseDTO;
import com.cibertec.ModuloStandsSAC.Entity.Categoria;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CategoriaMapper {

    CategoriaMapper mapper= Mappers.getMapper(CategoriaMapper.class);

    Categoria toEntity (CategoriaRequestDTO categoriaRequestDTO);

    CategoriaResponseDTO toDTO(Categoria categoria);
}
