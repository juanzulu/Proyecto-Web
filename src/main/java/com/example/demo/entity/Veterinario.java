package com.example.demo.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Data
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class Veterinario {

    
    @OneToOne(cascade = CascadeType.ALL)
    private UserEntity user;

    private Integer cedula;
    private String nombre;
    private String apellido;
    private String correo;
    private String password;
    private String foto;
    private String especialidad;
    private boolean estado;

    @Id
    @GeneratedValue
    private Long id;

    @JsonIgnore
    @OneToMany(mappedBy = "veterinario")
    private List<Tratamiento> tratamientos = new ArrayList<>();



    public Veterinario(Integer cedula, String nombre, String apellido, String correo, String password, String foto,
            String especialidad, boolean estado) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.apellido = apellido;
        this.correo = correo;
        this.password = password;
        this.foto = foto;
        this.especialidad = especialidad;
        this.estado = estado;
    }
}
