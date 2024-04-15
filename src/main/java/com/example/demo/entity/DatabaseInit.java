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

                // -----------------------------------Gatos---------------------------------------------------------------------//

                String[] nombres = {
                                "Whiskers", "Luna", "Oliver", "Bella", "Simba", "Chloe", "Shadow", "Tiger", "Misty",
                                "Milo",
                                "Cleo", "Leo", "Nala", "Max", "Daisy", "Charlie", "Mochi", "Oreo", "Gizmo", "Sassy",
                                "Smokey", "Coco", "Lucy", "Rocky", "Mittens", "Spike", "Ziggy", "Mia", "Felix",
                                "Tinkerbell",
                                "Boots", "Lily", "Muffin", "Finn", "Whiskey", "Cinnamon", "Cupcake", "Ginger", "Kitty",
                                "Olive",
                                "Snickers", "Mango", "Pepper", "Pumpkin", "Twix", "Jasmine", "Apollo", "Lulu",
                                "Marbles", "Waffles",
                                "Zorro", "Mochaccino", "Peaches", "Snickerdoodle", "Butterscotch", "Zigzag", "Waldo",
                                "Whisper", "Tango", "Snuggles",
                                "Pebbles", "Snuffy", "Fluffy", "Rusty", "Jellybean", "Hazel", "Bubbles", "Pippin",
                                "Marshmallow", "Honey",
                                "Sapphire", "Twinkle", "Thunder", "Caramel", "Midnight", "Dusty", "Blaze", "Pippin",
                                "Lola", "Oscar",
                                "Ruby", "Boomer", "Shadowfax", "Sparkle", "Stormy", "Truffle", "Whisper", "Ziggy",
                                "Zuzu", "Olivia"

                };

                String[] razas = {
                                "Siamés", "Bengalí", "Ragdoll", "Abyssinian", "Persa", "Maine Coon", "Scottish Fold",
                                "Sphynx", "Russian Blue", "Norwegian Forest",
                                "Munchkin", "Savannah", "Burmese", "Birman", "Manx", "Cornish Rex", "British Shorthair",
                                "Turkish Angora", "Oriental", "Bombay",
                                "Siamese", "Balinese", "Chartreux", "Devon Rex", "Exotic Shorthair", "Himalayan",
                                "Japanese Bobtail", "Korat", "Nebelung", "Ocicat",
                                "Pixiebob", "Scottish Straight", "Tonkinese", "Turkish Van", "American Bobtail",
                                "American Curl", "American Shorthair", "American Wirehair", "Asian", "Australian Mist",
                                "Colorpoint Shorthair", "European Shorthair", "Havana Brown", "LaPerm", "Napoleon",
                                "Ojos Azules", "RagaMuffin", "RagaMyk", "Selkirk Rex", "Serengeti",
                                "Singapura", "Snowshoe", "Somali", "Toyger", "Ukrainian Levkoy", "Wila Krungthep",
                                "Yavanna", "York Chocolate", "Yoruba", "Zebu"

                };

                String[] enfermedades = {
                                "Rinotraqueítis viral felina", "Panleucopenia felina", "Calicivirus felino",
                                "Leucemia felina",
                                "Inmunodeficiencia felina", "Peritonitis infecciosa felina", "Toxoplasmosis",
                                "Gingivoestomatitis crónica felina", "Asma felina", "Insuficiencia renal crónica"
                };

                // URL de imágenes
                String[] urls = {
                                "https://www.zooplus.es/magazine/wp-content/uploads/2017/10/fotolia_103481419.jpg",
                                "https://www.zooplus.es/magazine/wp-content/uploads/2018/08/maine-coon-3.jpg",
                                "https://i.pinimg.com/originals/1f/2d/4f/1f2d4fa68799ba91ff4787cfe18aaee1.jpg",
                                "https://s1.ppllstatics.com/lasprovincias/www/multimedia/202112/12/media/cortadas/gatos-kb2-U160232243326NVC-1248x770@Las%20Provincias.jpg",
                                "https://estaticos-cdn.prensaiberica.es/clip/4e1211c1-1520-41a7-aabb-42c2e03d1731_alta-libre-aspect-ratio_default_0.jpg",
                                "https://static.nationalgeographic.es/files/styles/image_3200/public/nationalgeographic_1926777.jpg?w=1600&h=900",
                                "https://i.pinimg.com/originals/91/d8/9e/91d89ea00a3f2e9a3d326152da4a2548.jpg",
                                "https://th.bing.com/th/id/OIP.SpCktVxv_adtCFqHHd1rRQHaE8?rs=1&pid=ImgDetMain",
                                "https://th.bing.com/th?id=OIF.J%2bvE8TfjwU9cUZd90TObwQ&rs=1&pid=ImgDetMain",
                                "https://th.bing.com/th/id/OIP.D4eSVdrlVaOBZZvlu9iTAgHaJ7?w=889&h=1191&rs=1&pid=ImgDetMain"
                };

                // Insertar 100 gatos en el repositorio
                for (int i = 0; i < 100; i++) {
                        String nombre = nombres[i % nombres.length];
                        String raza = razas[i % razas.length];
                        int edad = (i % 4) + 2; // Edad varía de 2 a 5
                        String imagenUrl = urls[i % urls.length];
                        String enfermedad = enfermedades[i % enfermedades.length];
                        gatoRepository.save(new gato(nombre, raza, edad, imagenUrl, enfermedad, true));
                }

                // -----------------------------------Gatos------------------------------------------------------------------------//

                // -----------------------------------Usuarios---------------------------------------------------------------------//

                // Nombres de usuarios y correos electrónicos
                String[] nombresu = {
                                "Lucas", "Emma", "Liam", "Olivia", "Noah", "Ava", "Isabella", "Sophia", "Jackson",
                                "Mia",
                                "Aiden", "Elijah", "Grayson", "Amelia", "Caden", "Harper", "Carter", "Luna", "Mason",
                                "Evelyn",
                                "Oliver", "Aria", "Ethan", "Abigail", "Logan", "Emily", "Sebastian", "Scarlett",
                                "Manuel", "Chloe", "Chamo"

                };

                String[] generos = { "Masculino", "Femenino", };

                // Insertar 50 usuarios en el repositorio
                for (int i = 0; i < 50; i++) {
                        String nombre = nombresu[i % nombresu.length];
                        String genero = generos[i % generos.length];
                        Integer edad = (i % 40) + 18;
                        Integer cedula = 100000000 + i;
                        String correo = nombre + i + "@gmail.com";

                        usuarioRepository.save(new Usuario(nombre, genero, edad, cedula, correo));
                }

                // -----------------------------------Usuarios---------------------------------------------------------------------//

                // Usuario asociar;
                // gato felino, pantera, gatesco;

                // for (Long i = 0L; i < 90L; i += 3L) {

                // asociar = usuarioRepository.findById(i / 3L).get();

                // felino = gatoRepository.findById(i).get();
                // pantera = gatoRepository.findById(i + 1L).get();
                // gatesco = gatoRepository.findById(i + 2L).get();

                // felino.setUsuario(asociar);
                // pantera.setUsuario(asociar);
                // gatesco.setUsuario(asociar);

                // gatoRepository.save(gatesco);
                // gatoRepository.save(felino);
                // gatoRepository.save(pantera);
                // }

                Usuario asociar;
                gato pantera, gatesco;

                for (Long i = 1L; i <= 50L; i++) {
                        asociar = usuarioRepository.findById(i).orElse(null);

                        pantera = gatoRepository.findById(i * 2 - 1).orElse(null);
                        gatesco = gatoRepository.findById(i * 2).orElse(null);

                        if (asociar != null && pantera != null && gatesco != null) {
                                pantera.setUsuario(asociar);
                                gatesco.setUsuario(asociar);

                                gatoRepository.save(pantera);
                                gatoRepository.save(gatesco);
                        }
                }

        }

}
