package com.cibertec.ModuloStandsSAC.Mapper;

import com.cibertec.ModuloStandsSAC.DTO.RegistroAlquiler.AlquilerRequest;
import com.cibertec.ModuloStandsSAC.DTO.RegistroAlquiler.AlquilerResponse;
import com.cibertec.ModuloStandsSAC.Entity.RegistroAlquiler;
import com.cibertec.ModuloStandsSAC.Entity.RegistroProyecto;

import java.math.BigDecimal;
import java.time.LocalDate;

public class AlquilerMapper {

    public static RegistroAlquiler toEntity(AlquilerRequest ar, RegistroProyecto rp){
        RegistroAlquiler ra = new RegistroAlquiler();
        ra.setIdAlquiler(ar.getIdAlquiler());
        ra.setIdProyecto(rp);
        ra.setFechaAlquiler(ar.getFechaAlquiler());
        ra.setFechaDevolucionEstimada(ar.getFechaDevolucionEstimada());
        ra.setEstadoAlquiler(ar.getEstadoAlquiler());
        ra.setTotal(ar.getTotal());
        return ra;
    }

    public static AlquilerResponse alquilertoDTO (RegistroAlquiler ra){
        AlquilerResponse re = new AlquilerResponse();
        re.setIdAlquiler(ra.getIdAlquiler());
        re.setNombreProyecto(ra.getIdProyecto().getNombreProyecto());
        re.setFechaAlquiler(ra.getFechaAlquiler());
        re.setFechaDevolucionEstimada(ra.getFechaDevolucionEstimada());
        re.setEstadoAlquiler(ra.getEstadoAlquiler());
        re.setTotal(ra.getTotal());
        re.setEstado(ra.getEstado());
        return re;
    }

}
