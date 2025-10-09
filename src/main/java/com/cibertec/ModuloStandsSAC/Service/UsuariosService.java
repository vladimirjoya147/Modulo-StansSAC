package com.cibertec.ModuloStandsSAC.Service;

import com.cibertec.ModuloStandsSAC.DTO.Auth.RegisterRequest;

public interface UsuariosService {

    public String register(RegisterRequest request);

    public Integer buscarPorEmail(String nombre);
}
