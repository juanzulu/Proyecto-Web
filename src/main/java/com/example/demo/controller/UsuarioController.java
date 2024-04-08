package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;
import org.springframework.ui.Model;
import com.example.demo.entity.Usuario;
import com.example.demo.repository.UsuarioRepository;
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

    @GetMapping("/lista")
    public List<Usuario> mostrarUsuarios(Model model) {
       
        return UsuarioService.SearchAll();
    }

    @GetMapping("usuario/{id}")
    public Usuario mostrarInfo(@PathVariable("id") Long identificacion) {

        Usuario usuario = UsuarioService.SearchNyId(identificacion);
  
        return usuario;
    } 

    @GetMapping("/add")
    public String mostrarCrearUsuario(Model model) {

        Usuario usuario = new Usuario(null, null, null, null, null);

        model.addAttribute("usuario", usuario);

        return "crear_usuario";

    }

   
    @PostMapping("/agregar")
    public void agregarUsuario(@RequestBody  Usuario usuario) {
         UsuarioService.add(usuario);
    }

    @GetMapping("/delete/{id}")
    public String borrarUsuario(@PathVariable("id") Long identificacion) {

        UsuarioService.deleletebyid(identificacion);
        return "redirect:/cliente/lista";
    }

    @GetMapping("/update/{id}")
    public String mostrarUpdate(Model model, @PathVariable("id") Long identificacion) {

        Usuario usuario = UsuarioService.SearchNyId(identificacion);
        model.addAttribute("usuario", usuario);
        return "actualizar_usuario";
    }

    @PostMapping("/update/{id}")
    public String updateUsuario(@PathVariable("id") int identificacion, @ModelAttribute("usuario") Usuario usuario) {
        UsuarioService.update(usuario);
        return "redirect:/cliente/lista";
    }

}
