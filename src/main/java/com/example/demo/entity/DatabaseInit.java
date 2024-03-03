package com.example.demo.entity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.repository.GatoRepository;
import com.example.demo.repository.UsuarioRepository;

@Controller
@Transactional
public class DatabaseInit implements ApplicationRunner {

        @Autowired
        GatoRepository gatoRepository;

        @Autowired
        UsuarioRepository usuarioRepository;

        @Override
        public void run(ApplicationArguments args) throws Exception {
                gatoRepository.save(new gato("Michi", "Gato", 2,
                                "https://www.mirringo.com.co/Portals/mirringo/contenidos/razas/banner-interna-razas.jpg?ver="));
                gatoRepository.save(new gato("Gato", "Persa", 3,
                                "https://www.zooplus.es/magazine/wp-content/uploads/2017/10/fotolia_103481419.jpg"));
                gatoRepository.save(new gato("Felis silvestris catus", "Maine Coon", 5,
                                "https://www.zooplus.es/magazine/wp-content/uploads/2018/08/maine-coon-3.jpg"));
                gatoRepository.save(new gato("Thomas", "Russian Blue", 83,
                                "https://i.pinimg.com/originals/1f/2d/4f/1f2d4fa68799ba91ff4787cfe18aaee1.jpg"));

                usuarioRepository.save(new Usuario("Juan", "Masculino", 25, 123456789, "Juan@gmail.com"));
                usuarioRepository.save(new Usuario("Maria", "Femenino", 30, 987654321, "maria@gmail.com"));

                Usuario asociar = usuarioRepository.findById(1L).get();

                for (gato gato : gatoRepository.findAll()) {
                        gato.setUsuario(asociar);
                        gatoRepository.save(gato);
                }
        }

}
