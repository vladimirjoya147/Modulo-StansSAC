package com.cibertec.ModuloStandsSAC.ServiceImplement;

import com.cibertec.ModuloStandsSAC.DTO.Auth.AuthResponse;
import com.cibertec.ModuloStandsSAC.DTO.Auth.LoginRequest;
import com.cibertec.ModuloStandsSAC.DTO.Auth.RegisterRequest;
import com.cibertec.ModuloStandsSAC.Entity.Usuarios;
import com.cibertec.ModuloStandsSAC.Repository.UsuariosRepository;
import com.cibertec.ModuloStandsSAC.Service.UsuariosService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Optional;

@Service
public class UsuarioServiceImplement implements UsuariosService {

    private final UsuariosRepository usuariosRepository;
    private final PasswordEncoder passwordEncoder;

    public UsuarioServiceImplement(UsuariosRepository usuariosRepository, PasswordEncoder passwordEncoder) {
        this.usuariosRepository = usuariosRepository;
        this.passwordEncoder = passwordEncoder;
    }




    @Override
    public String register(RegisterRequest request) {
        String mensaje = "";

        Usuarios usuarioExistente = usuariosRepository.buscarPorEmail(request.getEmail());

        if (usuarioExistente != null) {
            return "El email ya existe";
        }

        Usuarios usuarios = Usuarios.builder()
                .nombreCompleto(request.getNombreCompleto())
                .password(passwordEncoder.encode(request.getPassword()))
                .email(request.getEmail())
                .build();

        usuariosRepository.save(usuarios);
        return "Usuario registrado con éxito!";
    }

    @Override
    public Integer buscarPorEmail(String nombre) {
        Usuarios user = usuariosRepository.buscarPorEmail(nombre);
        if (user==null) {
            throw new EntityNotFoundException("No se encontro el usuario con el nombre" + nombre);
        }

        return user.getId();
    }
}
