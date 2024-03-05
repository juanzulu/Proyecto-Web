package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.entity.Usuario;
import com.example.demo.entity.gato;
import com.example.demo.repository.UsuarioRepository;
import com.example.demo.service.GatoService;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequestMapping("/muestra")
public class KittyClinicController {

    @Autowired
    GatoService GatoService;

    @Autowired
    UsuarioRepository RepoUsuario;

    // http://localhost:8090/muestra/lista
    @GetMapping("/lista")
    public String mostrarGatos(Model model) {
        model.addAttribute("gatos", GatoService.SearchAll());
        return "lista";
    }

    // http://localhost:8090/muestra/gato/id con id me refiero a un un numero
    // espefico ejm 1 2 3 4 si el numero es mas grande que la base falla
    @GetMapping("/gato/{id}")
    public String mostrarInfo(Model model, @PathVariable("id") Long identificacion) {

        gato felino = GatoService.SearchNyId(identificacion);

        if (felino != null) {
            model.addAttribute("gato", GatoService.SearchNyId(identificacion));
        } else {
            // throw new NotFoundException(identificacion);
        }
        return "gato";
    }

    @GetMapping("/add")
    public String mostrarCrearGato(Model model) {

        gato aux = new gato(null, null, null, null, null);

        model.addAttribute("gato", aux);

        return "crear_gato";
    }

    @PostMapping("/agregar")
    public String agregarGato(@ModelAttribute("gato") gato felino, @RequestParam Integer cedula) {

        Usuario usuario = RepoUsuario.findByCedula(cedula);

        if (usuario != null) {
            felino.setUsuario(usuario);
        }

        GatoService.add(felino);
        return "redirect:/muestra/lista";
    }

    @GetMapping("/delete/{id}")
    public String borrarGato(@PathVariable("id") Long identificacion) {
        GatoService.deleletebyid(identificacion);
        return "redirect:/muestra/lista";
    }

    @GetMapping("/update/{id}")
    public String mostrarUpdate(@PathVariable("id") Long identificacion, Model model) {

        model.addAttribute("gato", GatoService.SearchNyId(identificacion));
        return "modificar_gato";

    }

    @PostMapping("/update/{id}")
    public String updateGato(@PathVariable("id") int identificacion, @ModelAttribute("gato") gato felino) {
        GatoService.update(felino);
        return "redirect:/muestra/lista";
    }

}
