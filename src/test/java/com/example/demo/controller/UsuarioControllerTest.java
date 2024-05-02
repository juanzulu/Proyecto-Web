package com.example.demo.controller;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.List;

import com.example.demo.controller.UsuarioController;
import com.example.demo.entity.Usuario;
import com.example.demo.repository.RunWith;
import com.example.demo.service.UsuarioService;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;


//Pruebas unitarias
//Pruebas de integración

@WebMvcTest(controllers = {UsuarioController.class})
@ActiveProfiles("test")
@RunWith(SpringRunner.class)
public class UsuarioControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UsuarioController usuarioController;

    @Autowired
    ObjectMapper objectMapper;

    @Test
    public void UsuarioController_agregarUsuario_Usuario() throws Exception {

     
        Usuario usuario = new Usuario("Carlos","Masculino", 23, 12345678, "j5Y9U@example.com");
    
        //when(UsuarioService.add(Mockito.any(Usuario.class))).thenReturn(usuario); // call add method on the instance
    
        ResultActions  response = mockMvc.perform(
            post("/agregar")
            .contentType("application/json")
            .content(objectMapper.writeValueAsString(usuario)));
        
        response.andExpect(status().isCreated())
        .andExpect(content().contentType("application/json"))
        .andExpect(jsonPath("$.nombre").value(usuario.getNombre()))
        .andExpect(jsonPath("$.genero").value(usuario.getGenero()))
        .andExpect(jsonPath("$.edad").value(usuario.getEdad()))
        .andExpect(jsonPath("$.cedula").value(usuario.getCedula()));

       
    }


    @Test
    public void UsuarioController_mostrarUsuarios_Usuario() throws Exception {
        

           /*  when(UsuarioService.SearchAll()).thenReturn(
                List.of(
                    new Usuario(
                        "Carlos",
                        "Masculino", 
                        23, 
                        12345678, 
                        "j5Y9U@example.com"
                    ),
                    new Usuario(
                        "pepe",
                        "Masculino", 
                        12, 
                        1234678, 
                        "j5Y9U@example.com"
                    )
                )
            );

            */

            ResultActions response = mockMvc.perform(get("/cliente/lista"));
            response.andExpect(status().isOk())
            .andExpect(content().contentType("application/json"))
            .andExpect(jsonPath("$.size").value(2));
    }



    @Test
    public void UsuarioController_mostrarGatosUsuario_Usuario() throws Exception {

        
    }

}

