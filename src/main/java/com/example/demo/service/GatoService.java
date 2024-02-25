package com.example.demo.service;

import java.util.Collection;

import com.example.demo.entity.gato;

public interface GatoService {

    public gato SearchNyId(int id);

    public Collection<gato> SearchAll();

}
