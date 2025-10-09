package com.cibertec.ModuloStandsSAC.DTO.Auth;

import lombok.Data;

@Data
public class RegisterRequest {
    private String nombreCompleto;
    private String email;
    private String password;
}
