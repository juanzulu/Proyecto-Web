package com.example.demo.controller;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import org.springframework.http.MediaType;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;

import com.example.demo.entity.Droga;
import com.example.demo.entity.Tratamiento;

import com.example.demo.entity.Veterinario;
import com.example.demo.entity.gato;
import com.example.demo.service.TratamientoService;

@WebMvcTest(TratamientoController.class)
@ActiveProfiles("test")
public class TratamientoControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private TratamientoService tratamientoService;



    @Test
    public void tratamientoController_countTratamientosMes_Tratamiento() throws Exception {
    
        Long expectedCount = 10L;
        when(tratamientoService.countTratamientosMes()).thenReturn(expectedCount);

 
        mockMvc.perform(get("/tratamiento/realizados")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().string(String.valueOf(expectedCount)));
    }

  @Test
    public void tratamientoController_countTratamientoPorDroga_Tratamiento() throws Exception {
     
        List<Object[]> mockData = Arrays.asList(new Object[]{"Droga1", 100}, new Object[]{"Droga2", 150});
        when(tratamientoService.countTratamientosPorDroga()).thenReturn(mockData);

     
        mockMvc.perform(get("/tratamiento/por_droga")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$[0][0]").value("Droga1"))
                .andExpect(jsonPath("$[0][1]").value(100))
                .andExpect(jsonPath("$[1][0]").value("Droga2"))
                .andExpect(jsonPath("$[1][1]").value(150));
    }

    @Test
    public void tratamientoController_findTratamientosVeterinario_Tratamiento() throws Exception {
        Droga droga = new Droga(); 
        Veterinario veterinario = new Veterinario();
        gato felino = new gato(); 

        List<Tratamiento> tratamientos = Arrays.asList(
            new Tratamiento(LocalDate.now(), droga, veterinario, felino),
            new Tratamiento(LocalDate.now().plusDays(1), droga, veterinario, felino)
        );

        when(tratamientoService.findTratamientosVeterinario(1)).thenReturn(tratamientos);

        mockMvc.perform(get("/tratamiento/veterinario/{id}", 1)
                .contentType(MediaType.APPLICATION_JSON))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON))
            .andExpect(jsonPath("$.size()").value(tratamientos.size()))
            .andExpect(jsonPath("$[0].fecha").exists())
            .andExpect(jsonPath("$[1].fecha").exists());
    }

    @Test
    public void findTratamientosGatoTest() throws Exception {
    Tratamiento t1 = new Tratamiento(); 
    Tratamiento t2 = new Tratamiento();
    List<Tratamiento> tratamientos = Arrays.asList(t1, t2);


    when(tratamientoService.findTratamientosGato(1)).thenReturn(tratamientos);

    mockMvc.perform(get("/tratamiento/gato/{id}", 1)
            .contentType(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk())
        .andExpect(content().contentType(MediaType.APPLICATION_JSON))
        .andExpect(jsonPath("$.size()").value(tratamientos.size()))
        .andExpect(jsonPath("$[0]").exists())  
        .andExpect(jsonPath("$[1]").exists());
}

@Test
public void findTratamientosVeterinarioinformacionTest() throws Exception {
    // Prepare sample data to return from the service
    Object[] tratamientoInfo1 = new Object[]{"Treatment Type A", "Description A", 5};
    Object[] tratamientoInfo2 = new Object[]{"Treatment Type B", "Description B", 3};
    //List<Tratamiento> mockData = Arrays.asList(tratamientoInfo1, tratamientoInfo2);

    // Mock the service method call
    //when(tratamientoService.findTratamientosVeterinarioinformacion(1)).thenReturn(mockData);

    // Perform the GET request and verify the results
    mockMvc.perform(get("/tratamiento/informacion/veterinario/{id}", 1)
            .contentType(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk())
        .andExpect(content().contentType(MediaType.APPLICATION_JSON))
        .andExpect(jsonPath("$.size()").value(2))
        .andExpect(jsonPath("$[0][0]").value("Treatment Type A"))
        .andExpect(jsonPath("$[0][1]").value("Description A"))
        .andExpect(jsonPath("$[0][2]").value(5))
        .andExpect(jsonPath("$[1][0]").value("Treatment Type B"))
        .andExpect(jsonPath("$[1][1]").value("Description B"))
        .andExpect(jsonPath("$[1][2]").value(3));
}



@Test
public void findTratamientosGatoinformacionTest() throws Exception {
 
    Object[] treatmentInfo1 = new Object[]{"Condition A", "Medication A", 10};
    Object[] treatmentInfo2 = new Object[]{"Condition B", "Medication B", 20};
    List<Object[]> mockData = Arrays.asList(treatmentInfo1, treatmentInfo2);


    //when(tratamientoService.findTratamientosGatoinformacion(1)).thenReturn(mockData);

  
    mockMvc.perform(get("/tratamiento/informacion/gato/{id}", 1)
            .contentType(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk())
        .andExpect(content().contentType(MediaType.APPLICATION_JSON))
        .andExpect(jsonPath("$.size()").value(2))
        .andExpect(jsonPath("$[0][0]").value("Condition A"))
        .andExpect(jsonPath("$[0][1]").value("Medication A"))
        .andExpect(jsonPath("$[0][2]").value(10))
        .andExpect(jsonPath("$[1][0]").value("Condition B"))
        .andExpect(jsonPath("$[1][1]").value("Medication B"))
        .andExpect(jsonPath("$[1][2]").value(20));
}

/*
 @Test
public void testAddGato() {
    // Setup
    Usuario usuario = new Usuario(); // Assuming you have a constructor or setters to initialize
    usuario.setId(1L); // Set necessary fields

    gato newGato = new gato("Simba", "Siamese", 3, "path/to/photo.jpg", "Healthy", true, usuario);

    // Assuming you have a service method to add a gato
    when(GatoService.add(any(gato.class))).thenReturn(newGato);

    gato returnedGato = GatoController.add(newGato);

    // Verify
    assertNotNull(returnedGato);
    assertEquals("Simba", returnedGato.getNombre());
    verify(GatoService).addGato(any(gato.class)); // verify that the service method was called
}
 */


    

}
