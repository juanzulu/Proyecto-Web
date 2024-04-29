package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Veterinario;
import com.example.demo.service.VeterinarioService;

@RestController
@RequestMapping("/admin")
@CrossOrigin(origins = "http://localhost:4200")
public class VeterinarioController {

    @Autowired
    VeterinarioService veterinarioService;

    @Autowired

    @GetMapping("/veterinario")
    public List<Veterinario> SearchAll() {
        return veterinarioService.SearchAll();
    }

    @PostMapping("/agregar")
    public void agregarVeterinario(@RequestBody Veterinario veterinario) {
        veterinarioService.add(veterinario);
    }

    @GetMapping("/veterinario/{id}")
    public Veterinario SearchById(@PathVariable("id") Long id) {
        return veterinarioService.SearchById(id);
    }

    @PutMapping("/estado/{id}")
    public void cambiarEstado(@PathVariable("id") Long id) {
        veterinarioService.cambiarEstado(veterinarioService.SearchById(id));
    }

    @PutMapping("/actualizar/veterinario")
    public void update(@RequestBody Veterinario veterinario) {
        veterinarioService.update(veterinario);
    }

    @DeleteMapping("/delete/{id}")
    public void borrarVeterinario(@PathVariable("id") Long id) {
        veterinarioService.deleletebyid(id);
    }

    @GetMapping("/veterinario/activos")
    public List<Veterinario> consultarVeterinariosActivos() {
        return veterinarioService.consultarVeterinariosActivos();
    }

    // http://localhost:8090/admin/veterinario/inactivos
    @GetMapping("/veterinario/inactivos")
    public List<Veterinario> consultarVeterinariosInactivos() {
        return veterinarioService.consultarVeterinariosInactivos();
    }

    // http://localhost:8090/admin/veterinario/activos/count
    @GetMapping("/veterinario/activos/count")
    public long countVeterinariosActivos() {
        return veterinarioService.countVeterinariosActivos();
    }

    // http://localhost:8090/admin/veterinario/inactivos/count
    @GetMapping("/veterinario/inactivos/count")
    public long countVeterinariosInactivos() {
        return veterinarioService.countVeterinariosInactivos();
    }

    @PostMapping("/login")
    public ResponseEntity<Veterinario> loginVeterinario(@RequestBody Veterinario vet) {
        return veterinarioService.Login(vet.getCorreo(), vet.getPassword())
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.status(HttpStatus.UNAUTHORIZED).build());
    }
}
