package com.cibertec.ModuloStandsSAC.Service;

import com.cibertec.ModuloStandsSAC.DTO.RegistroAlquiler.AlquilerMessage;
import com.cibertec.ModuloStandsSAC.DTO.RegistroAlquiler.AlquilerRequest;
import com.cibertec.ModuloStandsSAC.DTO.RegistroAlquiler.AlquilerResponse;
import com.cibertec.ModuloStandsSAC.DTO.RegistroProyecto.ProyectoMessage;
import com.cibertec.ModuloStandsSAC.DTO.RegistroProyecto.ProyectoRequest;
import com.cibertec.ModuloStandsSAC.DTO.RegistroProyecto.ProyectoResponse;

import java.util.List;

public interface ProyectoService {

    public List<ProyectoResponse> listarProyectoActivos();

    public ProyectoResponse guardarProyecto (ProyectoRequest proyectoRequest);

    public ProyectoResponse actualizarProyecto (ProyectoRequest proyectoRequest);

    public ProyectoMessage eliminarProyecto(Integer id);

    public ProyectoResponse buscarProyectoPorId (Integer id);
}
