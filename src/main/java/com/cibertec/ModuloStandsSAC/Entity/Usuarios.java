package com.cibertec.ModuloStandsSAC.Entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Value;

import java.time.LocalDateTime;
@Data
@Entity
@Table(name = "Usuarios")
public class Usuarios {
    @Id
    @GeneratedValue( strategy= GenerationType.IDENTITY)
    private Integer id;
    private String nombreCompleto;
    private String email;
    private String password;
    private LocalDateTime fechaRegistro;
}
