package com.cibertec.ModuloStandsSAC.Repository;

import com.cibertec.ModuloStandsSAC.DTO.DetalleAlquiler.AlquilerDetalleProjection;
import com.cibertec.ModuloStandsSAC.DTO.RegistroAlquiler.AlquilerDetalleResponse;
import com.cibertec.ModuloStandsSAC.Entity.Mobiliario;
import com.cibertec.ModuloStandsSAC.Entity.RegistroAlquiler;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RegistroAlquilerRepository extends JpaRepository<RegistroAlquiler, Integer> {

    @Query(value = "SELECT * FROM RegistroAlquiler WHERE estado=true", nativeQuery = true)
    public List<RegistroAlquiler> listarRegistroAlquiler();

    @Query(value = """
                SELECT
            	    da.id_alquiler,
                    da.id_detalle,
                    ra.fecha_alquiler,
                    m.Nombre AS nombre_Mobiliario,
                    da.Cantidad,
                    da.precio_unitario,
                    da.subtotal
                    FROM DetalleAlquiler da
                    INNER JOIN RegistroAlquiler ra ON da.id_alquiler = ra.id_alquiler
                    INNER JOIN Mobiliario m ON da.id_mobiliario = m.id_mobiliario
                    WHERE da.Estado = 1 AND da.id_alquiler = :id
            """,nativeQuery = true)
    public List<AlquilerDetalleProjection> listarAlquilerPorid(@Param("id")Integer id);
}
