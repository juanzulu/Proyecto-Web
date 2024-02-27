package com.example.demo.service;

import java.util.Collection;

import com.example.demo.entity.Usuario;

public interface UsuarioService {

    public Usuario SearchNyId(int id);

    public Collection<Usuario> SearchAll();

    public void deleletebyid(int id);

    public void update(Usuario usuario);

    public void add(Usuario usuario);
    
} 
