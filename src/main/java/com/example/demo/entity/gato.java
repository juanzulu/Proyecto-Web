package com.example.demo.entity;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class gato {

    private String nombre;
    private String raza;
    private Integer edad;
    private String foto;

    @Id
    @GeneratedValue
    private Long id;
    
    @JsonIgnore
    @ManyToOne
    private Usuario usuario;

   
    @OneToMany(mappedBy = "felino")
    private List<Tratamiento> tratamientos = new ArrayList<>();

    public gato(Long id, String nombre, String raza, Integer edad, String foto) {
        this.id = id;
        this.nombre = nombre;
        this.raza = raza;
        this.edad = edad;
        this.foto = foto;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public gato() {

    }

    public gato(String nombre, String raza, Integer edad, String foto) {
        this.nombre = nombre;
        this.raza = raza;
        this.edad = edad;
        this.foto = foto;
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

    public String getRaza() {
        return raza;
    }

    public void setRaza(String raza) {
        this.raza = raza;
    }

    public Integer getEdad() {
        return edad;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }
}
