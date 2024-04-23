package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.service.DrogaService;

@RestController
@RequestMapping("/droga")
@CrossOrigin(origins = "http://localhost:4200")
public class DrogaController {
    

    @Autowired
    DrogaService drogaService;

    @GetMapping("/ventas_totales")
    public Long ventas_totales() {

        return drogaService.total_sell();
    }

    @GetMapping("/ganancias")
    public Long ganancia() {
        
        return drogaService.ganancia();
    }
}
