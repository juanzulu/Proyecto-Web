package com.example.demo.entity;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
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

    //// ---------------------------------------------------------------------------------------------------------------------//////

    @Override
    public String toString() {
        return "Tratamiento [id=" + id + ", fecha=" + fecha + ", droga=" + droga + ", veterinario=" + veterinario
                + ", felino=" + felino + "]";
    }

 

    public Tratamiento(LocalDate fecha, Droga droga, Veterinario veterinario, gato felino) {
        this.fecha = fecha;
        this.droga = droga;
        this.veterinario = veterinario;
        this.felino = felino;
    }

    public Tratamiento(long id, LocalDate fecha, Droga droga, Veterinario veterinario, gato felino) {
        this.id = id;
        this.fecha = fecha;
        this.droga = droga;
        this.veterinario = veterinario;
        this.felino = felino;
    }



}
