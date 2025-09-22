package com.cibertec.ModuloStandsSAC.Repository;

import com.cibertec.ModuloStandsSAC.Entity.DetalleAlquiler;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DetalleRepository extends JpaRepository<DetalleAlquiler, Integer> {
}
