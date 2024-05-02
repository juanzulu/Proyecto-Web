package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Droga;
import com.example.demo.repository.DrogaRepository;

@Service
public class DrogaServiceImpl implements DrogaService {

    @Autowired
    DrogaRepository DrogaRepo;

    @Override
    public Droga SearchById(Long id) {
        return DrogaRepo.findById(id).get();
    }

    @Override
    public List<Droga> SearchAll() {
        return DrogaRepo.findAll();
    }

    @Override
    public void deleteById(Long id) {
        DrogaRepo.deleteById(id);
    }

    @Override
    public void update(Droga droga) {
        DrogaRepo.save(droga);
    }

    @Override
    public void add(Droga droga) {
        DrogaRepo.save(droga);
    }

    @Override
    public Long total_sell() {
        return DrogaRepo.total_sell();
    }

    @Override
    public Long ganancia() {

        return DrogaRepo.ganancia();
    }

    @Override
    public List<String> SearchByName() {

        return DrogaRepo.SearchByName();
    }

    @Override
    public Droga SearchByNombre(String nombre) {
        return DrogaRepo.findByNombre(nombre);
    }

}
