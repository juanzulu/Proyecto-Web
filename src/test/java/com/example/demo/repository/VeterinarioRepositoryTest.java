package com.example.demo.repository;

import org.assertj.core.api.Assertions;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.demo.entity.Droga;
import com.example.demo.entity.Tratamiento;
import com.example.demo.entity.Usuario;
import com.example.demo.entity.Veterinario;

@DataJpaTest
@RunWith(SpringRunner.class)

public class VeterinarioRepositoryTest {

    @Autowired
    private VeterinarioRepository veterinarioRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private DrogaRepository drogaRepository;


    @BeforeEach
    public void setUp() {
        veterinarioRepository.save(new Veterinario(123488000, "Javier", "Perez", "javi@example.com", "12345678", "foto.jpg", "cirujano", true));
        veterinarioRepository.save(new Veterinario(123499000, "Ana", "González", "ana@example.com", "12345678", "foto.jpg", "oftalmólogo", true));
        veterinarioRepository.save(new Veterinario(123410000, "María", "López", "maria@example.com", "12345678", "foto.jpg", "dermatólogo", true));
        veterinarioRepository.save(new Veterinario(123411000, "Pedro", "Rodríguez", "pedro@example.com", "12345678", "foto.jpg", "endocrinólogo", true));
        veterinarioRepository.save(new Veterinario(123412000, "Sofía", "Martínez", "sofia@example.com", "12345678", "foto.jpg", "neurólogo", true));

        usuarioRepository.save(new Usuario((long) 123456000, "Juan", "masculino", 25, 12345678));


    }


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
        Assertions.assertThat(veterinarios.size()).isEqualTo(5);
        Assertions.assertThat(veterinarios.size()).isGreaterThan(0);

    }

    
}
