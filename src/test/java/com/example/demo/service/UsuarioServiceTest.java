package com.example.demo.service;

import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.entity.Usuario;

import com.example.demo.repository.UsuarioRepository;

@SpringBootTest
public class UsuarioServiceTest {

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private UsuarioRepository usuarioRepository;


    @Test
    public void UsuarioService_agregarUsuario_Usuario(){
        
        Usuario usuario = new Usuario("Carlos","Masculino", 23, 12345678, "j5Y9U@example.com");

        Usuario newUsuario = usuarioService.add(usuario);

        Assertions.assertThat(newUsuario).isNotNull();
    }

    @Test
    public void UsuarioService_findAll_NotEmptyList(){
        Usuario usuario = new Usuario("Carlos","Masculino", 23, 12345678, "j5Y9U@example.com");
        Usuario usuario2 = new Usuario("Marcela","Femenina", 23, 32345678, "j5Y49U@example.com");

        usuarioRepository.save(usuario);
        usuarioRepository.save(usuario2);

        List<Usuario> usuarios = usuarioService.SearchAll();

        Assertions.assertThat(usuarios).isNotNull();
        Assertions.assertThat(usuarios.size()).isEqualTo(52);
    }

    @Test
    public void UsuarioService_SearchNyId_NotNull(){

        Usuario usuario = new Usuario("Carlos","Masculino", 23, 12345678, "j5Y9U@example.com");

        Usuario savedgato = usuarioRepository.save(usuario);

        Usuario foundUsuario = usuarioService.SearchNyId(savedgato.getId());

        Assertions.assertThat(foundUsuario).isNotNull();
        Assertions.assertThat(foundUsuario.getId()).isEqualTo(foundUsuario.getId());
        
    }
    
}
