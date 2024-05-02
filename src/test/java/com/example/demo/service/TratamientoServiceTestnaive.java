package com.example.demo.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.entity.Tratamiento;

@SpringBootApplication
public class TratamientoServiceTestnaive {

    @Autowired
    private TratamientoServiceTestnaive tratamientoService;

    @Test
    public void tratamientoService_createTratamiento_Tratamiento(){

        //arrange
        Tratamiento tratamiento = new Tratamiento();


        //act
        
        
    }
    
}
