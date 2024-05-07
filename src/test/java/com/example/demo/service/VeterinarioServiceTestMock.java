package com.example.demo.service;


import org.aspectj.lang.annotation.Before;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.example.demo.entity.Veterinario;
import com.example.demo.repository.GatoRepository;
import com.example.demo.repository.VeterinarioRepository;

import io.swagger.v3.oas.annotations.extensions.Extension;

import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.when;

import java.util.List;
import java.util.Optional;

import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ActiveProfiles;

//ejecutar una instancia completa

@ActiveProfiles("test")
@ExtendWith(MockitoExtension.class)
public class VeterinarioServiceTestMock {

    @Mock
    private GatoRepository gatoRepository;

    @InjectMocks
    private VeterinarioServiceImpl veterinarioService;

    @Mock
    VeterinarioRepository veterinarioRepository;

    @BeforeEach 
    public void init(){

    }

    
    //prueba 1
    @Test
    public void VeterinarioService_createVeterinario_Veterinario() {

        //Arrange 
        Veterinario veterinario = new Veterinario(123456000, "Juan", "Perez", "juan@gmail.com", "12345678", " fotos.jpg", "cirujano", true);

        when(veterinarioRepository.save(veterinario)).thenReturn(
            veterinario
        );

        //Act
        Veterinario newVeterinario = veterinarioService.add(veterinario);


        //Assert
        Assertions.assertThat(newVeterinario).isNotNull();
    }

    @Test
    public void VeterinarioService_SearchAll_Veterinario() {

        //Arrange 
        when(veterinarioRepository.findAll()).thenReturn(
            List.of(
                new Veterinario(123456000, "Juan", "Perez", "juan@gmail.com", "12345678", " fotos.jpg", "cirujano", true),
                new Veterinario(123456444, "Juan2", "Paez", "juan2p@gmail.com", "12345678", " fotos.jpg", "general", true)
            )
        );

        //Act
        List<Veterinario> veterinarios = veterinarioService.SearchAll();


        //assert
        Assertions.assertThat(veterinarios).isNotNull();
        Assertions.assertThat(veterinarios.size()).isEqualTo(2);

    }

    @Test
    public void testConsultarEstado() {
        // Arrange
        Long id = 1L;
        boolean expectedEstado = true;
        when(veterinarioRepository.ConsultarEstado(id)).thenReturn(expectedEstado);

        // Act
        boolean actualEstado = veterinarioService.ConsultarEstado(id);

        // Assert
        Assertions.assertThat(actualEstado).isEqualTo(expectedEstado);
    }



    @Test
    public void testSearchById() {
        // Arrange
        Long id = 1L;
        Veterinario expectedVeterinario = new Veterinario(1234456, "Juan", "Perez", "juan@gmail.com", "12345678", "foto.jpg", "cirujano", true);
        when(veterinarioRepository.findById(id)).thenReturn(Optional.of(expectedVeterinario));

        // Act
        Veterinario actualVeterinario = veterinarioService.SearchById(id);

        // Assert
        Assertions.assertThat(actualVeterinario).isEqualTo(expectedVeterinario);
    }

}