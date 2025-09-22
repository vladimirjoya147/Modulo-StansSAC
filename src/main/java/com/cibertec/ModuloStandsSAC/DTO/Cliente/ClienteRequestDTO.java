package com.cibertec.ModuloStandsSAC.DTO.Cliente;

import lombok.Data;

@Data
public class ClienteRequestDTO {

    private Integer idCliente;
    private String nombreCliente;
    private Integer idPais;
    private String contacto;
    private String telefono;
    private String correo;
    private boolean estado;
}
