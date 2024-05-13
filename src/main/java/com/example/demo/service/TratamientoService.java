package com.example.demo.service;

import java.util.Collection;

import java.util.List;

import com.example.demo.entity.Tratamiento;

public interface TratamientoService {

    public void save(Tratamiento Tratamiento);

    public Tratamiento SearchById(Long id);

    public Collection<Tratamiento> SearchAll();

    public void deleletebyid(Long id);

    public void update(Tratamiento Tratamiento);

    public void add(Tratamiento Tratamiento);

    public Long countTratamientosMes();

    public List<Object[]> countTratamientosPorDroga();

    public List<Tratamiento> findTratamientosVeterinario(Integer id);

    public List<Tratamiento> findTratamientosGato(Integer id);

    public List<Tratamiento> findTratamientosVeterinarioinformacion(Integer id);

    public List<Tratamiento> findTratamientosGatoinformacion(Integer id);

}
