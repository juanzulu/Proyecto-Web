package com.example.demo.service;

import java.util.Collection;

import com.example.demo.entity.Tratamiento;

public interface TratamientoService {

    public Tratamiento SearchById(Long id);

    public Collection<Tratamiento> SearchAll();

    public void deleletebyid(Long id);

    public void update(Tratamiento Tratamiento);

    public void add(Tratamiento Tratamiento);

}
