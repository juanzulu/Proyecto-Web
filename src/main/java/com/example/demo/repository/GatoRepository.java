package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.gato;

@Repository
public interface GatoRepository extends JpaRepository<gato, Long> {
    
        List<gato> findByUsuarioId(Long id);

        @Query(value = "SELECT estado FROM gato WHERE id = :id", nativeQuery = true)
        boolean ConsultarEstado(@Param("id")Long id); 
        
        @Query("SELECT COUNT(g) FROM gato g WHERE g.estado = true")
        long countGatosActivos();

        @Query("SELECT COUNT(g) FROM gato g")
        long countGatos();

        
}


