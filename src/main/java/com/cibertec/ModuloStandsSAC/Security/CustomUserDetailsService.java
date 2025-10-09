package com.cibertec.ModuloStandsSAC.Security;

import com.cibertec.ModuloStandsSAC.Entity.Usuarios;
import com.cibertec.ModuloStandsSAC.Repository.UsuariosRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;



@Service
public class CustomUserDetailsService implements UserDetailsService {

    private final UsuariosRepository usuariosRepository;
    private static final Logger logger = LoggerFactory.getLogger(CustomUserDetailsService.class);
    public CustomUserDetailsService(UsuariosRepository usuariosRepository) {
        this.usuariosRepository = usuariosRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        logger.info("Buscando usuario con email: {}", username);

        Usuarios usuarios = usuariosRepository.buscarPorEmail(username);
                /*.orElseThrow(() -> {
                    logger.error("Email no encontrado: {}", username);
                    return new UsernameNotFoundException("Email no encontrado: " + username);
                });*/

        logger.info("Usuario encontrado: {}", usuarios.getEmail());
        return new CustomUserDetails(usuarios);
    }
}
