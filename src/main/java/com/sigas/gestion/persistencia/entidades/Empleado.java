package com.sigas.gestion.persistencia.entidades;

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
    private Long cedula;

    @Column(name = "nombre")
    private String nombre;
    @Column(name = "apellido")
    private String apellido;

    @Column(name = "centro_costos")
    private String centroCostos;

    @Column(name = "rol")
    private String rol;

    @OneToOne(mappedBy = "empleado")
    private Usuario usuario;
}