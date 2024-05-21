package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.ui.Model;

import com.example.demo.entity.UserEntity;
import com.example.demo.entity.Usuario;
import com.example.demo.entity.gato;
import com.example.demo.repository.UserRepository;
import com.example.demo.repository.UsuarioRepository;
import com.example.demo.security.CustomUserDetailService;
import com.example.demo.security.JWTGenerator;
import com.example.demo.service.GatoService;
import com.example.demo.service.UsuarioService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;


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

    @Autowired
    UserRepository userRepository;

    @Autowired
    UsuarioRepository usuarioRepository;

    @Autowired
    CustomUserDetailService customUserDetailService;

    @Autowired
    AuthenticationManager authenticationManager;


    @Autowired
    JWTGenerator jwtGenerator;

    // http://localhost:8090/cliente/lista
    @GetMapping("/lista")
    public ResponseEntity<List<Usuario>> mostrarUsuarios(Model model) {

        List<Usuario> lista = UsuarioService.SearchAll();
        ResponseEntity<List<Usuario>> response = new ResponseEntity<>(lista, HttpStatus.OK);
        return response;
    }

    // http://localhost:8090/cliente/misgatos/{id}
    @GetMapping("/misgatos/{id}")
    public ResponseEntity<List<gato>> mostrarGatosUsuario(@PathVariable("id") Long identificacion) {

        List<gato> gatos = GatoController.SearchByUsuarioId(identificacion);
        ResponseEntity<List<gato>> response = new ResponseEntity<>(gatos, HttpStatus.OK);
        return response;

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
    public ResponseEntity agregarUsuario(@RequestBody Usuario usuario) {
        /*
         * Usuario newUsuario = UsuarioService.add(usuario);
         * if(newUsuario == null){
         * return new ResponseEntity<Usuario>(newUsuario, HttpStatus.BAD_REQUEST);
         * }
         * return new ResponseEntity<Usuario>(newUsuario, HttpStatus.CREATED);
         */
        if (usuarioRepository.existsByCedula(usuario.getCedula())) {
            return new ResponseEntity<String>("usuario ya existe", HttpStatus.BAD_REQUEST);
        }

        UserEntity userEntity = customUserDetailService.UsuarioToUser(usuario);
        usuario.setUser(userEntity);
        Usuario newUsuario = UsuarioService.add(usuario);
        if (newUsuario == null) {
            return new ResponseEntity<Usuario>(newUsuario, HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<Usuario>(newUsuario, HttpStatus.CREATED);

    }

    // http://localhost:8090/cliente/delete/{id}
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> borrarUsuario(@PathVariable("id") Long identificacion) {
        UsuarioService.deleletebyid(identificacion);
        return new ResponseEntity<String>("Usuario eliminado", HttpStatus.NO_CONTENT);

    }

    // http://localhost:8090/cliente/update/{id}
    @GetMapping("/update/{id}")
    public String mostrarUpdate(Model model, @PathVariable("id") Long identificacion) {

        Usuario usuario = UsuarioService.SearchNyId(identificacion);
        model.addAttribute("usuario", usuario);
        return "actualizar_usuario";
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Usuario> updateUsuario(@PathVariable Long id, @RequestBody Usuario usuario) {

        Usuario updatedUsuario = UsuarioService.update(usuario);
        if (updatedUsuario == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(updatedUsuario, HttpStatus.OK);
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

    @PostMapping("/login")
    public ResponseEntity loginUsuario(@RequestBody Usuario usuario) {

        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(usuario.getCedula(), "123"));
        SecurityContextHolder.getContext().setAuthentication(authentication);

        String token = jwtGenerator.generateToken(authentication);

        return new ResponseEntity<String>(token, HttpStatus.OK);
    }


    @GetMapping("details")
    public ResponseEntity<Usuario> buscarUsuario(){

        Usuario usuario = UsuarioService.findByCedula(
            (Integer) SecurityContextHolder.getContext().getAuthentication().getPrincipal()
        );

        if(usuario == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } 
        return new ResponseEntity<>(usuario, HttpStatus.OK);        
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
