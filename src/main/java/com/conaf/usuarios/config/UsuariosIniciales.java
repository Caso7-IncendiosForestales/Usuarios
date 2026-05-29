package com.conaf.usuarios.config;

import com.conaf.usuarios.model.Usuario;
import com.conaf.usuarios.repository.UsuarioRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import java.util.List;

@Configuration
public class UsuariosIniciales {

    @Bean
    CommandLineRunner initDatabaseUsuarios(UsuarioRepository repository) {
        return args -> {
            if (repository.count() == 0) {
                repository.saveAll(List.of(
                    new Usuario(null, "admin.conaf@conaf.cl", "admin123", "Administrador Central", "ADMIN", "ACTIVO"),
                    new Usuario(null, "mich.escobar@duocuc.cl", "solomon2026", "Michael Escobar", "OPERADOR", "ACTIVO")
                ));
            }
        };
    }
}