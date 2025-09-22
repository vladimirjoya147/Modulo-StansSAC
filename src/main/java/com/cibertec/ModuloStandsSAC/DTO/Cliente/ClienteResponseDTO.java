package com.cibertec.ModuloStandsSAC.DTO.Cliente;

import lombok.Data;

@Data
public class ClienteResponseDTO {

    private Integer idCliente;
    private String nombreCliente;
    private String nombrePais;
    private String contacto;
    private String telefono;
    private String correo;
    private boolean estado;
}
