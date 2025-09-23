package com.cibertec.ModuloStandsSAC.ServiceImplement;

import com.cibertec.ModuloStandsSAC.DTO.Pais.PaisResponse;
import com.cibertec.ModuloStandsSAC.Repository.PaisRepository;
import com.cibertec.ModuloStandsSAC.Service.PaisService;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.cibertec.ModuloStandsSAC.Mapper.PaisMapper.mapper;

@Service
public class PaisServiceImplement implements PaisService {

    private final PaisRepository paisRepository;

    public PaisServiceImplement(PaisRepository paisRepository) {
        this.paisRepository = paisRepository;
    }

    @Override
    public List<PaisResponse> listarPaises() {
        return paisRepository.listarPaises().stream().map(mapper::toDTO).toList();
    }
}
