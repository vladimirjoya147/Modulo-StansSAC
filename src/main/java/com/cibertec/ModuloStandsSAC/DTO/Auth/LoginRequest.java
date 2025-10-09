package com.cibertec.ModuloStandsSAC.DTO.Auth;

import lombok.Data;

@Data
public class LoginRequest {
    String email;
    String password;
}
