package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Admin;
import com.example.demo.entity.UserEntity;
import com.example.demo.entity.Veterinario;
import com.example.demo.repository.AdminRepository;
import com.example.demo.security.CustomUserDetailService;
import com.example.demo.security.JWTGenerator;
import com.example.demo.service.AdminService;
import com.example.demo.service.VeterinarioService;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/admin")
@CrossOrigin(origins = "http://localhost:4200")
public class AdminController {

    @Autowired
    AdminRepository adminRepository;

    @Autowired
    AdminService adminService;

    @Autowired
    JWTGenerator jwtGenerator;

    @Autowired
    VeterinarioService veterinarioService;

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    CustomUserDetailService customUserDetailService;

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody Admin admin) {

        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(admin.getUsername(), "123"));
        SecurityContextHolder.getContext().setAuthentication(authentication);

        String token = jwtGenerator.generateToken(authentication);

        return new ResponseEntity<String>(token, HttpStatus.OK);
    }

    @GetMapping("/veterinario/activos/count")
    public long countVeterinariosActivos() {
        return veterinarioService.countVeterinariosActivos();
    }

    // http://localhost:8090/admin/veterinario/inactivos/count
    @GetMapping("/veterinario/inactivos/count")
    public long countVeterinariosInactivos() {
        return veterinarioService.countVeterinariosInactivos();
    }

    @PostMapping("/agregar")
    public ResponseEntity agregarUsuario(@RequestBody Admin admin) {
        /*
         * Usuario newUsuario = UsuarioService.add(usuario);
         * if(newUsuario == null){
         * return new ResponseEntity<Usuario>(newUsuario, HttpStatus.BAD_REQUEST);
         * }
         * return new ResponseEntity<Usuario>(newUsuario, HttpStatus.CREATED);
         */
        if (adminRepository.existsByUsername(admin.getUsername())) {
            return new ResponseEntity<String>("admin ya existe", HttpStatus.BAD_REQUEST);
        }

        UserEntity userEntity = customUserDetailService.AdminToUser(admin);
        admin.setUser(userEntity);
        Admin newUsuario = adminService.add(admin);
        if (newUsuario == null) {
            return new ResponseEntity<Admin>(newUsuario, HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<Admin>(newUsuario, HttpStatus.CREATED);

    }

    @GetMapping("/details")
    public ResponseEntity<Admin> buscarAdmin() {
        Admin admin = adminService.SearchByUsername(
                SecurityContextHolder.getContext().getAuthentication().getName());
        if (admin == null) {
            return new ResponseEntity<Admin>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Admin>(admin, HttpStatus.OK);
    }

    @GetMapping("/findVet/{id}")
    public Veterinario SearchById(@PathVariable("id") Long id) {
        return veterinarioService.SearchById(id);
    }

    @PutMapping("/actualizar/veterinario")
    public void update(@RequestBody Veterinario veterinario) {
        veterinarioService.update(veterinario);
    }
}
