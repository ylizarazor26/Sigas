package com.sigas.gestion.servicios;

import com.sigas.gestion.persistencia.entidades.Empleado;
import com.sigas.gestion.persistencia.repositorios.EmpleadoRepositorio;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@Transactional
public class EmpleadoServicio  {

    private final EmpleadoRepositorio empleadoRepositorio;

    public EmpleadoServicio(EmpleadoRepositorio empleadoRepositorio) {
        this.empleadoRepositorio = empleadoRepositorio;
    }

    public List<Empleado> obtenerTodos() {
        return (List<Empleado>) empleadoRepositorio.findAll();
    }

    public Empleado obtenerPorCedula(String cedula) {
        return empleadoRepositorio.findById(cedula)
                .orElseThrow(() -> new RuntimeException("Empleado no encontrado"));
    }

    // CREAR
    public Empleado crear(Empleado empleado) {
        return empleadoRepositorio.save(empleado);
    }

    // ACTUALIZAR
    public Empleado actualizar(String cedula, Empleado datos) {

        Empleado existente = empleadoRepositorio.findById(cedula)
                .orElseThrow(() -> new RuntimeException("Empleado no existe"));

        existente.setNombre(datos.getNombre());
        existente.setApellido(datos.getApellido());
        existente.setRol(datos.getRol());
        existente.setCentroCostos(datos.getCentroCostos());

        return empleadoRepositorio.save(existente);
    }

    public void eliminarPorCedula(String cedula) {
        if (!empleadoRepositorio.existsById(cedula)) {
            throw new RuntimeException("Empleado no encontrado con cédula: " + cedula);
        }
        empleadoRepositorio.deleteById(cedula);
    }
}
