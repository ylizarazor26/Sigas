package com.sigas.gestion.controladores;

import com.sigas.gestion.persistencia.entidades.Proveedor;
import com.sigas.gestion.servicios.ProveedorServicio;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/proveedor")
public class ProveedorControlador {

    private final ProveedorServicio servicio;

    public ProveedorControlador(ProveedorServicio servicio) {
        this.servicio = servicio;
    }

    //Listar
    @GetMapping
    public List<Proveedor> listar() {
        return servicio.obtenerTodos();
    }

    //Crear
    @PostMapping
    public Proveedor crear(@RequestBody Proveedor proveedor, @RequestParam String motivo) {
        return servicio.guardar(proveedor, motivo);
    }

    @PutMapping("/{nit}")
    public Proveedor actualizar(@PathVariable Integer nit, @RequestBody Proveedor proveedor, @RequestParam String motivo) {
        proveedor.setNit(nit);
        return servicio.guardar(proveedor, motivo);
    }

    @DeleteMapping("/{nit}")
    public void eliminar(@PathVariable Integer nit, @RequestParam String motivo) {
        servicio.eliminar(nit, motivo);
    }
}