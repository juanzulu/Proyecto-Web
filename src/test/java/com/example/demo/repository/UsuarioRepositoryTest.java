package com.example.demo.repository;

import org.junit.jupiter.api.BeforeEach;

import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.demo.entity.Usuario;
import com.example.demo.entity.Veterinario;
import com.example.demo.entity.gato;



@DataJpaTest
@RunWith(SpringRunner.class)
public class UsuarioRepositoryTest {
    
    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private VeterinarioRepository veterinarioRepository;

    @Autowired
    private GatoRepository gatoRepository;

    @BeforeEach
    public void setUp() {
        usuarioRepository.save(new Usuario((long) 123456000, "Juan", "masculino", 25, 12345678));
        usuarioRepository.save(new Usuario((long) 123488000, "Maria", "femenino", 30, 87654321));
        usuarioRepository.save(new Usuario((long) 123499000, "Pedro", "masculino", 40, 98765432));
        usuarioRepository.save(new Usuario((long) 123410000, "Laura", "femenino", 35, 13579246));
        usuarioRepository.save(new Usuario((long) 123411000, "Carlos", "masculino", 28, 24681357));


    }


    @Test
    public void UsuarioRepository_save_Cedula() {
        //1. Arrange
        //2. Act
        //3. Assert


        //arrange
        Usuario usuario = new Usuario((long) 123412000, "Sofia", "femenino", 33, 36925814);


        //act
        Usuario savedUsuario = usuarioRepository.save(usuario);

        //assert
        Assertions.assertThat(savedUsuario).isNotNull();
    }

    @Test
    public void UsuarioRepository_findAll_NotEmptyList() {
        //1.arrange
        //2.act
        //3.assert

        //arrange
        Usuario usuario = new Usuario((long) 123413000, "Juan", "masculino", 27, 15935746);
        Usuario usuario2 = new Usuario((long) 123414000, "Ana", "femenino", 29, 35795146);


        //act
        usuarioRepository.save(usuario);
        usuarioRepository.save(usuario2);
        List<Usuario> usuarios = usuarioRepository.findAll();


        //assert
        Assertions.assertThat(usuarios).isNotNull();
        Assertions.assertThat(usuarios.size()).isEqualTo(6);
        Assertions.assertThat(usuarios.size()).isGreaterThan(0);

    }

    
}
