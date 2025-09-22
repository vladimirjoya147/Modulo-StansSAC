package com.cibertec.ModuloStandsSAC.Repository;

import com.cibertec.ModuloStandsSAC.Entity.RegistroAlquiler;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RegistroAlquilerRepository extends JpaRepository<RegistroAlquiler, Integer> {
}
