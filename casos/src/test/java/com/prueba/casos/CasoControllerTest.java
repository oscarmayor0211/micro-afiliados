package com.prueba.casos;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.prueba.casos.service.CasoService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.core.Is.is;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class CasoControllerTest extends AbstractTest{

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private CasoService casoService;

    @Test
    public void shouldListCasos() throws Exception {
        when(casoService.getAll()).thenReturn(getAnyCasosDto());

        mockMvc.perform(get("/api/v1/caso")
                        .content(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(jsonPath("$[0].idCaso", is(1)))
                .andExpect(jsonPath("$[1].idCaso", is(2)))
                .andExpect(status().isOk());
    }

    @Test
    public void shouldGetCasoById() throws Exception {
        when(casoService.findById(1)).thenReturn(getAnyCasoDto());

        mockMvc.perform(get("/api/v1/caso/1")
                        .content(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(jsonPath("$.idCaso", is(1)))
                .andExpect(jsonPath("$.numeroIdentificacionEmp", is("830123489")))
                .andExpect(jsonPath("$.fechaCreacion", is("2020-04-02 00:40:56.000")))
                .andExpect(status().isOk());
    }

    @Test
    public void shouldGetCasoByUsuarioCreacion() throws Exception {
        when(casoService.findCasosByUsuarioCreacion("POR11166")).thenReturn(getAnyCasosDto());

        mockMvc.perform(get("/api/v1/caso/filtrarUsuarioCreacion")
                        .content(MediaType.APPLICATION_JSON_VALUE)
                        .param("usuarioCreacion", "POR11166"))
                .andExpect(jsonPath("$[0].numeroIdentificacionEmp", is("830123489")))
                .andExpect(jsonPath("$[0].usuarioCreacion", is("POR11166")))
                .andExpect(jsonPath("$[0].idCaso", is(1)))
                .andExpect(status().isOk());
    }

    @Test
    public void shoulgGetCasosByGestorId() throws Exception{
        when(casoService.findCasosByGestorId("POR0010")).thenReturn(getAnyCasosDto());

        mockMvc.perform(get("/api/v1/caso/filtrarGestorId").
                        content(MediaType.APPLICATION_JSON_VALUE)
                        .param("gestorId", "POR0010"))
                .andExpect(jsonPath("$[0].gestorId", is("POR0010")))
                .andExpect(status().isOk());
    }

    @Test
    public void shouldGetCasosByFechaCreacion() throws Exception{
        when(casoService.filterCasosByFechaInicioCaso("2021-03-22 15:31:12.243", "2021-06-21 14:07:44.543"))
                .thenReturn(getAnyCasosDto());

        mockMvc.perform(get("/api/v1/caso/filtrarFechaInicioCaso")
                        .content(MediaType.APPLICATION_JSON_VALUE)
                        .param("fromDate", "2021-03-22 15:31:12.243")
                        .param("toDate","2021-06-21 14:07:44.543"))
                .andExpect(jsonPath("$[0].fechaInicioCaso", is("2021-04-22 09:28:57.127")))
                .andExpect(jsonPath("$[1].fechaInicioCaso", is("2021-06-21 13:07:44.543")))
                .andExpect(status().isOk());
    }

    @Test
    public void shouldSaveCaso() throws Exception {
        mockMvc.perform(post("/api/v1/caso")
                        .contentType("application/json")
                        .content(objectMapper.writeValueAsString(getAnyCasoDto())))
                .andExpect(status().isCreated());
    }

    @Test
    public void shouldUpdateCaso() throws Exception{
        mockMvc.perform(put("/api/v1/caso")
                        .contentType("application/json")
                        .content(objectMapper.writeValueAsString(getAnyCasoDto())))
                .andExpect(status().isOk());
    }

    @Test
    public void shouldDeleteCaso() throws Exception{
        mockMvc.perform(delete("/api/v1/caso/1")
                        .content(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(status().isOk());
    }
}
