package com.example.demo.service;


import java.util.List;

import com.example.demo.entity.Veterinario;

public interface VeterinarioService {

    public Veterinario SearchById(Long id);

    public List<Veterinario> SearchAll();

    public void deleletebyid(Long id);

    public void update(Veterinario veterinario);

    public void add(Veterinario veterinario);
}
