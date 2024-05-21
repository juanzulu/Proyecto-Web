package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Admin;
import com.example.demo.entity.UserEntity;
import com.example.demo.entity.Usuario;
import com.example.demo.repository.AdminRepository;
import com.example.demo.security.CustomUserDetailService;
import com.example.demo.security.JWTGenerator;
import com.example.demo.service.AdminService;
import com.example.demo.service.UsuarioService;

import org.springframework.web.bind.annotation.PostMapping;
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
    AuthenticationManager authenticationManager;

    @Autowired
    CustomUserDetailService customUserDetailService;


    @PostMapping("/login")
    public ResponseEntity login(@RequestBody Admin admin) {
       
        Authentication authentication = authenticationManager.authenticate(
            new UsernamePasswordAuthenticationToken(admin.getUsername(),admin.getPassword())
        );
        SecurityContextHolder.getContext().setAuthentication(authentication);

        String token = jwtGenerator.generateToken(authentication);

        return new ResponseEntity<String>(token, HttpStatus.OK);
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
    
    
}
