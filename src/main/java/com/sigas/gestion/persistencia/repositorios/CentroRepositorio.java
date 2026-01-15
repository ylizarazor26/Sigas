package com.sigas.gestion.persistencia.repositorios;


import com.sigas.gestion.persistencia.entidades.CentroCostos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CentroRepositorio extends JpaRepository<CentroCostos, Integer> {
}