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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.DTOs.VeterinarioDTO;
import com.example.demo.DTOs.VeterinarioMapper;
import com.example.demo.entity.UserEntity;
import com.example.demo.entity.Usuario;
import com.example.demo.entity.Veterinario;
import com.example.demo.repository.UsuarioRepository;
import com.example.demo.repository.VeterinarioRepository;
import com.example.demo.security.CustomUserDetailService;
import com.example.demo.security.JWTGenerator;
import com.example.demo.service.UsuarioService;
import com.example.demo.service.VeterinarioService;

@RestController
@RequestMapping("/veterinario")
@CrossOrigin(origins = "http://localhost:4200")
public class VeterinarioController {

    @Autowired
    VeterinarioService veterinarioService;

    @Autowired
    UsuarioRepository userRepository;

    @Autowired
    VeterinarioRepository veterinarioRepository;

    @Autowired
    private CustomUserDetailService customUserDetailService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    JWTGenerator jwtGenerator;

    @GetMapping("/veterinario")
    public ResponseEntity<List<VeterinarioDTO>> SearchAll() {
        List<Veterinario> lista = veterinarioService.SearchAll();
        List<VeterinarioDTO> listaDTO = (List<VeterinarioDTO>) VeterinarioMapper.INSTANCE.convertlList(lista);
        ResponseEntity<List<VeterinarioDTO>> response = new ResponseEntity<>(listaDTO, HttpStatus.OK);
        return response;
    }

    @PostMapping("/agregar")
    public ResponseEntity agregarVeterinario(@RequestBody Veterinario veterinario) {

        /*
         * if (userRepository.existsById(veterinario.getId())) {
         * return new ResponseEntity<Veterinario>(veterinario, HttpStatus.BAD_REQUEST);
         * }
         * 
         * UserEntity user = customUserDetailService.VeterinarioToUser(veterinario);
         * veterinario.setUser(user);
         * Veterinario veterinario2 = veterinarioService.add(veterinario);
         * 
         * if (veterinario2 == null) {
         * return new ResponseEntity<Veterinario>(veterinario2, HttpStatus.BAD_REQUEST);
         * }
         * 
         * return new ResponseEntity<Veterinario>(veterinario2, HttpStatus.OK);
         */

        if (veterinarioRepository.existsByCorreo(veterinario.getCorreo())) {
            return new ResponseEntity<String>("veterinario ya existe", HttpStatus.BAD_REQUEST);
        }
        UserEntity userEntity = customUserDetailService.VeterinarioToUser(veterinario);
        veterinario.setUser(userEntity);
        Veterinario veterinarioDB = veterinarioService.add(veterinario);
        VeterinarioDTO newVeterinarioDTO = VeterinarioMapper.INSTANCE.convert(veterinarioDB);

        if (newVeterinarioDTO == null) {
            return new ResponseEntity<VeterinarioDTO>(newVeterinarioDTO, HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<VeterinarioDTO>(newVeterinarioDTO, HttpStatus.CREATED);
    }

    @GetMapping("/find/{id}")
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

        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(vet.getCorreo(), vet.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);

        String token = jwtGenerator.generateToken(authentication);

        return new ResponseEntity<String>(token, HttpStatus.OK);

    }

    // en este metodo tengo la duda, esto se puede ver en el video en el min 2:14:25
    @GetMapping("/details")
    public ResponseEntity<VeterinarioDTO> buscarVeterinario() {

         
       

        Veterinario veterinario = veterinarioService.Login(
            SecurityContextHolder.getContext().getAuthentication().getName());

        VeterinarioDTO veterinarioDTO = VeterinarioMapper.INSTANCE.convert(veterinario);

        if (veterinario == null) {
            return new ResponseEntity<VeterinarioDTO>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<VeterinarioDTO>(veterinarioDTO, HttpStatus.OK);
    }

}
