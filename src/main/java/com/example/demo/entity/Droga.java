package com.example.demo.entity;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Droga {

    private String nombre;
    private Integer uDisponibles;
    private Integer uVendidas;
    private Integer precio;
    private Integer pCompra;

    @Id
    @GeneratedValue
    private Long id;

    @JsonIgnore
    @OneToMany(mappedBy = "droga")
    private List<Tratamiento> tratamientos = new ArrayList<>();

    public Droga() {

    }

    public Droga(String nombre, Integer uDisponibles, Integer uVendidas, Integer precio, Integer pCompra) {
        this.nombre = nombre;
        this.uDisponibles = uDisponibles;
        this.uVendidas = uVendidas;
        this.precio = precio;
        this.pCompra = pCompra;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getuDisponibles() {
        return uDisponibles;
    }

    public void setuDisponibles(Integer uDisponibles) {
        this.uDisponibles = uDisponibles;
    }

    public Integer getuVendidas() {
        return uVendidas;
    }

    public void setuVendidas(Integer uVendidas) {
        this.uVendidas = uVendidas;
    }

    public Integer getPrecio() {
        return precio;
    }

    public void setPrecio(Integer precio) {
        this.precio = precio;
    }

    public Integer getpCompra() {
        return pCompra;
    }

    public void setpCompra(Integer pCompra) {
        this.pCompra = pCompra;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Tratamiento> getTratamientos() {
        return tratamientos;
    }

    public void setTratamientos(List<Tratamiento> tratamientos) {
        this.tratamientos = tratamientos;
    }

}
