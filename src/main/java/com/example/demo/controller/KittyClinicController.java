package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Usuario;
import com.example.demo.entity.gato;
import com.example.demo.repository.UsuarioRepository;
import com.example.demo.service.GatoService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController

@RequestMapping("/mascota")
@CrossOrigin(origins = "http://localhost:4200")

public class KittyClinicController {

    @Autowired
    GatoService GatoService;

    @Autowired
    UsuarioRepository RepoUsuario;

    // http://localhost:8090/muestra/lista
    @GetMapping("/lista")
    public List<gato> mostrarGatos(Model model) {

        // model.addAttribute("gatos", GatoService.SearchAll());
        return GatoService.SearchAll();
    }

    // http://localhost:8090/muestra/gato/id con id me refiero a un un numero
    // espefico ejm 1 2 3 4 si el numero es mas grande que la base falla
    @GetMapping("/gato/{id}")
    public gato mostrarInfo(Model model, @PathVariable("id") Long identificacion) {

        return GatoService.SearchById(identificacion);
    }

    @GetMapping("/agregar")
    public String mostrarCrearGato(Model model) {

        gato aux = new gato(null, null, null, null, null, null, true);

        model.addAttribute("gato", aux);

        return "crear_gato";
    }

    @PostMapping("/agregar")
    public void agregarGato(@ModelAttribute("gato") gato felino, @RequestParam Integer cedula) {

        Usuario usuario = RepoUsuario.findByCedula(cedula);

        if (usuario != null) {
            felino.setUsuario(usuario);
        } else {
            felino.setUsuario(null);
        }
        GatoService.add(felino);

    }

    @DeleteMapping("/delete/{id}")
    public void borrarGato(@PathVariable("id") Long identificacion) {
        GatoService.deleletebyid(identificacion);
    }

    @GetMapping("/update/{id}")
    public String mostrarUpdate(@PathVariable("id") Long identificacion, Model model) {

        model.addAttribute("gato", GatoService.SearchById(identificacion));
        return "modificar_gato";

    }

    @PutMapping("/update/{id}")
    public void updateGato(@RequestBody gato felino) {
        GatoService.update(felino);
    }

}
