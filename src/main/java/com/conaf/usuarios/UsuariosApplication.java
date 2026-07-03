package com.conaf.usuarios;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

@OpenAPIDefinition(
    info = @Info(
        title = "MS-01 Gestión de Usuarios",
        version = "1.0.0",
        description = "Microservicio para registrar y gestionar las cuentas de usuarios y sus respectivos roles en el sistema - CONAF"
    )
)
@SpringBootApplication
public class UsuariosApplication {

    public static void main(String[] args) {
        SpringApplication.run(UsuariosApplication.class, args);
    }
}
