package com.cibertec.ModuloStandsSAC.Repository;

import com.cibertec.ModuloStandsSAC.Entity.DetalleAlquiler;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DetalleRepository extends JpaRepository<DetalleAlquiler, Integer> {

	   //AGREGADO: Método  para listar detalles por idAlquiler
    List<DetalleAlquiler> findByAlquiler_IdAlquiler(Integer idAlquiler);
}
