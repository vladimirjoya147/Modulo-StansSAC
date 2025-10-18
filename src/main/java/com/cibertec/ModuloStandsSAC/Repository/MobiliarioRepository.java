package com.cibertec.ModuloStandsSAC.Repository;

import com.cibertec.ModuloStandsSAC.Entity.Mobiliario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MobiliarioRepository extends JpaRepository<Mobiliario, Integer> {
    @Query(value = "SELECT * FROM mobiliario WHERE estado=true", nativeQuery = true)
    public List<Mobiliario> listarMobiliarioActivas();
}
