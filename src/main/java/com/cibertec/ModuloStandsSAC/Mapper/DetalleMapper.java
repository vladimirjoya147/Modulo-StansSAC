package com.cibertec.ModuloStandsSAC.Mapper;

import com.cibertec.ModuloStandsSAC.DTO.DetalleAlquiler.DetalleRequest;
import com.cibertec.ModuloStandsSAC.DTO.DetalleAlquiler.DetalleResponse;
import com.cibertec.ModuloStandsSAC.Entity.DetalleAlquiler;
import com.cibertec.ModuloStandsSAC.Entity.Mobiliario;
import com.cibertec.ModuloStandsSAC.Entity.RegistroAlquiler;

import java.math.BigDecimal;
import java.time.LocalDate;

public class DetalleMapper {
    public static DetalleAlquiler toEntity (DetalleRequest detalle, Mobiliario mobiliario, RegistroAlquiler reg){
        DetalleAlquiler det = new DetalleAlquiler();
        det.setIdDetalle(detalle.getIdDetalle());
        det.setAlquiler(reg);
        det.setCantidad(detalle.getCantidad());
        det.setEstado(detalle.getEstado());
        det.setPrecioUnitario(detalle.getPrecioUnitario());
        det.setSubtotal(detalle.getSubTotal());
        det.setMobiliario(mobiliario);
        return det;
    }

    public static DetalleResponse toDTO (DetalleAlquiler detalle){
        DetalleResponse res = new DetalleResponse();
        res.setIdDetalle(detalle.getIdDetalle());
        res.setRegistroAlquilerDevolucion(detalle.getAlquiler().getFechaDevolucionEstimada());
        res.setEstado(detalle.getEstado());
        res.setPrecioUnitario(detalle.getPrecioUnitario());
        res.setNombreMobiliario(detalle.getMobiliario().getNombre());
        res.setCantidad(detalle.getCantidad());
        res.setSubTotal(detalle.getSubtotal());
        return res;
    }

}
