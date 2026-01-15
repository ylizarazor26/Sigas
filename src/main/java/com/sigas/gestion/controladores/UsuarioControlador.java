package com.sigas.gestion.controladores;

import com.sigas.gestion.persistencia.entidades.Usuario;
import com.sigas.gestion.servicios.UsuarioServicio;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioControlador {

    private final UsuarioServicio servicio;

    public UsuarioControlador(UsuarioServicio servicio) {
        this.servicio = servicio;
    }

    // LISTAR
    @GetMapping
    public List<Usuario> listar() {
        return servicio.obtenerTodos();
    }

    // OBTENER POR ID
    @GetMapping("/{id}")
    public Usuario obtener(@PathVariable Integer id) {
        return servicio.obtenerPorId(id);
    }

    // CREAR
    @PostMapping
    public Usuario crear(@RequestBody Usuario usuario,
                         @RequestParam String motivo) {
        return servicio.guardar(usuario, motivo);
    }

    // ACTUALIZAR
    @PutMapping("/{id}")
    public Usuario actualizar(@PathVariable Integer id,
                              @RequestBody Usuario usuario,
                              @RequestParam String motivo) {
        usuario.setSerial(id);
        return servicio.guardar(usuario, motivo);
    }

    // ELIMINAR
    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Integer id,
                         @RequestParam String motivo) {
        servicio.eliminar(id, motivo);
    }
}
