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
    public gato SearchNyId(int id) {
        return Repo.findbyid(id);
    }

    @Override
    public Collection<gato> SearchAll() {
        return Repo.findAll();
    }

}