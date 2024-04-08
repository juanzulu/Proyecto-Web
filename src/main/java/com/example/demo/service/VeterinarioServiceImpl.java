package com.example.demo.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Veterinario;
import com.example.demo.repository.VeterinarioRepository;

@Service
public class VeterinarioServiceImpl implements VeterinarioService {

    @Autowired
    VeterinarioRepository veterinarioRepo;

    @Override
    public Veterinario SearchById(Long id) {
        return veterinarioRepo.findById(id).get();
    }

    @Override
    public Collection<Veterinario> SearchAll() {
        return veterinarioRepo.findAll();
    }

    @Override
    public void deleletebyid(Long id) {
        veterinarioRepo.deleteById(id);
    }

    @Override
    public void update(Veterinario veterinario) {
        veterinarioRepo.save(veterinario);
    }

    @Override
    public void add(Veterinario veterinario) {
        veterinarioRepo.save(veterinario);
    }

}