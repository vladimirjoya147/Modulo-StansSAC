package com.cibertec.ModuloStandsSAC.ServiceImplement;

import com.cibertec.ModuloStandsSAC.DTO.Categoria.CategoriaMessage;
import com.cibertec.ModuloStandsSAC.DTO.Categoria.CategoriaRequestDTO;
import com.cibertec.ModuloStandsSAC.DTO.Categoria.CategoriaResponseDTO;
import com.cibertec.ModuloStandsSAC.Entity.Categoria;
import com.cibertec.ModuloStandsSAC.Mapper.CategoriaMapper;
import com.cibertec.ModuloStandsSAC.Repository.CategoriaRepository;
import com.cibertec.ModuloStandsSAC.Service.CategoriaService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import static com.cibertec.ModuloStandsSAC.Mapper.CategoriaMapper.mapper;
@Service
public class CategoriaServiceImplement implements CategoriaService {


    private final CategoriaRepository categoriaRepository;

    public CategoriaServiceImplement(CategoriaRepository categoriaRepository) {
        this.categoriaRepository = categoriaRepository;
    }

    @Override
    public List<CategoriaResponseDTO> listarCategorias() {

        return categoriaRepository.listarCategorias().stream()
                .map(mapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public CategoriaResponseDTO guardarCategoria(CategoriaRequestDTO categoriaRequestDTO) {
        Categoria categoria = mapper.toEntity(categoriaRequestDTO);
        return mapper.toDTO(categoriaRepository.save(categoria));
    }

    @Override
    public CategoriaResponseDTO atualizarCategoria(CategoriaRequestDTO categoriaRequestDTO) {
        Categoria categoria  =  categoriaRepository.findById(categoriaRequestDTO.getIdCategoria())
                .orElseThrow(()->new EntityNotFoundException("no se econtro categoria"));
        return mapper.toDTO(categoriaRepository.save(categoria));
    }

    @Override
    public CategoriaMessage eliminarPorId(Integer id) {
        Categoria categoria = categoriaRepository.findById(id).orElseThrow(()
            ->new EntityNotFoundException("No se encontro la categoria con el id "+id));
        categoria.setEstado(false);
        categoriaRepository.save(categoria);
        CategoriaMessage message = new CategoriaMessage();
        message.setMessage("Categoria eliminada con exito");
        return message;
    }

    @Override
    public CategoriaResponseDTO buscarPorId(Integer id) {
        if(!categoriaRepository.existsById(id)){
            throw new EntityNotFoundException("Categoria con id "+id+" no encontrada");
        }
        Categoria categoria  =  categoriaRepository.findById(id).orElseThrow(()->new EntityNotFoundException("no se econtro categoria"));
        return mapper.toDTO(categoria);
    }
}
