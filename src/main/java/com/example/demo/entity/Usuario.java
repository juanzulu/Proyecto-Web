package com.example.demo.entity;

import java.util.List;

public class Usuario {

    private Integer id;
    private String nombre;
    private String genero;
    private Integer edad;
    private Integer cedula; 
    private String correo;   
    private List<gato> mascotas;


    public Usuario (Integer id, String nombre, String genero, Integer edad, Integer cedula, String correo, List<gato> mascotas) {
        this.id = id;
        this.nombre = nombre;
        this.genero = genero;
        this.edad = edad;
        this.cedula = cedula;
        this.correo = correo;
        this.mascotas = mascotas;
    }

    public List<gato> getMascotas() {
        return mascotas;
    }

    public void setMascotas(List<gato> mascotas) {
        this.mascotas = mascotas;
    }

    public Integer getId() {
        return id;
    }


    public void setId(Integer id) {
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


    public String getCorreo() {
        return correo;
    }


    public void setCorreo(String correo) {
        this.correo = correo;
    }

    
}


