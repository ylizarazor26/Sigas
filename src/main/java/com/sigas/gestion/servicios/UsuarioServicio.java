package com.sigas.gestion.servicios;

import com.sigas.gestion.persistencia.entidades.Usuario;
import com.sigas.gestion.persistencia.repositorios.usuarioRepositorio;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UsuarioServicio {

    private final usuarioRepositorio repositorio;
    private final PasswordEncoder passwordEncoder;

    public UsuarioServicio(usuarioRepositorio repositorio,
                           PasswordEncoder passwordEncoder) {
        this.repositorio = repositorio;
        this.passwordEncoder = passwordEncoder;
    }

    public List<Usuario> obtenerTodos() {
        return repositorio.findAll();
    }

    public Usuario obtenerPorId(Integer id) {
        return repositorio.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
    }

    public Usuario guardar(Usuario usuario, String motivo) {

        if (!usuario.getPassword().startsWith("$2a$")) {
            usuario.setPassword(passwordEncoder.encode(usuario.getPassword()));
        }

        System.out.println("Auditoría Usuario: " + motivo);
        return repositorio.save(usuario);
    }

    public void eliminar(Integer id, String motivo) {
        if (!repositorio.existsById(id)) {
            throw new RuntimeException("Usuario no existe");
        }
        System.out.println("Auditoría Usuario: eliminación por " + motivo);
        repositorio.deleteById(id);
    }
}
