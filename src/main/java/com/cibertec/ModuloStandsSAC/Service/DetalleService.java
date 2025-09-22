package com.cibertec.ModuloStandsSAC.Service;

import com.cibertec.ModuloStandsSAC.DTO.Cliente.ClienteMessage;
import com.cibertec.ModuloStandsSAC.DTO.Cliente.ClienteRequestDTO;
import com.cibertec.ModuloStandsSAC.DTO.Cliente.ClienteResponseDTO;
import com.cibertec.ModuloStandsSAC.DTO.DetalleAlquiler.DetalleMessage;
import com.cibertec.ModuloStandsSAC.DTO.DetalleAlquiler.DetalleRequest;
import com.cibertec.ModuloStandsSAC.DTO.DetalleAlquiler.DetalleResponse;

public interface DetalleService {
    public DetalleResponse guardarDetalle (DetalleRequest detalleRequest);

    public DetalleResponse atualizarDetalle(DetalleRequest detalleRequest);

    public DetalleMessage eliminarPorId (Integer id);

    public DetalleResponse buscarPorId (Integer id);
}
