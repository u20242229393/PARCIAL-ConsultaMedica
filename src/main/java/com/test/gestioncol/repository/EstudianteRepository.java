package com.test.gestioncol.repository;

import com.test.gestioncol.model.Estudiante;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EstudianteRepository extends JpaRepository<Estudiante,Integer> {
    Optional<Estudiante> findByUsuarioUsername(String username);
}
