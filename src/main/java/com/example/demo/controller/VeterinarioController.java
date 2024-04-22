package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Veterinario;
import com.example.demo.repository.VeterinarioRepository;
import com.example.demo.service.VeterinarioService;

@RestController
@RequestMapping("/Admin")
@CrossOrigin (origins =  "http://localhost:4200")
public class VeterinarioController {

    @Autowired
    VeterinarioService veterinarioService;

    @Autowired
    VeterinarioRepository RepoVeterinario;

    @GetMapping("/veterinario")
    public List<Veterinario> SearchAll() {
        return veterinarioService.SearchAll();
    }

    @PostMapping("/agregar/veterinario")
    public void add(@RequestBody Veterinario veterinario) {
        veterinarioService.add(veterinario);
    }

    @PutMapping ("/actualizar/veterinario")
    public void update(@RequestBody Veterinario veterinario) {
        veterinarioService.update(veterinario);
    }

    
}
