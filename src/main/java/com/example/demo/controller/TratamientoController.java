package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.service.TratamientoService;

@RestController
@RequestMapping("/tratamiento")
@CrossOrigin(origins = "http://localhost:4200")
public class TratamientoController {


    @Autowired
    TratamientoService TratamientoService;


    //Cantidad de total tratamientos

    //cantidad de tratamientos por tipo de medicamento administrado en el ultimo mez
    

    //Cantidad de veterinarios activos 








    
}
