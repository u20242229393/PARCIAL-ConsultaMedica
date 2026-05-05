package com.test.gestioncol.services;

import com.test.gestioncol.model.Docente;
import com.test.gestioncol.repository.DocenteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DocenteService {

    private final DocenteRepository docenteReposiroty;

    public List<Docente> listarTodos() {
        return docenteReposiroty.findAll();
    }

    public Docente buscarPorId(Integer id) {
        return docenteReposiroty.findById(id).orElse(null);
    }

    public Docente buscarPorUsuarioId(Integer usuarioId) {
        return docenteReposiroty.findByUsuarioId(usuarioId).orElse(null);
    }

    public void guardar(Docente docente) {
        docenteReposiroty.save(docente);
    }
}
