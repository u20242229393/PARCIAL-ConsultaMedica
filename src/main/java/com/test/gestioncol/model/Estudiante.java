package com.test.gestioncol.model;


import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table (name = "estudiante")
@Data
public class Estudiante {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "nombre_estudiante", nullable = false, length = 100)
    private String nombreEstudiante;

    @Column(nullable = false, length = 20)
    private String grado;

    @OneToOne
    @JoinColumn(name = "usuario_id", nullable = false)
    private Usuario usuario;


}
