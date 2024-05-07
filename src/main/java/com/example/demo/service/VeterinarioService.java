package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import com.example.demo.entity.Veterinario;

public interface VeterinarioService {

    public Veterinario SearchById(Long id);

    public List<Veterinario> SearchAll();

    public void deleletebyid(Long id);

    public void update(Veterinario veterinario);

    public Veterinario add(Veterinario veterinario);

    public boolean ConsultarEstado(Long id);

    public void cambiarEstado(Veterinario veterinario);

    public List<Veterinario> consultarVeterinariosActivos();

    public List<Veterinario> consultarVeterinariosInactivos();

    public long countVeterinariosInactivos();

    public long countVeterinariosActivos();

    public Optional<Veterinario> Login(String correo, String password);
}
