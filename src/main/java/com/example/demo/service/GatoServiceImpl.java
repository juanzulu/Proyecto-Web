package com.example.demo.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.gato;
import com.example.demo.repository.GatoRepository;

@Service
public class GatoServiceImpl implements GatoService {

    @Autowired
    GatoRepository Repo;

    @Override
    public gato SearchNyId(Long id) {
        return Repo.findById(id).get();
    }

    @Override
    public Collection<gato> SearchAll() {
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

}
