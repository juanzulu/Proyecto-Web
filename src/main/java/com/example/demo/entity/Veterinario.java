package com.example.demo.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Transient;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Data
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class Veterinario {

    @OneToOne(cascade = CascadeType.ALL)
    @JsonIgnore
    private UserEntity user;

    private Integer cedula;
    private String nombre;
    private String apellido;
    private String correo;
    private String foto;
    private String especialidad;
    private boolean estado;
    // el transient genera problema a la hora de correr, sirve para encriptar la
    // clave de veterinarios, si se elimina no genera error
    // para seguir con el video mientras miro como solucionar el error
    @Transient
    private String password;

    @Id
    @GeneratedValue
    private Long id;

    @JsonIgnore
    @OneToMany(mappedBy = "veterinario")
    private List<Tratamiento> tratamientos = new ArrayList<>();

    public Veterinario(Integer cedula, String nombre, String apellido, String correo, String password, String foto,
            String especialidad, boolean estado) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.apellido = apellido;
        this.correo = correo;
        this.password = password;
        this.foto = foto;
        this.especialidad = especialidad;
        this.estado = estado;
    }
}
