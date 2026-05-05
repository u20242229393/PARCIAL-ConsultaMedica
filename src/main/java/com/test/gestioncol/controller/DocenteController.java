package com.test.gestioncol.controller;

import com.test.gestioncol.model.Docente;
import com.test.gestioncol.services.DocenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/docente")
public class DocenteController {

    @Autowired
    private DocenteService docenteService;

    @GetMapping
    public String listar(Model model) {
        model.addAttribute("docentes", docenteService.listarTodos());
        return "docente/lista";
    }

    @GetMapping("/nuevo")
    public String mostrarFormulario(Model model) {
        model.addAttribute("docente", new Docente());
        return "docente/form";
    }

    @PostMapping("/guardar")
    public String guardar(@ModelAttribute("docente") Docente docente) {
        docenteService.guardar(docente);
        return "redirect:/docente";
    }
}
