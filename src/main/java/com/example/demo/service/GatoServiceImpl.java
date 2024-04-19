package com.example.demo.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.example.demo.entity.gato;
import com.example.demo.repository.GatoRepository;

@Service
public class GatoServiceImpl implements GatoService {

    @Autowired
    GatoRepository Repo;

    @Override
    public gato SearchById(Long id) {
        return Repo.findById(id).get();
    }

    @Override
    public List<gato> SearchAll() {
        return Repo.findAll();
    }

    @Override
    public void deleletebyid(Long id) {
        Repo.deleteById(id);
    }

    @Override
    public void update(gato felino) {
        Repo.save(felino);
    }

    @Override
    public void add(gato felino) {
        Repo.save(felino);
    }

    @Override
    public List<gato> SearchByUsuarioId(Long id) {
        return Repo.findByUsuarioId(id); // Llama al método corregido
    }

    @Override
    public boolean ConsultarEstado(Long id) {
        return Repo.ConsultarEstado(id);
    }

    @Override
    public void cambiarEstado( gato felino) {
        
        felino.setEstado(!(felino.getEstado()));
        Repo.save(felino);
    }

}
