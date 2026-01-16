package com.sigas.gestion.controladores;

import com.sigas.gestion.persistencia.entidades.Usuario;
import com.sigas.gestion.persistencia.repositorios.usuarioRepositorio;
import com.sigas.gestion.security.JwtService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final usuarioRepositorio usuarioRepositorio;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;

    public AuthController(usuarioRepositorio usuarioRepositorio,
                          PasswordEncoder passwordEncoder,
                          JwtService jwtService) {
        this.usuarioRepositorio = usuarioRepositorio;
        this.passwordEncoder = passwordEncoder;
        this.jwtService = jwtService;
    }

    @PostMapping("/login")
    public Map<String, String> login(@RequestBody Usuario request) {

        Usuario usuario = usuarioRepositorio
                .findByUsername(request.getUsername())
                .orElseThrow(() -> new RuntimeException("Credenciales inválidas"));

        if (!passwordEncoder.matches(
                request.getPassword(), usuario.getPassword())) {
            throw new RuntimeException("Credenciales inválidas");
        }

        String token = jwtService.generarToken(
                usuario.getUsername(),
                usuario.getSerial()
        );

        return Map.of("token", token);
    }



}
