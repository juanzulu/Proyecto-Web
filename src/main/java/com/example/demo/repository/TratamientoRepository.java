package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Tratamiento;

@Repository
public interface TratamientoRepository extends JpaRepository<Tratamiento, Long> {

    // Dashboard - 1: Cantidad de tratamientos realizados en la veterinaria en el
    // ultimo mes
    @Query(value = "SELECT COUNT(*) FROM tratamiento WHERE MONTH(fecha) = MONTH(CURRENT_DATE()) AND YEAR(fecha) = YEAR(CURRENT_DATE())", nativeQuery = true)
    Long countTratamientosMes();

    // Dashboard - 2: Cantidad de tratamientos por tipo de medicamento administrado
    // en el ultimo mes (tabla medicamento-cantidad)
    @Query(value = "SELECT d.nombre, COUNT(*) FROM tratamiento t INNER JOIN droga d ON t.droga_id = d.id WHERE MONTH(t.fecha) = MONTH(CURRENT_DATE()) AND YEAR(t.fecha) = YEAR(CURRENT_DATE()) GROUP BY d.nombre", nativeQuery = true)
    List<Object[]> countTratamientosPorDroga();

    @Query("SELECT t FROM Tratamiento t WHERE t.veterinario.id = :id")
    List<Tratamiento> findTratamientosVeterinario(@Param("id") Integer id);

    @Query("SELECT t FROM Tratamiento t WHERE t.felino.id = :id")
    List<Tratamiento> findTratamientosGato(@Param("id") Integer id);

    @Query("SELECT t, d.nombre, g.nombre FROM Tratamiento t JOIN t.droga d JOIN t.felino g WHERE t.veterinario.id = :id")
List<Object[]> findTratamientosVeterinarioInformacion(@Param("id") Integer id);

@Query("SELECT t.fecha, d.nombre FROM Tratamiento t JOIN t.droga d WHERE t.felino.id = :id")
List<Object[]> findTratamientosGatoInformacion(@Param("id") Integer id);
}
