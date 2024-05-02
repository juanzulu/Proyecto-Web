package com.example.demo.repository;

import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.demo.entity.gato;

@DataJpaTest
@RunWith(SpringRunner.class)


public class GatoRepositoryTest {

    @Autowired
    private GatoRepository gatoRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @BeforeEach
    public void setUp(){
        
    }
    @Test
    public void GatoRepository_save_gato(){
        //1. arrange
        //2. act
        //3. assert

        gato gato = new gato("Pepito", "Criollo", 2, "3wfwefwe", null, true);

        //act
       gato savedgato =  gatoRepository.save(gato);

       //arrange
       Assertions.assertThat(savedgato).isNotNull();

    }


    @Test 
    public void GatoRepository_MostrarGato_NotEmptyList(){
    //1. arrange
        //2. act
        //3. assert

        //arrange
        gato gato = new gato("Pepito", "Criollo", 2, "3wfwefwe", null, true);
        gato gato2 = new gato("Pepito", "Criollo", 2, "3wfwefwe", null, true);

        gatoRepository.save(gato);
        gatoRepository.save(gato2);

        List<gato> gatos = gatoRepository.findAll();
        
        //assert
        Assertions.assertThat(gatos).isNotNull();
        Assertions.assertThat(gatos.size()).isEqualTo(2);
        Assertions.assertThat(gatos.size()).isGreaterThan(0);
    }

   
}
