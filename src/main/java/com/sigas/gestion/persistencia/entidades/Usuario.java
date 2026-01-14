package com.sigas.gestion.persistencia.entidades;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Setter
@Getter
@Table(name = "usuario")
@Entity

public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int serial;

    @Column(name = "username")
    public String username;
    @Column(name = "password")
    public String password;

    @OneToOne
    @JoinColumn(name = "empleado_cedula", referencedColumnName = "cedula")
    private Empleado empleado;


}






