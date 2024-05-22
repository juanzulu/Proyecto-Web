package com.example.demo.DTOs;

import java.util.List;

import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.example.demo.entity.Tratamiento;

@Mapper
public interface TratamientoMapper {
    TratamientoMapper INSTANCE = Mappers.getMapper(TratamientoMapper.class);

    TratamientoDTO convert(Tratamiento tratamiento);

    @IterableMapping(elementTargetType = TratamientoDTO.class)
    List<TratamientoDTO> convertlList(List<Tratamiento> tratamientos);
}
