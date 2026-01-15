package com.sigas.gestion.controladores;

import com.sigas.gestion.persistencia.entidades.Empleado;
import com.sigas.gestion.servicios.EmpleadoServicio;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/empleados")
public class EmpleadoControlador {

    private final EmpleadoServicio servicio;

    public EmpleadoControlador(EmpleadoServicio servicio) {
        this.servicio = servicio;
    }

    // LISTAR
    @GetMapping
    public List<Empleado> listar() {
        return servicio.obtenerTodos();
    }

    // OBTENER
    @GetMapping("/{cedula}")
    public Empleado obtener(@PathVariable String cedula) {
        return servicio.obtenerPorCedula(cedula);
    }

    // CREAR
    @PostMapping
    public Empleado crear(@RequestBody Empleado empleado) {
        return servicio.crear(empleado);
    }

    // ACTUALIZAR
    @PutMapping("/{cedula}")
    public Empleado actualizar(@PathVariable String cedula,
                               @RequestBody Empleado empleado) {
        return servicio.actualizar(cedula, empleado);
    }

    // ELIMINAR
    @DeleteMapping("/{cedula}")
    public void eliminar(@PathVariable String cedula) {
        servicio.eliminarPorCedula(cedula);
    }
}
