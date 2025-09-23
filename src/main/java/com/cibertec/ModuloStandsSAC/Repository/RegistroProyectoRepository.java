package com.cibertec.ModuloStandsSAC.Repository;

import com.cibertec.ModuloStandsSAC.Entity.RegistroAlquiler;
import com.cibertec.ModuloStandsSAC.Entity.RegistroProyecto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RegistroProyectoRepository extends JpaRepository<RegistroProyecto, Integer> {
    @Query(value = "SELECT * FROM RegistroProyecto WHERE estado=true", nativeQuery = true)
    public List<RegistroProyecto> listarRegistroProyecto();
}
