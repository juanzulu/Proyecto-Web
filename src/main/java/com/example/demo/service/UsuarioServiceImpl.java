package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Usuario;
import com.example.demo.repository.UsuarioRepository;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    @Autowired
    UsuarioRepository Repo;

    @Override
    public Usuario SearchNyId(Long id) {
        return Repo.findById(id).get();
    }

    @Override
    public List<Usuario> SearchAll() {
        return Repo.findAll();
    }

    @Override
    public Usuario update(Usuario usuario) {
        return Repo.save(usuario);
    }

    @Override
    public Usuario add(Usuario usuario) {
        return Repo.save(usuario);
    }

    @Override
    public void deleletebyid(Long id) {
        Repo.deleteById(id);
    }

    @Override
    public Usuario findUsuarioById(Long id) {
        return Repo.findById(id).get();
    }

    @Override
    public Usuario findByCedula(String cedula) {
        return Repo.findByCedula(cedula);
    }

}
