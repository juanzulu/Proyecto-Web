package com.example.demo.service;

import java.util.Collection;

import com.example.demo.entity.Usuario;

public interface UsuarioService {

    public Usuario SearchNyId(Long id);

    public Collection<Usuario> SearchAll();

    public void deleletebyid(Long id);

    public void update(Usuario usuario);

    public void add(Usuario usuario);

}
