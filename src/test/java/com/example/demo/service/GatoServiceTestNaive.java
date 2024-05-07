package com.example.demo.service;


import java.util.List;
import java.util.Optional;

import org.assertj.core.api.Assertions;
import org.hibernate.annotations.TimeZoneStorage;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.entity.Tratamiento;
import com.example.demo.entity.gato;
import com.example.demo.repository.GatoRepository;

@SpringBootTest
public class GatoServiceTestNaive {

    @Autowired
    private GatoService GatoService;
    @Autowired
    private GatoRepository gatoRepository;


    @Test
    public void GatoService_createGato_Gato(){


        gato gato = new gato("pepe", "criollo", 2, "R#RFERG", "Tragon", false);
        gato gato2 = new gato("pepe2", "criollo", 2, "R#RFERG", "Tragon", false); 

        gato newgato = GatoService.add(gato);
        newgato = GatoService.add(gato2);


        Assertions.assertThat(newgato).isNotNull();
    }
    
    @Test
    public void GatoService_FindAll_NotEmptyList(){
        gato gato = new gato("pepe", "criollo", 2, "R#RFERG", "Tragon", false);
        gato gato2 = new gato("pepe2", "criollo", 2, "R#RFERG", "Tragon", false); 

        gatoRepository.save(gato);
        gatoRepository.save(gato2);

        List<gato> gatos = GatoService.SearchAll();

        Assertions.assertThat(gatos).isNotNull();
        Assertions.assertThat(gatos.size()).isEqualTo(102);
        
    }

    @Test
    public void GatoService_FindById_NotNull(){

        gato gato = new gato("pepe", "criollo", 2, "R#RFERG", "Tragon", false);
        gato savedgato = gatoRepository.save(gato);

        gato foundgato = GatoService.SearchById(savedgato.getId());

        Assertions.assertThat(foundgato).isNotNull();
        Assertions.assertThat(foundgato.getId()).isEqualTo(savedgato.getId());
    }

    @Test
    public void GatoService_DeleteGatoById() {

        gato gato = new gato("pepe", "criollo", 2, "R#RFERG", "Tragon", true);
        gato savedGato = gatoRepository.save(gato);

        GatoService.deleletebyid(savedGato.getId());
        Optional<gato> deletedGato = gatoRepository.findById(savedGato.getId());

        Assertions.assertThat(deletedGato).isEmpty();
    }

    @Test
    public void GatoService_UpdateGato() {
        gato gato = new gato("pepe", "criollo", 2, "R#RFERG", "Tragon", true);
        gato savedGato = gatoRepository.save(gato);

        savedGato.setNombre("pepe updated");
        GatoService.update(savedGato);

        gato updatedGato = gatoRepository.findById(savedGato.getId()).get();

        Assertions.assertThat(updatedGato.getNombre()).isEqualTo("pepe updated");
    }

    @Test
    public void GatoService_ToggleGatoState() {
        gato gato = new gato("pepe", "criollo", 2, "R#RFERG", "Tragon", true);
        gato savedGato = gatoRepository.save(gato);

        GatoService.cambiarEstado(savedGato);
        gato toggledGato = gatoRepository.findById(savedGato.getId()).get();

        Assertions.assertThat(toggledGato.getEstado()).isFalse();
    }



    
}