package com.cibertec.ModuloStandsSAC.Repository;

import com.cibertec.ModuloStandsSAC.DTO.PaisResponse;
import com.cibertec.ModuloStandsSAC.Entity.Pais;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.naming.InterruptedNamingException;
import java.util.List;

@Repository
public interface PaisRepository extends JpaRepository<Pais, Integer> {
    @Query(value = "SELECT * FROM Pais WHERE Estado=true",nativeQuery = true)
    public List<Pais> listarPaises();
}
