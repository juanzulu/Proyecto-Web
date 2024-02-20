package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.service.GatoService;

@Controller
@RequestMapping("/prueba")
public class KittyClinicController {

    @Autowired
    GatoService GatoService;

    // http://localhost:8090/prueba/lista
    @GetMapping("/lista")
    public String mostrarGatos(Model model) {
        model.addAttribute("gatos", GatoService.SearchAll());
        return "lista";
    }

    // http://localhost:8090/prueba/gato/id con id me refiero a un un numero
    // espefico ejm 1 2 3 4 si el numero es mas grande que la base falla
    @GetMapping("/gato/{id}")
    public String mostrarInfo(Model model, @PathVariable("id") int identificacion) {

        model.addAttribute("gato", GatoService.SearchNyId(identificacion));
        return "gato";
    }

}
