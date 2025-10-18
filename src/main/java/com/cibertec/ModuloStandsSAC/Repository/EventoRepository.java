package com.cibertec.ModuloStandsSAC.Repository;

import com.cibertec.ModuloStandsSAC.Entity.Evento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EventoRepository extends JpaRepository<Evento, Integer> {
    @Query(value = "SELECT * FROM evento WHERE estado=true", nativeQuery = true)
    public List<Evento> listarEventosActivas();
}
