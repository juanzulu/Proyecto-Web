package com.example.demo.repository;

import java.util.List;
import java.util.Optional;

import org.assertj.core.api.Assertions; 
import org.junit.jupiter.api.Test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.Assert;

import java.io.IOException;
import java.io.InputStream;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;




import org.assertj.core.api.Assertions;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.demo.entity.Droga;
import com.example.demo.entity.Tratamiento;
import com.example.demo.entity.Usuario;
import com.example.demo.entity.Veterinario;
import com.example.demo.entity.gato;

@DataJpaTest
@RunWith(SpringRunner.class)

public class VeterinarioRepositoryTest {

    @Autowired
    private VeterinarioRepository veterinarioRepository;

    @Autowired
    private DrogaRepository drogaRepository;

    @Autowired
    private TratamientoRepository tratamientoRepository;


    @BeforeEach
    void init() {
        veterinarioRepository.save(new Veterinario(123488000, "Javier", "Perez", "javi@example.com", "12345678", "foto.jpg", "cirujano", true));
        veterinarioRepository.save(new Veterinario(123499000, "Ana", "González", "ana@example.com", "12345678", "foto.jpg", "oftalmólogo", true));
        veterinarioRepository.save(new Veterinario(123410000, "María", "López", "maria@example.com", "12345678", "foto.jpg", "dermatólogo", true));
        veterinarioRepository.save(new Veterinario(123411000, "Pedro", "Rodríguez", "pedro@example.com", "12345678", "foto.jpg", "endocrinólogo", true));
        veterinarioRepository.save(new Veterinario(123412000, "Sofía", "Martínez", "sofia@example.com", "12345678", "foto.jpg", "neurólogo", true));
    }



    //crud 1 create
    @Test
    public void VeterinarioRepository_save_Veterinaro() {
        //1.arrange
        //2.act
        //3.assert

        //arrange
        Veterinario veterinario = new Veterinario(123456000, "Juan", "Perez", "juan@example.com", "12345678", "foto.jpg", "cirujano", true);
        
        //act
        Veterinario savedVeterinario = veterinarioRepository.save(veterinario);

        //assert
        Assertions.assertThat(savedVeterinario).isNotNull();

    }



    //2 read todos los veterinarios
    @Test
    public void VeterinarioRepository_findAll_NotEmptyList() {
        //1.arrange
        //2.act
        //3.assert

        //arrange
        Veterinario veterinario = new Veterinario(123456000, "Juan", "Perez", "juan@gmail.com", "12345678", "foto.jpg", "cirujano", true);
        Veterinario veterinario2 = new Veterinario(123456080, "Memo", "Dias", "memo@gmail.com", "12345678", "foto2.jpg", "cirujano", true);


        //act
        veterinarioRepository.save(veterinario);
        veterinarioRepository.save(veterinario2);
        List<Veterinario> veterinarios = veterinarioRepository.findAll();


        //assert
        Assertions.assertThat(veterinarios).isNotNull();
        Assertions.assertThat(veterinarios.size()).isEqualTo(7);
        Assertions.assertThat(veterinarios.size()).isGreaterThan(0);

    }


    //3 read veterinario por id
    @Test
    public void VeterinarioRepository_findById_FindWrongIndex() {
        //1.arrange
        //2.act
        //3.assert

        //arrange
        Long index =-11l;

        //act
        Veterinario veterinario = veterinarioRepository.findById(index).orElse(null);

        //assert
        Assertions.assertThat(veterinario).isNull();
    }


    //4 update
    @Test
    public void VeterinarioRepository_updateById_Veterinario() {
        //1.arrange
        Long index = 1l;

        //2.act
        Veterinario veterinario = veterinarioRepository.findById(index).get();
        veterinario.setNombre("GayelqueloLea");
        Veterinario update = veterinarioRepository.save(veterinario);


        //3.assert
        Assertions.assertThat(update).isNotNull();
        Assertions.assertThat(update.getNombre()).isEqualTo("GayelqueloLea");
    }


    //5 delete
    @Test
    public void VeterinarioRepository_deleteById_Veterinario() {
        //1.arrange
        Long index = 1l;

        //2.act
        veterinarioRepository.deleteById(index);

        //3.assert
        Assertions.assertThat(veterinarioRepository.findById(index)).isEmpty();
    
    }



    // 1 Test consultas nuestras:
    @Test
    public void VeterinarioRepository_ConsultarEstado() {
        //1.arrange
        //2.act
        //3.assert

        //arrange
        Long index = 1l;

        //act
        boolean estado = veterinarioRepository.ConsultarEstado(index);

        //assert
        Assertions.assertThat(estado).isTrue();
    }


    //2 Test consultar veterinarios activos:

    @Test
    public void VeterinarioRepository_consultarVeterinariosActivos() {
        //1.arrange
        //2.act
        //3.assert

        //act
        List<Veterinario> veterinarios = veterinarioRepository.consultarVeterinariosActivos();

        //assert
        Assertions.assertThat(veterinarios).isNotNull();
        Assertions.assertThat(veterinarios.size()).isEqualTo(5);
        Assertions.assertThat(veterinarios.size()).isGreaterThan(0);
    }


    //3 Test consultar veterinarios inactivos:
    @Test
    public void VeterinarioRepository_consultarVeterinariosInactivos() {
        //1.arrange
        //2.act
        //3.assert

        //act
        List<Veterinario> veterinarios = veterinarioRepository.consultarVeterinariosInactivos();

        //assert
        Assertions.assertThat(veterinarios).isNotNull();
        Assertions.assertThat(veterinarios.size()).isEqualTo(0);    
    }

    //4 Test contar veterinarios activos:
    @Test
    public void VeterinarioRepository_countVeterinariosActivos() {
        //1.arrange
        //2.act
        //3.assert

        //act
        long count = veterinarioRepository.countVeterinariosActivos();

        //assert
        Assertions.assertThat(count).isEqualTo(5);
    }


    //5 Test contar veterinarios inactivos:
    @Test
    public void VeterinarioRepository_countVeterinariosInactivos() {
        //1.arrange
        //2.act
        //3.assert

        //act
        long count = veterinarioRepository.countVeterinariosInactivos();

        //assert
        Assertions.assertThat(count).isEqualTo(0);
    }

    //6 Test findByCorreoAndContrasena:
    @Test
    public void VeterinarioRepository_findByCorreoAndContrasena() {
        //1.arrange
        //2.act
        //3.assert

        //arrange
        String correo = "a@a.com";
        String password = "12345";

        //act
        Optional<Veterinario> veterinario = veterinarioRepository.findByCorreoAndContrasena(correo, password);

        //assert
        Assertions.assertThat(veterinario).isNotNull();
    }
}
