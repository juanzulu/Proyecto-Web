package com.example.demo.service;


import org.hibernate.annotations.TimeZoneStorage;
import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.entity.Tratamiento;
import com.example.demo.entity.gato;

@SpringBootTest
public class GatoServiceTestNaive {

    @Autowired
    private GatoService GatoService;


    @Test
    public void TratamientoService_createGato_Gato(){


        gato gato = new gato("pepe", "criollo", 2, "R#RFERG", "Tragon", false);
        gato gato2 = new gato("pepe2", "criollo", 2, "R#RFERG", "Tragon", false); 

        gato newgato = GatoService.add(gato);
        
        newgato = GatoService.add(gato2);


        Assertions.assertThat(newgato).isNotNull();
    }
    
}