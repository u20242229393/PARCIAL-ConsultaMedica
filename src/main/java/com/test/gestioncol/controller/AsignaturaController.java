package com.test.gestioncol.controller;

import com.test.gestioncol.model.Asignatura;
import com.test.gestioncol.model.Docente;
import com.test.gestioncol.model.Usuario;
import com.test.gestioncol.repository.UsuarioRepository;
import com.test.gestioncol.services.AsignaturaService;
import com.test.gestioncol.services.DocenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalTime;
import java.util.List;

@Controller
@RequestMapping("/asignatura")
public class AsignaturaController {

    @Autowired
    private AsignaturaService asignaturaService;

    @Autowired
    private DocenteService docenteService;

    @Autowired
    private UsuarioRepository usuarioRepository;


    @GetMapping
    public String lista(Model model, Authentication auth) {
        String email = auth.getName();
        Usuario usuario = usuarioRepository.findByEmail(email).orElse(null);

        if (usuario != null) {
            String rol = usuario.getRol().getNombre();
            model.addAttribute("rol", rol);

            if (rol.equals("DOCENTE")) {
                Docente docente = docenteService.buscarPorUsuarioId(usuario.getId().intValue());
                if (docente != null) {
                    model.addAttribute("asignaturas", asignaturaService.listarPorDocente(docente.getId()));
                } else {
                    model.addAttribute("asignaturas", List.of());
                }
            } else {
                model.addAttribute("asignaturas", asignaturaService.listarTodos());
            }
        }

        return "asignatura/lista";
    }


    @GetMapping("/ver/{id}")
    public String ver(@PathVariable Integer id, Model model, Authentication auth) {
        Asignatura asignatura = asignaturaService.buscarPorId(id);

        if (asignatura == null) {
            return "redirect:/asignatura";
        }

        String email = auth.getName();
        Usuario usuario = usuarioRepository.findByEmail(email).orElse(null);
        model.addAttribute("asignatura", asignatura);
        model.addAttribute("rol", usuario != null ? usuario.getRol().getNombre() : "");

        return "asignatura/detalle";
    }


    @GetMapping("/nueva")
    public String mostrarFormulario(Model model) {
        List<Docente> docentes = docenteService.listarTodos();
        model.addAttribute("asignatura", new Asignatura());
        model.addAttribute("docentes", docentes);
        return "asignatura/form";
    }

    @PostMapping
    public String guardar(@ModelAttribute("asignatura") Asignatura asignatura) {
        asignaturaService.guardar(asignatura);
        return "redirect:/asignatura";
    }


    @GetMapping("/editar/{id}")
    public String editar(@PathVariable Integer id, Model model) {
        Asignatura asignatura = asignaturaService.buscarPorId(id);

        if (asignatura == null) {
            return "redirect:/asignatura";
        }

        List<Docente> docentes = docenteService.listarTodos();
        model.addAttribute("asignatura", asignatura);
        model.addAttribute("docentes", docentes);
        return "asignatura/form";
    }


    @GetMapping("/eliminar/{id}")
    public String eliminar(@PathVariable Integer id) {
        Asignatura asignatura = asignaturaService.buscarPorId(id);

        if (asignatura != null) {
            asignaturaService.eliminar(asignatura);
        }

        return "redirect:/asignatura";
    }


    @GetMapping("/actualizar-horario/{id}")
    public String mostrarFormularioHorario(@PathVariable Integer id, Model model, Authentication auth) {
        Asignatura asignatura = asignaturaService.buscarPorId(id);

        if (asignatura == null) {
            return "redirect:/asignatura";
        }

        String email = auth.getName();
        Usuario usuario = usuarioRepository.findByEmail(email).orElse(null);

        if (usuario != null && usuario.getRol().getNombre().equals("DOCENTE")) {
            Docente docente = docenteService.buscarPorUsuarioId(usuario.getId().intValue());

            if (docente == null || !asignatura.getDocente().getId().equals(docente.getId())) {
                return "redirect:/acceso-denegado";
            }
        }

        model.addAttribute("asignatura", asignatura);
        return "asignatura/form-horario";
    }

    @PostMapping("/actualizar-horario")
    public String actualizarHorario(@RequestParam("id") Integer id,
                                    @RequestParam("horaInicio") @DateTimeFormat(pattern = "HH:mm") LocalTime horaInicio,
                                    @RequestParam("horaFin") @DateTimeFormat(pattern = "HH:mm") LocalTime horaFin,
                                    Authentication auth) {


        String email = auth.getName();
        Usuario usuario = usuarioRepository.findByEmail(email).orElse(null);

        if (usuario != null && usuario.getRol().getNombre().equals("DOCENTE")) {
            Docente docente = docenteService.buscarPorUsuarioId(usuario.getId().intValue());
            Asignatura asignaturaExistente = asignaturaService.buscarPorId(id);

            if (docente == null || asignaturaExistente == null ||
                    !asignaturaExistente.getDocente().getId().equals(docente.getId())) {
                return "redirect:/acceso-denegado";
            }
        }

        asignaturaService.actualizarHorario(id, horaInicio, horaFin);
        return "redirect:/asignatura";
    }
}
