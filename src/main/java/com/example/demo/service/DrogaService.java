package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Droga;

public interface DrogaService {

    public Droga SearchById(Long id);

    public List<Droga> SearchAll();

    public void deleteById(Long id);

    public void update(Droga droga);

    public void add(Droga droga);

    public Long total_sell();

    public Long ganancia();

    public List<String> SearchByName();

    public Droga SearchByNombre(String nombre);

}
