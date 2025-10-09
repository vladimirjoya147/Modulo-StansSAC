package com.cibertec.ModuloStandsSAC.Controller;

import com.cibertec.ModuloStandsSAC.DTO.Auth.AuthResponse;
import com.cibertec.ModuloStandsSAC.DTO.Auth.LoginRequest;
import com.cibertec.ModuloStandsSAC.DTO.Auth.RefreshTokenRequest;
import com.cibertec.ModuloStandsSAC.DTO.Auth.RegisterRequest;
import com.cibertec.ModuloStandsSAC.Security.JwtService;
import com.cibertec.ModuloStandsSAC.Service.UsuariosService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final AuthenticationManager authenticationManager;
    private final UserDetailsService userDetailsService;
    private final JwtService jwtService;
    private final UsuariosService usuarioService;

    public AuthController(AuthenticationManager authenticationManager, UserDetailsService userDetailsService, JwtService jwtService, UsuariosService usuarioService) {
        this.authenticationManager = authenticationManager;
        this.userDetailsService = userDetailsService;
        this.jwtService = jwtService;
        this.usuarioService = usuarioService;
    }

    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login(@RequestBody LoginRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword())
        );
        var user = userDetailsService.loadUserByUsername(request.getEmail());

        Integer id = usuarioService.buscarPorEmail(request.getEmail());
        String accessToken = jwtService.generateToken(user,id);
        String refreshToken = jwtService.generateRefreshToken(user);
        return ResponseEntity.ok(new AuthResponse(accessToken, refreshToken));
    }

    @PostMapping("/refresh")
    public ResponseEntity<AuthResponse> refresh(@RequestBody RefreshTokenRequest request) {
        String refreshToken = request.getRefreshToken();
        String username = jwtService.extractUsername(refreshToken);
        var user = userDetailsService.loadUserByUsername(username);

        if (!jwtService.isTokenValid(refreshToken, user)) {
            return ResponseEntity.status(401).build();
        }
        Integer userId = jwtService.extractUserId(refreshToken);
        String newAccess = jwtService.generateToken(user, userId);
        return ResponseEntity.ok(new AuthResponse(newAccess, refreshToken));
    }

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody RegisterRequest request) {
        return ResponseEntity.ok(usuarioService.register(request));
    }

    @PostMapping("/correo")
    public ResponseEntity<Integer> reg(@RequestBody RegisterRequest request) {
        return ResponseEntity.ok(usuarioService.buscarPorEmail(request.getEmail()));
    }

}
