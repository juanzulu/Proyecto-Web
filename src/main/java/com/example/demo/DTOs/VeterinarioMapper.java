package com.example.demo.DTOs;

import java.util.List;

import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.example.demo.entity.Veterinario;

@Mapper
public interface VeterinarioMapper {
    VeterinarioMapper INSTANCE = Mappers.getMapper(VeterinarioMapper.class);

    VeterinarioDTO convert(Veterinario veterinario);

    @IterableMapping(elementTargetType = VeterinarioDTO.class)
    List<VeterinarioDTO> convertlList(List<Veterinario> veterinarios);

}
