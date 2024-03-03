package com.example.demo.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Usuario;
import com.example.demo.repository.UsuarioRepository;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    @Autowired
    UsuarioRepository Base;

    public Usuario SearchNyId(Long id) {
        return Base.findById(id).get();
    }

    public Collection<Usuario> SearchAll() {
        return Base.findAll();
    }

    public void update(Usuario usuario) {
        Base.save(usuario);
    }

    public void add(Usuario usuario) {
        Base.save(usuario);
    }

    public void deleletebyid(Long id) {
        Base.deleteById(id);
    }

}
