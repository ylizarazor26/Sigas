package com.sigas.gestion.persistencia.repositorios;
import com.sigas.gestion.persistencia.entidades.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface usuarioRepositorio extends JpaRepository<Usuario, Integer> {
    Optional<Usuario> findByUsername(String username);
}