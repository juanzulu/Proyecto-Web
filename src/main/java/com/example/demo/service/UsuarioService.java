package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Usuario;

public interface UsuarioService {

    public Usuario SearchNyId(Long id);

    public List<Usuario> SearchAll();

    public void deleletebyid(Long id);

    public Usuario update(Usuario usuario);

    public Usuario add(Usuario usuario);

    public Usuario findUsuarioById(Long id);

    public Usuario findByCedula(String cedula);

}
