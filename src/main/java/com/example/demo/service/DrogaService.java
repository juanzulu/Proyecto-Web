package com.example.demo.service;

import java.util.Collection;

import com.example.demo.entity.Droga;

public interface DrogaService {

    public Droga SearchById(Long id);

    public Collection<Droga> SearchAll();

    public void deleteById(Long id);

    public void update(Droga droga);

    public void add(Droga droga);

    public Long total_sell();
}
