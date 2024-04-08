package com.example.demo.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Tratamiento;
import com.example.demo.repository.TratamientoRepository;

@Service
public class TratamientoServiceImpl implements TratamientoService {

    @Autowired
    TratamientoRepository TratamientoRepository;

    @Override
    public Tratamiento SearchById(Long id) {
        return TratamientoRepository.findById(id).get();
    }

    @Override
    public Collection<Tratamiento> SearchAll() {
        return TratamientoRepository.findAll();
    }

    @Override
    public void deleletebyid(Long id) {
        TratamientoRepository.deleteById(id);
    }

    @Override
    public void update(Tratamiento Tratamiento) {
        TratamientoRepository.save(Tratamiento);
    }

    @Override
    public void add(Tratamiento Tratamiento) {
        TratamientoRepository.save(Tratamiento);
    }

}