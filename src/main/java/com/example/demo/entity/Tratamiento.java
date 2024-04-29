package com.example.demo.entity;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

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
    @JsonIgnore
    private Droga droga;

    @ManyToOne
    @JsonIgnore
    private Veterinario veterinario;

    @ManyToOne
    @JsonIgnore
    private gato felino;

    @JsonProperty("idDroga")
    public Long getDrogaId() {
        return droga != null ? droga.getId() : null;
    }

    @JsonProperty("idVeterinario")
    public Long getVeterinarioId() {
        return veterinario != null ? veterinario.getId() : null;
    }

    @JsonProperty("idGato")
    public Long getGatoId() {
        return felino != null ? felino.getId() : null;
    }

    //// ---------------------------------------------------------------------------------------------------------------------//////

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
