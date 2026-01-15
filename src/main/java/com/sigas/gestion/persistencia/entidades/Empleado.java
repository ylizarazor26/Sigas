package com.sigas.gestion.persistencia.entidades;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "empleados")
public class Empleado {
    @Id
    @Column(name = "cedula")
    private String cedula;

    @Column(name = "nombre")
    private String nombre;
    @Column(name = "apellido")
    private String apellido;
    @Column(name = "rol")
    private String rol;

    @ManyToOne
    @JoinColumn(name = "id_centro_costos")
    private CentroCostos centroCostos;

    @OneToOne(mappedBy = "empleado")
    @JsonIgnore
    private Usuario usuario;
}