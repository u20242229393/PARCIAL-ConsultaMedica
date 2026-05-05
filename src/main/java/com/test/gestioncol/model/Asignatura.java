package com.test.gestioncol.model;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;

import java.time.LocalTime;

@Entity
@Table(name = "asignatura")
@Data
@Schema(description = "Entidad que representa una asignatura académica dentro del colegio")
public class Asignatura {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(
            description = "Identificador único de la asignatura",
            example = "1",
            accessMode = Schema.AccessMode.READ_ONLY
    )
    private Integer id;

    @Column(nullable = false, length = 30)
    @Schema(
            description = "Nombre de la asignatura",
            example = "Matemáticas",
            maxLength = 30,
            requiredMode = Schema.RequiredMode.REQUIRED
    )
    private String nombre;

    @Column(length = 100)
    @Schema(
            description = "Descripción breve de la asignatura",
            example = "Asignatura orientada al desarrollo del pensamiento lógico y numérico",
            maxLength = 100
    )
    private String descripcion;

    @Column(nullable = false)
    @Schema(
            description = "Número del salón donde se dicta la asignatura",
            example = "204",
            requiredMode = Schema.RequiredMode.REQUIRED
    )
    private Integer salon;

    @Column(name = "hora_inicio", nullable = false)
    @Schema(
            description = "Hora de inicio de la asignatura",
            example = "08:00:00",
            requiredMode = Schema.RequiredMode.REQUIRED
    )
    private LocalTime horaInicio;

    @Column(name = "hora_fin", nullable = false)
    @Schema(
            description = "Hora de finalización de la asignatura",
            example = "10:00:00",
            requiredMode = Schema.RequiredMode.REQUIRED
    )
    private LocalTime horaFin;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "docente_id", nullable = false)
    @ToString.Exclude
    @Schema(
            description = "Docente asignado a la materia",
            requiredMode = Schema.RequiredMode.REQUIRED
    )
    private Docente docente;
}