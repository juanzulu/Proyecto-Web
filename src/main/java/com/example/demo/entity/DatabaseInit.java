package com.example.demo.entity;

import java.io.InputStream;
import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.repository.GatoRepository;
import com.example.demo.repository.RoleRepository;
import com.example.demo.repository.TratamientoRepository;
import com.example.demo.repository.UserRepository;
import com.example.demo.repository.UsuarioRepository;
import com.example.demo.repository.VeterinarioRepository;

import java.io.IOException;

import com.example.demo.repository.AdminRepository;
import com.example.demo.repository.DrogaRepository;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

@Controller
@Transactional
public class DatabaseInit implements ApplicationRunner {

        @Autowired
        GatoRepository gatoRepository;

        @Autowired
        UsuarioRepository usuarioRepository;

        @Autowired
        DrogaRepository drogaRepository;

        @Autowired
        VeterinarioRepository veterinarioRepository;

        @Autowired
        TratamientoRepository tratamientoRepository;

        @Autowired
        PasswordEncoder passwordEncoder;

        @Autowired
        RoleRepository roleRepository;

        @Autowired
        UserRepository userRepository;

        @Autowired
        AdminRepository adminRepository;

        @Override
        public void run(ApplicationArguments args) throws Exception {

                roleRepository.save(new Role("ADMIN"));
                roleRepository.save(new Role("VETERINARIO"));
                roleRepository.save(new Role("USER"));

                Usuario usuarioSave;
                UserEntity userEntity;

                // generacion de usuarios
                // 1. Crear el objeto
                // 2. Guaradarlo en la tabla user
                // 3. Agrgar al objeto del paso 1 el id tenido en el paso 2
                // 4. Guardar el objeto en la tabla Usuario

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
                        String ced = cedula.toString();
                        String correo = nombre + i + "@gmail.com";
                        
                        usuarioSave = (new Usuario(nombre, genero, edad, ced, correo));
                        userEntity = saveUserDueno(usuarioSave);
                        usuarioSave.setUser(userEntity);
                        usuarioRepository.save(usuarioSave);
                }

                // -----------------------------------Usuarios---------------------------------------------------------------------//

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

                // ------------------------------------------ Drogas

                Droga droga = Droga.builder().nombre("Medicamento 1").uDisponibles(10).uVendidas(2).precio(500000)
                                .pCompra(200000).build();
                drogaRepository.save(droga);

                /* excel */
                try {
                        InputStream file = getClass().getClassLoader().getResourceAsStream("medicamentos.xlsx");

                        Workbook workbook = new XSSFWorkbook(file);
                        Sheet sheet = workbook.getSheet("MEDICAMENTOS BD FINAL");
                        for (int rowIndex = 1; rowIndex <= sheet.getLastRowNum(); rowIndex++) {
                                Row row = sheet.getRow(rowIndex);
                                if (row != null) {
                                        Droga drug = Droga.builder().nombre(row.getCell(0).getStringCellValue())
                                                        .uDisponibles((int) row.getCell(3).getNumericCellValue())
                                                        .uVendidas((int) row.getCell(4).getNumericCellValue())
                                                        .precio((int) row.getCell(1).getNumericCellValue())
                                                        .pCompra((int) row.getCell(2).getNumericCellValue()).build();

                                        drogaRepository.save(drug);
                                }
                        }

                        if (workbook != null) {
                                workbook.close();
                        }
                        file.close();
                } catch (IOException e) {
                        e.printStackTrace();
                }

                Admin admin = Admin.builder().username("Camilo").password("123").build();
                userEntity = saveAdmin(admin);
                admin.setUser(userEntity);
                adminRepository.save(admin);

                admin = Admin.builder().username("Juan").password("123").build();
                userEntity = saveAdmin(admin);
                admin.setUser(userEntity);
                adminRepository.save(admin);

                admin = Admin.builder().username("Michael").password("123").build();
                userEntity = saveAdmin(admin);
                admin.setUser(userEntity);
                adminRepository.save(admin);

                // Crear Veterinario con Builder
                Veterinario veterinario = Veterinario.builder().cedula(1001301315).nombre("Camilo")
                                .apellido("Hernandez").correo("hernandez@gmail.com").password("12345678")
                                .foto("https://th.bing.com/th/id/OIP.LIvhmx5YRN4hOFZ0ld98JgHaE8?rs=1&pid=ImgDetMain")
                                .especialidad("Medicina Interna Veterinaria").estado(true).build();
                userEntity = saveVeterinario(veterinario);
                veterinario.setUser(userEntity);
                veterinarioRepository.save(veterinario);

                veterinario = Veterinario.builder().cedula(1001301316).nombre("Juan ").apellido("Perez")
                                .correo("Perez@gmail.com").password("12345678")
                                .foto("https://petcosset.com/wp-content/uploads/2020/12/Depositphotos_320884710_L-e1660002279141-684x1024.jpg")
                                .especialidad("Oftalmología Veterinaria").estado(true).build();
                userEntity = saveVeterinario(veterinario);
                veterinario.setUser(userEntity);
                veterinarioRepository.save(veterinario);

                veterinario = Veterinario.builder().cedula(1001301317).nombre("Maria").apellido("Lopez")
                                .correo("Lopez@gmail.com").password("12345678")
                                .foto("https://www.elpais.com.co/files/article_main/uploads/2019/03/04/5c9b6b0b8f7e2.jpeg")
                                .especialidad("Nutrición Veterinaria").estado(false).build();
                userEntity = saveVeterinario(veterinario);
                veterinario.setUser(userEntity);
                veterinarioRepository.save(veterinario);

