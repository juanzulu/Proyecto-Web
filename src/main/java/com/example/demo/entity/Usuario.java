package com.example.demo.entity;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
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

    public Usuario() {

    }

    public Usuario(String nombre, String genero, Integer edad, Integer cedula,
            String correo) {
        this.nombre = nombre;
        this.genero = genero;
        this.edad = edad;
        this.cedula = cedula;
    }

    public List<gato> getMascotas() {
        return mascotas;
    }

    public void setMascotas(List<gato> mascotas) {
        this.mascotas = mascotas;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public Integer getEdad() {
        return edad;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    public Integer getCedula() {
        return cedula;
    }

    public void setCedula(Integer cedula) {
        this.cedula = cedula;
    }
}
