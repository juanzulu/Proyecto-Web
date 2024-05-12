package com.example.demo.entity;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@Builder
@AllArgsConstructor
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

 

    public Droga(String nombre, Integer uDisponibles, Integer uVendidas, Integer precio, Integer pCompra) {
        this.nombre = nombre;
        this.uDisponibles = uDisponibles;
        this.uVendidas = uVendidas;
        this.precio = precio;
        this.pCompra = pCompra;
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


}
