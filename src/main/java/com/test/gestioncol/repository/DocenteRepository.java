package com.test.gestioncol.repository;

import com.test.gestioncol.model.Docente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface DocenteRepository extends JpaRepository<Docente,Integer> {
    Optional<Docente> findByUsuarioId(Integer usuarioId);
}
