package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.gato;

public interface GatoService {

    public gato SearchById(Long id);

    public List<gato> SearchAll();

    public List<gato> SearchByUsuarioId(Long id);

    public void deleletebyid(Long id);

    public void update(gato felino);

    public void add(gato felino);

    public boolean ConsultarEstado(Long id);

    public void cambiarEstado( gato felino);

    public Long countGatosActivos();


}
