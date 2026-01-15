package com.sigas.gestion.persistencia.repositorios;
import com.sigas.gestion.persistencia.entidades.Proveedor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProveedorRepositorio extends JpaRepository<Proveedor, Integer> {
}
