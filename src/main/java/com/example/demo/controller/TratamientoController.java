package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.service.TratamientoService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/tratamiento")
@CrossOrigin(origins = "http://localhost:4200")
public class TratamientoController {


    @Autowired
    TratamientoService TratamientoService;



   


    @GetMapping("realizados")
    public Long countTratamientosMes() {

        return TratamientoService.countTratamientosMes();
    }


    @GetMapping("por_droga")
    public List<Object[]> countTratamientosPorDroga() {

        return TratamientoService.countTratamientosPorDroga();
    }





    //Cantidad de total tratamientos

    //cantidad de tratamientos por tipo de medicamento administrado en el ultimo mez
    

    //Cantidad de veterinarios activos 








    
}
