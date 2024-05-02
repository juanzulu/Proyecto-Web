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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.ui.Model;
import com.example.demo.entity.Usuario;
import com.example.demo.entity.gato;
import com.example.demo.repository.UsuarioRepository;
import com.example.demo.service.GatoService;
import com.example.demo.service.UsuarioService;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/cliente")
@CrossOrigin(origins = "http://localhost:4200")
public class UsuarioController {

    @Autowired
    UsuarioService UsuarioService;

    @Autowired
    UsuarioRepository RepoUsuario;

    @Autowired
    GatoService GatoController;

    // http://localhost:8090/cliente/lista
    @GetMapping("/lista")
    public List<Usuario> mostrarUsuarios() {
        return UsuarioService.SearchAll();
    }

    // http://localhost:8090/cliente/misgatos/{id}
    @GetMapping("/misgatos/{id}")
    public List<gato> mostrarGatosUsuario(@PathVariable("id") Long identificacion) {
        return GatoController.SearchByUsuarioId(identificacion);
    }

    @GetMapping("/usuario/{id}")
    public ResponseEntity<Usuario> mostrarUsuarioConGatos(@PathVariable("id") Long id) {
        Usuario usuario = UsuarioService.findUsuarioById(id); // Suponiendo que existe este método
        List<gato> gatos = GatoController.SearchByUsuarioId(id);
        usuario.setMascotas(gatos); // Asegúrate de que el usuario tenga un setter para mascotas
        return ResponseEntity.ok(usuario);
    }

    // http://localhost:8090/cliente/agregar
    @PostMapping("/agregar")
    public void agregarUsuario(@RequestBody Usuario usuario) {
        UsuarioService.add(usuario);
    }

    // http://localhost:8090/cliente/delete/{id}
    @DeleteMapping("/delete/{id}")
    public void borrarUsuario(@PathVariable("id") Long identificacion) {
        UsuarioService.deleletebyid(identificacion);

    }

    // http://localhost:8090/cliente/update/{id}
    @GetMapping("/update/{id}")
    public String mostrarUpdate(Model model, @PathVariable("id") Long identificacion) {

        Usuario usuario = UsuarioService.SearchNyId(identificacion);
        model.addAttribute("usuario", usuario);
        return "actualizar_usuario";
    }

    @PutMapping("/update/{id}")
    public void updateUsuario(@RequestBody Usuario usuario) {
        UsuarioService.update(usuario);

    }

    @PostMapping("/cedula")
    public ResponseEntity<Usuario> findByCedula(@RequestBody Integer cedula) {
        Usuario usuario = UsuarioService.findByCedula(cedula);
        if (usuario != null) {
            return ResponseEntity.ok(usuario);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    @GetMapping("/cedula/{cedula}")
    public ResponseEntity<Usuario> FindByCedula(@PathVariable("cedula") Integer cedula) {
        Usuario usuario = UsuarioService.findByCedula(cedula);
        if (usuario != null) {
            return ResponseEntity.ok(usuario);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

}
