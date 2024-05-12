package com.example.demo.DTOs;

import java.time.LocalDate;

import com.example.demo.entity.Droga;
import com.example.demo.entity.gato;

import lombok.Data;

@Data
public class TratamientoDTO {
    
    private LocalDate fecha;
    private Droga droga;
    private VeterinarioDTO veterinario;
    private gato felino;
}
