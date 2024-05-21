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

import jakarta.persistence.OneToOne;
import jakarta.persistence.Transient;

@Entity
@Data
@NoArgsConstructor
public class Usuario {

    @OneToOne(cascade = CascadeType.ALL)
    @JsonIgnore
    private UserEntity user;

    private String nombre;
    private String genero;
    private Integer edad;
    private String cedula;
    private String correo;
    @Transient
    private String password;
    @Id
    @GeneratedValue
    private long id;

    @JsonIgnore
    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<gato> mascotas = new ArrayList<>();

    public Usuario(Long id, String nombre, String genero, Integer edad, String cedula,
            String correo, String password) {
        this.id = id;
        this.nombre = nombre;
        this.genero = genero;
        this.edad = edad;
        this.cedula = cedula;
        this.correo = correo;
        this.password = password;

        // this.mascotas = mascotas;
    }

    public Usuario(String nombre, String genero, Integer edad, String cedula,
            String correo, String password) {
        this.nombre = nombre;
        this.genero = genero;
        this.edad = edad;
        this.cedula = cedula;
        this.password = password;
    }

}
