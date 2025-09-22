package com.cibertec.ModuloStandsSAC.Repository;

import com.cibertec.ModuloStandsSAC.Entity.Mobiliario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MonbiliarioRepository extends JpaRepository<Mobiliario, Integer> {
}
