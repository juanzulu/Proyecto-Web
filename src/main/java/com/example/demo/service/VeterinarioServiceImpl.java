package com.example.demo.service;

import java.util.List;
import java.util.Optional;

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
    public Veterinario add(Veterinario veterinario) {
       return veterinarioRepo.save(veterinario);
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

    @Override
    public List<Veterinario> consultarVeterinariosActivos() {
        return veterinarioRepo.consultarVeterinariosActivos();
    }

    @Override
    public List<Veterinario> consultarVeterinariosInactivos() {
        return veterinarioRepo.consultarVeterinariosInactivos();
    }

    @Override
    public long countVeterinariosActivos() {
        return veterinarioRepo.countVeterinariosActivos();
    }

    @Override
    public long countVeterinariosInactivos() {
        return veterinarioRepo.countVeterinariosInactivos();
    }

    @Override
    public Optional<Veterinario> Login(String correo, String password) {
        Optional<Veterinario> arrendatario = veterinarioRepo.findByCorreoAndContrasena(correo, password);
        return arrendatario;
    }

}
