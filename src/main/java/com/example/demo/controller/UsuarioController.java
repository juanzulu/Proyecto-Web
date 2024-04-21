package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;
import org.springframework.ui.Model;
import com.example.demo.entity.Usuario;
import com.example.demo.entity.gato;
import com.example.demo.repository.UsuarioRepository;
import com.example.demo.service.GatoService;
import com.example.demo.service.UsuarioService;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/cliente")
@CrossOrigin (origins =  "http://localhost:4200")
public class UsuarioController {

    @Autowired
    UsuarioService UsuarioService;

    @Autowired
    UsuarioRepository RepoUsuario;

    @Autowired
    GatoService GatoController;



    @GetMapping("/login")
    public List<Usuario> mostrarPaginaLogin() {
        return UsuarioService.SearchAll();
    }

    @PostMapping("/registro")
    public String login(Model model, @RequestParam String username) {

        Usuario usuario = RepoUsuario.findByCorreo(username);

        if (usuario != null) {
            model.addAttribute("usuario", usuario);
            Long id = usuario.getId();
            String urlDestino = UriComponentsBuilder
                    .fromPath("/cliente/usuario/{id}")
                    .buildAndExpand(id)
                    .toUriString();
    
            return "redirect:" + urlDestino;
        }else{
            return "redirect:/cliente/login";
        }
    }

      // http://localhost:8090/cliente/lista
    @GetMapping("/lista")
    public List<Usuario> mostrarUsuarios(Model model) {
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
   
    // http://localhost:8090/cliente/add
    @GetMapping("/add")
    public String mostrarCrearUsuario(Model model) {

        Usuario usuario = new Usuario(null, null, null, null, null);

        model.addAttribute("usuario", usuario);

        return "crear_usuario";

    }

    // http://localhost:8090/cliente/agregar
    @PostMapping("/agregar")
    public void agregarUsuario(@RequestBody  Usuario usuario) {
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
    public void updateUsuario(@RequestBody  Usuario usuario) {
        UsuarioService.update(usuario);
      
    }

}
