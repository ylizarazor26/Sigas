package com.sigas.gestion.servicios;

import com.sigas.gestion.persistencia.entidades.Proveedor;
import com.sigas.gestion.persistencia.repositorios.ProveedorRepositorio;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@Transactional
public class ProveedorServicio {

    private final ProveedorRepositorio proveedorrepositorio;

    public ProveedorServicio(ProveedorRepositorio proveedorrepositorio) {
        this.proveedorrepositorio = proveedorrepositorio;
    }

    public List<Proveedor> obtenerTodos() {
        return proveedorrepositorio.findAll();
    }

    public Proveedor obtenerPorNit(Integer nit) {
        return proveedorrepositorio.findById(nit)
                .orElseThrow(() -> new RuntimeException("Centro de costos no encontrado"));
    }

    public Proveedor guardar(Proveedor proveedor, String motivo) {
        System.out.println("Auditoría: Cambio en Centro de Costos por: " + motivo);
        return proveedorrepositorio.save(proveedor);
    }

    public void eliminar(Integer nit, String motivo) {
        if (!proveedorrepositorio.existsById(nit)) {
            throw new RuntimeException("No se puede eliminar: ID no existe");
        }
        System.out.println("Auditoría: Eliminación de Centro de Costos ID " + nit + " por: " + motivo);
        proveedorrepositorio.deleteById(nit);
    }
}