package com.cibertec.ModuloStandsSAC.Service;

import com.cibertec.ModuloStandsSAC.DTO.DetalleAlquiler.AlquilerDetalleProjection;
import com.cibertec.ModuloStandsSAC.DTO.RegistroAlquiler.AlquilerDetalleResponse;
import com.cibertec.ModuloStandsSAC.DTO.RegistroAlquiler.AlquilerMessage;
import com.cibertec.ModuloStandsSAC.DTO.RegistroAlquiler.AlquilerRequest;
import com.cibertec.ModuloStandsSAC.DTO.RegistroAlquiler.AlquilerResponse;
import com.cibertec.ModuloStandsSAC.Entity.RegistroAlquiler;

import java.util.List;

public interface AlquilerService {

    public List<AlquilerResponse> listarAlquilerActivos();

    public AlquilerResponse guardarAlquiler (AlquilerRequest alquilerRequest);

    public AlquilerResponse actualizarAlquiler (AlquilerRequest alquilerRequest);

    public AlquilerMessage eliminarMessage (Integer id);

    public AlquilerResponse buscarPorId (Integer id);

    public List<AlquilerDetalleProjection> listarAlquilerPorid(Integer id);
}
