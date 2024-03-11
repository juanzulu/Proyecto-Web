package com.example.demo.service;

import java.util.Collection;

import com.example.demo.entity.Veterinario;

public interface VeterinarioService {

    public Veterinario SearchById(Long id);

    public Collection<Veterinario> SearchAll();

    public void deleletebyid(Long id);

    public void update(Veterinario veterinario);

    public void add(Veterinario veterinario);
}
