package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.entity.Droga;

public interface DrogaRepository extends JpaRepository<Droga, Long> {


    @Query("SELECT SUM(d.uVendidas * d.precio) FROM Droga d")
    Long total_sell();

         @Query("SELECT SUM(d.uVendidas * (d.precio - d.pCompra)) FROM Droga d")
        Long ganancia();
}
