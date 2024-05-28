package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.service.DrogaService;

import com.example.demo.entity.Droga;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/droga")
@CrossOrigin(origins = "http://localhost:4200")
public class DrogaController {

    @Autowired
    DrogaService drogaService;

    @GetMapping("/todas")
    public List<Droga> todaslasdrogas() {
        return drogaService.SearchAll();
    }

    @GetMapping("/nombre")
    public List<String> drogasporNombre() {
        return drogaService.SearchByName();
    }

    @GetMapping("/ventas_totales")
    public Long ventas_totales() {

        return drogaService.total_sell();
    }

    @GetMapping("/ganancias")
    public Long ganancia() {
        return drogaService.ganancia();
    }

    @GetMapping("/nombre/{nombre}")
    public ResponseEntity<Droga> drogaPorNombre(@PathVariable("nombre") String nombre) {
        Droga droga = drogaService.SearchByNombre(nombre);
        if (droga != null) {
            droga.setuDisponibles(droga.getuDisponibles() - 1);
            droga.setuVendidas(droga.getuVendidas() + 1);
            drogaService.update(droga);
            return ResponseEntity.ok(droga);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }

    }

    @PutMapping("actualizar/{id}")
    public void updateDroga(@RequestBody Droga droga) {
        drogaService.update(droga);
    }

}
