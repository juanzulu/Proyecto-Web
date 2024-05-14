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

import com.example.demo.DTOs.VeterinarioDTO;
import com.example.demo.DTOs.VeterinarioMapper;
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
    public ResponseEntity<List<VeterinarioDTO>> SearchAll() {
        List<Veterinario> lista = veterinarioService.SearchAll();
        List<VeterinarioDTO> listaDTO = (List<VeterinarioDTO>) VeterinarioMapper.INSTANCE.convertlList(lista);
        ResponseEntity<List<VeterinarioDTO>> response = new ResponseEntity<>(listaDTO, HttpStatus.OK);
        return response;
    }

    @PostMapping("/agregar")
    public ResponseEntity agregarVeterinario(@RequestBody Veterinario veterinario) {
        
        Veterinario veterinario2 = veterinarioService.add(veterinario);
        
        if (veterinario2 == null) {
            return new ResponseEntity<String>("Veterinario no encontrado",HttpStatus.BAD_REQUEST);
            
        }
        VeterinarioDTO veterinarioDTO = VeterinarioMapper.INSTANCE.convert(veterinario2);
        if (veterinario2 != null) {
            return new ResponseEntity<VeterinarioDTO>(veterinarioDTO, HttpStatus.BAD_REQUEST);

        }
        return new ResponseEntity<VeterinarioDTO>(veterinarioDTO, HttpStatus.OK);
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
    public ResponseEntity loginVeterinario(@RequestBody Veterinario vet) {
        System.out.println(vet.getCorreo() + vet.getPassword());
        vet = veterinarioService.Login(vet.getCorreo(), vet.getPassword());
        if (vet == null) {
            return new ResponseEntity<String>("Veterinario no encontrado",HttpStatus.BAD_REQUEST);
            
        }

        VeterinarioDTO veterinarioDTO = VeterinarioMapper.INSTANCE.convert(vet);
        if (vet.getPassword().equals(vet.getPassword())) {
            return new ResponseEntity<VeterinarioDTO>(veterinarioDTO, HttpStatus.OK);
            
        }else{
            return new ResponseEntity<VeterinarioDTO>(veterinarioDTO, HttpStatus.BAD_REQUEST);
        }
    }
}
