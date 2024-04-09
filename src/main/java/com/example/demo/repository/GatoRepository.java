package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.gato;

@Repository
public interface GatoRepository extends JpaRepository<gato, Long> {
    
        List<gato> findByUsuarioId(Long id);
}
