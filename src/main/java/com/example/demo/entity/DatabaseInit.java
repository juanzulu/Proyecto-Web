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

                for (int i = 0; i < 90; i++) {
                        String nombre = "Gato" + i;
                        String raza = (i % 4 == 0) ? "Gato"
                                        : ((i % 4 == 1) ? "Persa" : ((i % 4 == 2) ? "Maine Coon" : "Russian Blue"));
                        int edad = (i % 4) + 2; // Edad varía de 2 a 5
                        String imagenUrl = (i % 4 == 0)
                                        ? "https://www.mirringo.com.co/Portals/mirringo/contenidos/razas/banner-interna-razas.jpg?ver="
                                        : ((i % 4 == 1) ? "https://www.zooplus.es/magazine/wp-content/uploads/2017/10/fotolia_103481419.jpg"
                                                        : ((i % 4 == 2)
                                                                        ? "https://www.zooplus.es/magazine/wp-content/uploads/2018/08/maine-coon-3.jpg"
                                                                        : "https://i.pinimg.com/originals/1f/2d/4f/1f2d4fa68799ba91ff4787cfe18aaee1.jpg"));

                        gatoRepository.save(new gato(nombre, raza, edad, imagenUrl));
                }

                usuarioRepository.save(new Usuario("Juan", "Masculino", 25, 123456789, "Juan@gmail.com"));
                usuarioRepository.save(new Usuario("Maria", "Femenino", 30, 987654321, "maria@gmail.com"));
                usuarioRepository.save(new Usuario("Pedro", "Masculino", 22, 654321987, "Pedro@gmail.com"));
                usuarioRepository.save(new Usuario("Ana", "Femenino", 28, 987123456, "Ana@gmail.com"));
                usuarioRepository.save(new Usuario("Carlos", "Masculino", 35, 456789123, "Carlos@gmail.com"));
                usuarioRepository.save(new Usuario("Laura", "Femenino", 26, 321654987, "Laura@gmail.com"));
                usuarioRepository.save(new Usuario("Miguel", "Masculino", 29, 789456123, "Miguel@gmail.com"));
                usuarioRepository.save(new Usuario("Isabel", "Femenino", 32, 456123789, "Isabel@gmail.com"));
                usuarioRepository.save(new Usuario("Ricardo", "Masculino", 31, 987321456, "Ricardo@gmail.com"));
                usuarioRepository.save(new Usuario("Elena", "Femenino", 27, 567890123, "Elena@gmail.com"));
                usuarioRepository.save(new Usuario("Luis", "Masculino", 33, 654987321, "Luis@gmail.com"));

                Usuario asociar = usuarioRepository.findById(1L).get();

                for (gato gato : gatoRepository.findAll()) {
                        gato.setUsuario(asociar);
                        gatoRepository.save(gato);
                }
        }

}
