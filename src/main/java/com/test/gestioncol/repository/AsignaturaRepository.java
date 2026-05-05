package com.test.gestioncol.repository;

import com.test.gestioncol.model.Asignatura;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AsignaturaRepository extends JpaRepository<Asignatura, Integer> {
    List<Asignatura> findByDocenteId(Integer docenteId);
}
