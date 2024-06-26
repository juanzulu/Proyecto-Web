package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.DTOs.TratamientoDTO;
import com.example.demo.DTOs.TratamientoMapper;
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
    public ResponseEntity<List<TratamientoDTO>> findTratamientosVeterinario(Model model,
            @PathVariable("id") Integer id) {
        List<Tratamiento> lista = TratamientoService.findTratamientosVeterinario(id);
        List<TratamientoDTO> listaDTO = (List<TratamientoDTO>) TratamientoMapper.INSTANCE.convertlList(lista);
        ResponseEntity<List<TratamientoDTO>> response = new ResponseEntity<>(listaDTO, HttpStatus.OK);
        return response;
    }

    @GetMapping("/gato/{id}")
    public ResponseEntity<List<TratamientoDTO>> findTratamientosGato(Model model, @PathVariable("id") Integer id) {

        List<Tratamiento> lista = TratamientoService.findTratamientosGato(id);
        List<TratamientoDTO> listaDTO = (List<TratamientoDTO>) TratamientoMapper.INSTANCE.convertlList(lista);
        ResponseEntity<List<TratamientoDTO>> response = new ResponseEntity<>(listaDTO, HttpStatus.OK);

        return response;
    }

    // http://localhost:8090/tratamiento/informacion/veterinario/{id}
    @GetMapping("/informacion/veterinario/{id}")
    public ResponseEntity<List<TratamientoDTO>> findTratamientosVeterinarioinformacion(Model model,
            @PathVariable("id") Integer id) {

        List<Tratamiento> lista = TratamientoService.findTratamientosVeterinarioinformacion(id);
        List<TratamientoDTO> listaDTO = TratamientoMapper.INSTANCE.convertlList(lista);
        return new ResponseEntity<>(listaDTO, HttpStatus.OK);
    }

    @GetMapping("/informacion/gato/{id}")
    public ResponseEntity<List<TratamientoDTO>> findTratamientosGatoinformacion(Model model,
            @PathVariable("id") Integer id) {

        List<Tratamiento> result = TratamientoService.findTratamientosGatoinformacion(id);
        List<TratamientoDTO> listaDTO = (List<TratamientoDTO>) TratamientoMapper.INSTANCE.convertlList(result);
        ResponseEntity<List<TratamientoDTO>> response = new ResponseEntity<>(listaDTO, HttpStatus.OK);
        return response;
    }

    @PostMapping("/agregar")
    public ResponseEntity<Tratamiento> agregarTratamiento(@RequestBody Tratamiento tratamiento) {
        Logger logger = LoggerFactory.getLogger(this.getClass()); // Asegúrate de tener un logger disponible.
        logger.info("Request body received: {}", tratamiento);
        TratamientoService.save(tratamiento);
        return ResponseEntity.ok(tratamiento);
        // Devuelve 201 Created para indicar que el recurso fue creado exitosamente.
    }

}
