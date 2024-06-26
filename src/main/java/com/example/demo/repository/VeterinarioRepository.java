package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Veterinario;

@Repository
public interface VeterinarioRepository extends JpaRepository<Veterinario, Long> {

      List<Veterinario> findByCedula(Integer cedula);



      @Query(value = "SELECT estado FROM veterinario WHERE id = :id", nativeQuery = true)
      boolean ConsultarEstado(@Param("id") Long id);

      // Fetch all active veterinarians
      @Query("SELECT v FROM Veterinario v WHERE v.estado = true")
      List<Veterinario> consultarVeterinariosActivos();

      // Fetch all inactive veterinarians
      @Query("SELECT v FROM Veterinario v WHERE v.estado = false")
      List<Veterinario> consultarVeterinariosInactivos();

      @Query("SELECT COUNT(v) FROM Veterinario v WHERE v.estado = true")
      long countVeterinariosActivos();

      // Count inactive veterinarians
      @Query("SELECT COUNT(v) FROM Veterinario v WHERE v.estado = false")
      long countVeterinariosInactivos();

      @Query("SELECT a FROM Veterinario a WHERE a.correo = :correo")
      Veterinario findByCorreoAndContrasena(@Param("correo") String correo);

      boolean existsByCorreo(String correo);

      
      Veterinario findByCorreo( String correo);


}