package com.sigas.gestion.servicios;

import com.sigas.gestion.persistencia.entidades.CentroCostos;
import com.sigas.gestion.persistencia.repositorios.CentroRepositorio;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
@Transactional
public class CentroServicio {

    private final CentroRepositorio repositorio;

    public CentroServicio(CentroRepositorio repositorio) {
        this.repositorio = repositorio;
    }

    public List<CentroCostos> obtenerTodos() {
        return repositorio.findAll();
    }

    public CentroCostos obtenerPorId(Integer id) {
        return repositorio.findById(id)
                .orElseThrow(() -> new RuntimeException("Centro de costos no encontrado"));
    }

    public CentroCostos guardar(CentroCostos centro, String motivo) {
        System.out.println("Auditoría: Cambio en Centro de Costos por: " + motivo);
        return repositorio.save(centro);
    }

    public void eliminar(Integer id, String motivo) {
        if (!repositorio.existsById(id)) {
            throw new RuntimeException("No se puede eliminar: ID no existe");
        }
        System.out.println("Auditoría: Eliminación de Centro de Costos ID " + id + " por: " + motivo);
        repositorio.deleteById(id);
    }
}