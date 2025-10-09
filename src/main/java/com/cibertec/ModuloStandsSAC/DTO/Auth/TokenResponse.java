package com.cibertec.ModuloStandsSAC.DTO.Auth;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class TokenResponse {
    @JsonProperty("access_token")
    String accesToken;
    @JsonProperty("refresh_token")
    String refreshToken;
}
