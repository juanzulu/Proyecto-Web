package com.example.demo.service;

import java.util.List;

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
    public List<Veterinario> SearchAll() {
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

    @Override
    public boolean ConsultarEstado(Long id) {
        return veterinarioRepo.ConsultarEstado(id);

    }

    @Override
    public void cambiarEstado(Veterinario veterinario) {

        veterinario.setEstado(!(veterinario.getEstado()));
        veterinarioRepo.save(veterinario);
        
    }

    public List<Veterinario> consultarVeterinariosActivos() {
        return veterinarioRepo.consultarVeterinariosActivos();
    }

    public List<Veterinario> consultarVeterinariosInactivos() {
        return veterinarioRepo.consultarVeterinariosInactivos();
    }

    

   

}
