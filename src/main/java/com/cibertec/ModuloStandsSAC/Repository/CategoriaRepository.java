package com.cibertec.ModuloStandsSAC.Repository;

import com.cibertec.ModuloStandsSAC.Entity.Categoria;
import com.cibertec.ModuloStandsSAC.Entity.Pais;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface CategoriaRepository extends JpaRepository <Categoria, Integer> {
    @Query(value = "SELECT * FROM categoria WHERE Estado=true",nativeQuery = true)
    public List<Categoria> listarCategorias();
}
