package com.test.gestioncol.services;

import com.test.gestioncol.model.Asignatura;
import com.test.gestioncol.repository.AsignaturaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AsignaturaService {

    private final AsignaturaRepository asignaturaRepository;

    public List<Asignatura> listarTodos() {
        return asignaturaRepository.findAll();
    }

    public List<Asignatura> listarPorDocente(Integer docenteId) {
        return asignaturaRepository.findByDocenteId(docenteId);
    }

    public Asignatura guardar(Asignatura asignatura) {
        return asignaturaRepository.save(asignatura);
    }

    public void eliminar(Asignatura asignatura) {
        asignaturaRepository.delete(asignatura);
    }

    public Asignatura buscarPorId(Integer id) {
        return asignaturaRepository.findById(id).orElse(null);
    }


    public void actualizarHorario(Integer id, LocalTime horaInicio, LocalTime horaFin) {
        Asignatura asignatura = buscarPorId(id);
        if (asignatura != null) {
            asignatura.setHoraInicio(horaInicio);
            asignatura.setHoraFin(horaFin);
            asignaturaRepository.save(asignatura);
        }
    }
}
