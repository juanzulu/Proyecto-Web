package com.example.demo.DTOs;

import lombok.Data;

@Data
public class VeterinarioDTO {
    private Integer cedula;
    private String nombre;
    private String apellido;
    private String correo;
    private boolean estado;
}

//Veterinario -> VeterinarioDTO