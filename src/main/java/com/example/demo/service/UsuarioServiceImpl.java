package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Usuario;
import com.example.demo.repository.UsuarioRepository;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    @Autowired
    UsuarioRepository Base;
    @Override
    public Usuario SearchNyId(Long id) {
        return Base.findById(id).get();
    }

    @Override
    public List<Usuario> SearchAll() {
        return Base.findAll();
    }
    @Override
    public void update(Usuario usuario) {
        Base.save(usuario);
    }
    @Override
    public void add(Usuario usuario) {
        Base.save(usuario);
    }
    @Override
    public void deleletebyid(Long id) {
        Base.deleteById(id);
    }

}
