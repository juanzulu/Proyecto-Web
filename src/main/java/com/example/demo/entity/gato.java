package com.example.demo.entity;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class gato {

    @Id
    @GeneratedValue
    private Long id;

    private String nombre;
    private String raza;
    private Integer edad;
    private String foto;
    private String enfermedad;
    private boolean estado;

    @ManyToOne
    private Usuario usuario;

    @JsonIgnore
    @OneToMany(mappedBy = "felino", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Tratamiento> tratamientos = new ArrayList<>();

    public gato(Long id, String nombre, String raza, Integer edad, String foto, String enfermedad, boolean estado) {
        this.id = id;
        this.nombre = nombre;
        this.raza = raza;
        this.edad = edad;
        this.foto = foto;
        this.enfermedad = enfermedad;
        this.estado = estado;
    }

    public gato(String nombre, String raza, Integer edad, String foto, String enfermedad, boolean estado) {
        this.nombre = nombre;
        this.raza = raza;
        this.edad = edad;
        this.foto = foto;
        this.enfermedad = enfermedad;
        this.estado = estado;

    }

    public gato(String string, String nombre2, int i, String string2, String foto2, boolean b, Usuario usuario2) {

    }

    public boolean getEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

}
