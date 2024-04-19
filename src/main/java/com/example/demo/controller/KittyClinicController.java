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

    // http://localhost:8090/mascota/lista
    @GetMapping("/lista")
    public List<gato> mostrarGatos(Model model) {
        // model.addAttribute("gatos", GatoService.SearchAll());
        return GatoService.SearchAll();
    }

    // http://localhost:8090/mascota/estado/{id}
    @GetMapping("/estado/{id}")
    public boolean ConsultarEstado(@PathVariable("id") Long id) {
        return GatoService.ConsultarEstado(id);
    }


    @PostMapping("/estado/{id}")
    public void cambiarEstado(@PathVariable("id") Long id) {
       
        GatoService.cambiarEstado( GatoService.SearchById(id));
    }
    // http://localhost:8090/mascota/gato/id 
    @GetMapping("/gato/{id}")
    public gato mostrarInfo(Model model, @PathVariable("id") Long identificacion) {

        return GatoService.SearchById(identificacion);
    }

    // http://localhost:8090/mascota/agregar 
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

    // http://localhost:8090/mascota/delete/id
    @DeleteMapping("/delete/{id}")
    public void borrarGato(@PathVariable("id") Long identificacion) {
        GatoService.deleletebyid(identificacion);
    }


     // http://localhost:8090/mascota/update/id
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
