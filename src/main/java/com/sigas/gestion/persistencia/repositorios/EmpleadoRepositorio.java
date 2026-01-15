package com.sigas.gestion.persistencia.repositorios;

import com.sigas.gestion.persistencia.entidades.Empleado;
import org.springframework.data.repository.CrudRepository;

public interface EmpleadoRepositorio extends CrudRepository<Empleado, String> {
}
