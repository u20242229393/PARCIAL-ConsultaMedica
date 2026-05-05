package com.test.gestioncol.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;

import java.util.List;

@Entity
@Table(name = "docente")
@Data
public class Docente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "nombre_docente", nullable = false, length = 100)
    private String nombreDocente;

    @Column(length = 50)
    private String especialidad;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "usuario_id", nullable = false)
    @JsonIgnore
    @ToString.Exclude
    private Usuario usuario;

    @OneToMany(mappedBy = "docente")
    private List<Asignatura> asignaturas;
}
