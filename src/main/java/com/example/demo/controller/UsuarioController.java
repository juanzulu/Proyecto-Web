package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;
import com.example.demo.entity.Usuario;
import com.example.demo.service.UsuarioService;


@Controller
@RequestMapping("/cliente")
public class UsuarioController {

    @Autowired
    UsuarioService UsuarioService;

    @GetMapping("/login")
    public String mostrarPaginaLogin() {
        return "login";
    }

    @GetMapping("/lista")
    public String mostrarUsuarios(Model model) {
        model.addAttribute("usuarios", UsuarioService.SearchAll());
        return "lista_usuarios";
    }

    @GetMapping("usuario/{id}")
    public String mostrarInfo(Model model, @PathVariable("id") int identificacion) {

        Usuario usuario = UsuarioService.SearchNyId(identificacion);

        if (usuario != null) {
            model.addAttribute("usuario", UsuarioService.SearchNyId(identificacion));
        } else {
            throw new NotFoundException(identificacion);
        }
        return "usuario";
    }

    @GetMapping("/add")
    public String mostrarCrearUsuario(Model model) {

        Usuario usuario = new Usuario(null, null, null, null, null, null);

        model.addAttribute("usuario", usuario);

        return "crear_usuario";

    }

    @PostMapping("/agregar")
    public String agregarUsuario(@ModelAttribute("usuario") Usuario usuario) {

        UsuarioService.add(usuario);
        return "redirect:/cliente/lista";
    }

    @GetMapping("/delete/{id}")
    public String borrarUsuario(@PathVariable("id") int identificacion) {

        UsuarioService.deleletebyid(identificacion);
        return "redirect:/cliente/lista";
    }

    @GetMapping("/update/{id}")
    public String mostrarUpdate(Model model, @PathVariable("id") int identificacion) {

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
