package com.example.demo.entity;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Tratamiento {

    @Id
    @GeneratedValue
    private long id;

    private LocalDate fecha;

    @ManyToOne
    private Droga droga;

    @ManyToOne
    private Veterinario veterinario;

    @ManyToOne
    private gato felino;

    public Tratamiento() {

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public Droga getDroga() {
        return droga;
    }

    public void setDroga(Droga droga) {
        this.droga = droga;
    }

    public Veterinario getVeterinario() {
        return veterinario;
    }

    public void setVeterinario(Veterinario veterinario) {
        this.veterinario = veterinario;
    }

    public gato getFelino() {
        return felino;
    }

    public void setFelino(gato felino) {
        this.felino = felino;
    }

    public Tratamiento(LocalDate fecha, Droga droga, Veterinario veterinario, gato felino) {
        this.fecha = fecha;
        this.droga = droga;
        this.veterinario = veterinario;
        this.felino = felino;
    }

}
