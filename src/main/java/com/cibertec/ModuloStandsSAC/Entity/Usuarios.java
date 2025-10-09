package com.cibertec.ModuloStandsSAC.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
@Data
@Entity
@Builder
@Table(name = "usuarios")
@AllArgsConstructor
@NoArgsConstructor
public class Usuarios {
    @Id
    @GeneratedValue( strategy= GenerationType.IDENTITY)
    private Integer id;
    private String nombreCompleto;
    private String email;
    private String password;
    private LocalDateTime fechaRegistro;
}
