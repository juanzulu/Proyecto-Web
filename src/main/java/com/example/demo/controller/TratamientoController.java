package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Tratamiento;
import com.example.demo.service.TratamientoService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
@RequestMapping("/tratamiento")
@CrossOrigin(origins = "http://localhost:4200")
public class TratamientoController {

    private static final Logger logger = LoggerFactory.getLogger(TratamientoController.class);

    @Autowired
    TratamientoService TratamientoService;

    @GetMapping("realizados")
    public ResponseEntity<Long> countTratamientosMes() {

        Long count = TratamientoService.countTratamientosMes();
        ResponseEntity<Long> response = new ResponseEntity<>(count, HttpStatus.OK);
        return response;
    }

    @GetMapping("por_droga")
    public ResponseEntity<List<Object[]>> countTratamientosPorDroga() {

        List<Object[]> lista = TratamientoService.countTratamientosPorDroga();
        ResponseEntity<List<Object[]>> response = new ResponseEntity<>(lista, HttpStatus.OK);
        return response;
    }

    @GetMapping("/veterinario/{id}")
    public List<Tratamiento> findTratamientosVeterinario(Model model, @PathVariable("id") Integer id) {
        return TratamientoService.findTratamientosVeterinario(id);
    }

    @GetMapping("/gato/{id}")
    public List<Tratamiento> findTratamientosGato(Model model, @PathVariable("id") Integer id) {
        return TratamientoService.findTratamientosGato(id);
    }

    // http://localhost:8090/tratamiento/informacion/veterinario/{id}
    @GetMapping("/informacion/veterinario/{id}")
    public List<Object[]> findTratamientosVeterinarioinformacion(Model model, @PathVariable("id") Integer id) {
        return TratamientoService.findTratamientosVeterinarioinformacion(id);

    }

    @GetMapping("/informacion/gato/{id}")
    public List<Object[]> findTratamientosGatoinformacion(Model model, @PathVariable("id") Integer id) {
        return TratamientoService.findTratamientosGatoinformacion(id);
    }

    @PostMapping("/agregar")
    public void agregarTratamiento(@RequestBody Tratamiento tratamiento) {
        logger.info("Request body received: {}", tratamiento);
        TratamientoService.save(tratamiento);
    }

}
