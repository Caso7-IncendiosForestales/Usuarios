package com.conaf.usuarios.controller;

import com.conaf.usuarios.model.Usuario;
import com.conaf.usuarios.repository.UsuarioRepository;

// IMPORTACIONES ESTÁNDAR DE SPRING BOOT
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

// IMPORTACIONES EXIGIDAS POR LA PAUTA (OPENAPI / SWAGGER)
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.tags.Tag;

import java.util.List;

@RestController
@RequestMapping("/api/usuarios")
@Tag(name = "Gestión de Usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Operation(summary = "Obtener todos los usuarios")
    @ApiResponse(responseCode = "200", description = "Lista de usuarios obtenida exitosamente")
    @GetMapping
    public List<Usuario> obtenerTodos() {
        return usuarioRepository.findAll();
    }

    @Operation(summary = "Crear un nuevo usuario")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "201", description = "Usuario creado de forma exitosa",
            content = @Content(mediaType = "application/json", 
            schema = @Schema(implementation = Usuario.class),
            examples = @ExampleObject(
                name = "Ejemplo de Operador",
                value = "{\"nombreCompleto\": \"Carlos Fuentes Rivera\", \"email\": \"c.fuentes@conaf.cl\", \"password\": \"clavePruebaConaf2026\", \"rol\": \"OPERADOR\", \"estado\": \"ACTIVO\"}"
            ))),
        @ApiResponse(responseCode = "400", description = "Error en los datos de entrada")
    })
    @PostMapping
    public ResponseEntity<Usuario> crearUsuario(@RequestBody Usuario usuario) {
        try {
            Usuario nuevoUsuario = usuarioRepository.save(usuario);
            return new ResponseEntity<>(nuevoUsuario, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}