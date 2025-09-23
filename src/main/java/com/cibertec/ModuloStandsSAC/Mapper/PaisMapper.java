package com.cibertec.ModuloStandsSAC.Mapper;

import com.cibertec.ModuloStandsSAC.DTO.Pais.PaisResponse;
import com.cibertec.ModuloStandsSAC.Entity.Pais;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PaisMapper {
    PaisMapper mapper = Mappers.getMapper(PaisMapper.class);

    PaisResponse toDTO (Pais pais);
}
