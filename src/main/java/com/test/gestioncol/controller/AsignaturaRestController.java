package com.test.gestioncol.controller;

import com.test.gestioncol.model.Asignatura;
import com.test.gestioncol.services.AsignaturaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/asignaturas")
@Tag(
        name = "Asignaturas",
        description = "Operaciones REST para administrar las asignaturas del colegio"
)
public class AsignaturaRestController {

    @Autowired
    private AsignaturaService asignaturaService;

    @GetMapping
    @Operation(
            summary = "Consultar todas las asignaturas",
            description = """
                    Retorna el listado completo de asignaturas registradas en el sistema.

                    Este endpoint puede ser consultado por usuarios con rol:
                    - RECTOR
                    - DOCENTE
                    - ESTUDIANTE
                    """
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Listado de asignaturas obtenido correctamente"),
            @ApiResponse(responseCode = "403", description = "El usuario no tiene permisos para acceder al recurso"),
            @ApiResponse(responseCode = "500", description = "Error interno del servidor")
    })
    @PreAuthorize("hasAnyRole('RECTOR', 'DOCENTE', 'ESTUDIANTE')")
    public ResponseEntity<List<Asignatura>> listarTodas() {
        return ResponseEntity.ok(asignaturaService.listarTodos());
    }

    @GetMapping("/{id}")
    @Operation(
            summary = "Consultar una asignatura por ID",
            description = """
                    Busca una asignatura específica usando su identificador único.

                    Si la asignatura existe, se retorna su información completa.
                    Si no existe, se responde con estado 404.
                    """
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Asignatura encontrada correctamente"),
            @ApiResponse(responseCode = "404", description = "No se encontró una asignatura con el ID indicado"),
            @ApiResponse(responseCode = "403", description = "El usuario no tiene permisos para acceder al recurso"),
            @ApiResponse(responseCode = "500", description = "Error interno del servidor")
    })
    @PreAuthorize("hasAnyRole('RECTOR', 'DOCENTE', 'ESTUDIANTE')")
    public ResponseEntity<Asignatura> obtenerPorId(
            @Parameter(
                    description = "Identificador único de la asignatura",
                    example = "1",
                    required = true
            )
            @PathVariable Integer id
    ) {
        Asignatura asignatura = asignaturaService.buscarPorId(id);
        return asignatura != null ? ResponseEntity.ok(asignatura) : ResponseEntity.notFound().build();
    }

    @PostMapping
    @Operation(
            summary = "Registrar una nueva asignatura",
            description = """
                    Permite crear una nueva asignatura en el sistema.

                    Esta operación solo puede ser realizada por usuarios con rol RECTOR.
                    """
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Asignatura creada correctamente"),
            @ApiResponse(responseCode = "400", description = "Los datos enviados no son válidos"),
            @ApiResponse(responseCode = "403", description = "Acceso denegado. Solo el rol RECTOR puede crear asignaturas"),
            @ApiResponse(responseCode = "500", description = "Error interno del servidor")
    })
    @PreAuthorize("hasRole('RECTOR')")
    public ResponseEntity<Asignatura> crear(
            @Parameter(
                    description = "Datos de la asignatura que se desea registrar",
                    required = true
            )
            @RequestBody Asignatura asignatura
    ) {
        return ResponseEntity.ok(asignaturaService.guardar(asignatura));
    }

    @PutMapping("/{id}")
    @Operation(
            summary = "Actualizar una asignatura existente",
            description = """
                    Actualiza la información de una asignatura registrada previamente.

                    Primero se valida que exista una asignatura con el ID indicado.
                    Si existe, se actualizan sus datos.
                    Si no existe, se retorna estado 404.

                    Esta operación está permitida únicamente para usuarios con rol RECTOR.
                    """
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Asignatura actualizada correctamente"),
            @ApiResponse(responseCode = "400", description = "Los datos enviados no son válidos"),
            @ApiResponse(responseCode = "404", description = "No se encontró una asignatura con el ID indicado"),
            @ApiResponse(responseCode = "403", description = "Acceso denegado. Solo el rol RECTOR puede actualizar asignaturas"),
            @ApiResponse(responseCode = "500", description = "Error interno del servidor")
    })
    @PreAuthorize("hasRole('RECTOR')")
    public ResponseEntity<Asignatura> actualizar(
            @Parameter(
                    description = "Identificador de la asignatura que se desea actualizar",
                    example = "1",
                    required = true
            )
            @PathVariable Integer id,

            @Parameter(
                    description = "Nuevos datos de la asignatura",
                    required = true
            )
            @RequestBody Asignatura asignatura
    ) {
        Asignatura existente = asignaturaService.buscarPorId(id);

        if (existente == null) {
            return ResponseEntity.notFound().build();
        }

        asignatura.setId(id);
        return ResponseEntity.ok(asignaturaService.guardar(asignatura));
    }

    @DeleteMapping("/{id}")
    @Operation(
            summary = "Eliminar una asignatura",
            description = """
                    Elimina una asignatura registrada en el sistema usando su ID.

                    Si la asignatura existe, se elimina correctamente.
                    Si no existe, se retorna estado 404.

                    Esta operación solo está permitida para usuarios con rol RECTOR.
                    """
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Asignatura eliminada correctamente"),
            @ApiResponse(responseCode = "404", description = "No se encontró una asignatura con el ID indicado"),
            @ApiResponse(responseCode = "403", description = "Acceso denegado. Solo el rol RECTOR puede eliminar asignaturas"),
            @ApiResponse(responseCode = "500", description = "Error interno del servidor")
    })
    @PreAuthorize("hasRole('RECTOR')")
    public ResponseEntity<Void> eliminar(
            @Parameter(
                    description = "Identificador de la asignatura que se desea eliminar",
                    example = "1",
                    required = true
            )
            @PathVariable Integer id
    ) {
        Asignatura asignatura = asignaturaService.buscarPorId(id);

        if (asignatura != null) {
            asignaturaService.eliminar(asignatura);
            return ResponseEntity.ok().build();
        }

        return ResponseEntity.notFound().build();
    }
}