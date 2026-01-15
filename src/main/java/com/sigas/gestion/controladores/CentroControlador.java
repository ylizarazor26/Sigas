package com.sigas.gestion.controladores;

import com.sigas.gestion.persistencia.entidades.CentroCostos;
import com.sigas.gestion.servicios.CentroServicio;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/centro-costos")
public class CentroControlador {

    private final CentroServicio servicio;

    public CentroControlador(CentroServicio servicio) {
        this.servicio = servicio;
    }

    //Listar
    @GetMapping
    public List<CentroCostos> listar() {
        return servicio.obtenerTodos();
    }

    //Crear
    @PostMapping
    public CentroCostos crear(@RequestBody CentroCostos centro, @RequestParam String motivo) {
        return servicio.guardar(centro, motivo);
    }

    @PutMapping("/{id}")
    public CentroCostos actualizar(@PathVariable Integer id, @RequestBody CentroCostos centro, @RequestParam String motivo) {
        centro.setId(id);
        return servicio.guardar(centro, motivo);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Integer id, @RequestParam String motivo) {
        servicio.eliminar(id, motivo);
    }
}