package com.example.demo.DTOs;

import lombok.Data;

@Data
public class VeterinarioDTO {
    private String nombre;
    private String apellido;
    private String correo;
    private String password;

}

//Veterinario -> VeterinarioDTO