package com.example.demo.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Usuario;
import com.example.demo.repository.UsuarioRepository;




@Service
public class UsuarioServiceImpl implements UsuarioService{

    @Autowired
    UsuarioRepository Base;

    public Usuario SearchNyId(int id) {
        return Base.findbyid(id);
    }

    public Collection<Usuario> SearchAll() {
        return Base.findAll();
    }

    public void deleletebyid(int id) {
        Base.deleletebyid(id);
    }

    public void update(Usuario usuario) {
        Base.update(usuario);
    }

    public void add(Usuario usuario) {
        Base.add(usuario);
    }
    
}
