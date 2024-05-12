package com.example.demo.entity;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Usuario {

    private String nombre;
    private String genero;
    private Integer edad;
    private Integer cedula;

    @JsonIgnore
    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<gato> mascotas = new ArrayList<>();

    @Id
    @GeneratedValue
    private long id;

    public Usuario(Long id, String nombre, String genero, Integer edad, Integer cedula) {
        this.id = id;
        this.nombre = nombre;
        this.genero = genero;
        this.edad = edad;
        this.cedula = cedula;
        // this.mascotas = mascotas;
    }



    public Usuario(String nombre, String genero, Integer edad, Integer cedula,
            String correo) {
        this.nombre = nombre;
        this.genero = genero;
        this.edad = edad;
        this.cedula = cedula;
    }


    public Long getId() {
        return id;
    }

}