                veterinario = Veterinario.builder().cedula(1001301318).nombre("Luisa").apellido("Gonzalez")
                                .correo("Gonzalez@gmail.com").password("12345678")
                                .foto("").especialidad("Oncología Veterinaria").estado(true).build();
                userEntity = saveVeterinario(veterinario);
                veterinario.setUser(userEntity);
                veterinarioRepository.save(veterinario);

                veterinario = Veterinario.builder().cedula(1001301319).nombre("Carlos").apellido("Martinez")
                                .correo("Martinez@gmail.com").password("12345678")
                                .foto("").especialidad("Nutrición Veterinaria").estado(false).build();
                userEntity = saveVeterinario(veterinario);
                veterinario.setUser(userEntity);
                veterinarioRepository.save(veterinario);

                veterinario = Veterinario.builder().cedula(1001301320).nombre("Ana").apellido("Sanchez")
                                .correo("Sanchez@gmail.com").password("12345678")
                                .foto("").especialidad("Reproducción Veterinaria").estado(false).build();
                userEntity = saveVeterinario(veterinario);
                veterinario.setUser(userEntity);
                veterinarioRepository.save(veterinario);

                veterinario = Veterinario.builder().cedula(1001301321).nombre("Pedro").apellido("Ramirez")
                                .correo("Ramirez@gmail.com").password("12345678")
                                .foto("").especialidad("Cardiologia Veterinaria").estado(true).build();
                userEntity = saveVeterinario(veterinario);
                veterinario.setUser(userEntity);
                veterinarioRepository.save(veterinario);

                veterinario = Veterinario.builder().cedula(1001301322).nombre("Sofia").apellido("Hernandez")
                                .correo("Hernandez@gmail.com").password("12345678")
                                .foto("").especialidad("Cirugia Veterinaria").estado(true).build();
                userEntity = saveVeterinario(veterinario);
                veterinario.setUser(userEntity);
                veterinarioRepository.save(veterinario);

                veterinario = Veterinario.builder().cedula(1001301323).nombre("Jorge").apellido("Ramirez")
                                .correo("Ramirez@gmail.com").password("12345678")
                                .foto("").especialidad("Dermatologia Veterinaria").estado(true).build();
                userEntity = saveVeterinario(veterinario);
                veterinario.setUser(userEntity);
                veterinarioRepository.save(veterinario);

                veterinario = Veterinario.builder().cedula(1001301324).nombre("Lucia").apellido("Gonzalez")
                                .correo("Gonzalez@gmail.com").password("12345678")
                                .foto("").especialidad("Odontologia Veterinaria").estado(true).build();
                userEntity = saveVeterinario(veterinario);
                veterinario.setUser(userEntity);
                veterinarioRepository.save(veterinario);

                tratamientoRepository.save(new Tratamiento(LocalDate.now(), drogaRepository.findById(1L).get(),
                                veterinarioRepository.findById(1L).get(), gatoRepository.findById(1L).get()));
                tratamientoRepository.save(new Tratamiento(LocalDate.now(), drogaRepository.findById(2L).get(),
                                veterinarioRepository.findById(2L).get(), gatoRepository.findById(2L).get()));
                tratamientoRepository.save(new Tratamiento(LocalDate.now(), drogaRepository.findById(3L).get(),
                                veterinarioRepository.findById(3L).get(), gatoRepository.findById(3L).get()));
                tratamientoRepository.save(new Tratamiento(LocalDate.now(), drogaRepository.findById(4L).get(),
                                veterinarioRepository.findById(4L).get(), gatoRepository.findById(4L).get()));
                tratamientoRepository.save(new Tratamiento(LocalDate.now(), drogaRepository.findById(6L).get(),
                                veterinarioRepository.findById(5L).get(), gatoRepository.findById(5L).get()));
                tratamientoRepository.save(new Tratamiento(LocalDate.now(), drogaRepository.findById(6L).get(),
                                veterinarioRepository.findById(6L).get(), gatoRepository.findById(6L).get()));

        }

        // -------------------------------------Veterinario-------------------------------------------------//

        private UserEntity saveUserDueno(Usuario usuario) {
                UserEntity user = new UserEntity();
                user.setUsername((usuario.getNombre()));
                user.setPassword(passwordEncoder.encode("123"));
                Role roles = roleRepository.findByName("USER").get();
                user.setRoles(List.of(roles));
                return userRepository.save(user);
        }

        private UserEntity saveVeterinario(Veterinario veterinario) {
                UserEntity user = new UserEntity();
                user.setUsername(veterinario.getNombre());
                user.setPassword(passwordEncoder.encode(veterinario.getPassword()));
                Role roles = roleRepository.findByName("VETERINARIO").get();
                user.setRoles(List.of(roles));
                return userRepository.save(user);
        }

        private UserEntity saveAdmin(Admin admin) {
                UserEntity user = new UserEntity();
                user.setUsername(admin.getUsername());
                user.setPassword(passwordEncoder.encode("123"));
                Role roles = roleRepository.findByName("ADMIN").get();
                user.setRoles(List.of(roles));
                return userRepository.save(user);
        }
}
