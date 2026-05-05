package com.test.gestioncol.controller;


import com.test.gestioncol.model.Estudiante;
import com.test.gestioncol.services.EstudianteService;
import com.test.gestioncol.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/estudiante")
public class EstudianteController {

    @Autowired
    private EstudianteService estudianteService;

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping
    public String listar(Model model) {
        model.addAttribute("estudiantes", estudianteService.listarTodos());
        return "estudiante/lista";
    }

    @GetMapping("/nuevo")
    public String mostrarFormulario(Model model) {
        model.addAttribute("estudiante", new Estudiante());
        return "estudiante/form";
    }

    @PostMapping("/guardar")
    public String guardar(@ModelAttribute("estudiante") Estudiante estudiante) {
        estudianteService.guardar(estudiante);
        return "redirect:/estudiante";
    }
}
