package com.prueba.afiliado;

import static org.hamcrest.core.Is.is;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.prueba.afiliado.service.AfiliadoServiceImpl;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class AfiliadoControllerTest extends FakeUserTest{
	
	 @Autowired
	    private MockMvc mockMvc;

	    @Autowired
	    private ObjectMapper objectMapper;

	    @MockBean
	    private AfiliadoServiceImpl afiliadoService;

	    @Test
	    public void shouldListAfiliados() throws Exception {
	        when(afiliadoService.getAll()).thenReturn(getAnyListAfiliadosDto());

	        mockMvc.perform(get("/api/v1/afiliado")
	                .content(MediaType.APPLICATION_JSON_VALUE))
	                .andExpect(jsonPath("$[0].numeroIdentificacion", is("1000185557")))
	                .andExpect(status().isOk());
	    }

	    @Test
	    public void shouldGetAfiliadoById() throws Exception {
	        when(afiliadoService.findById(1)).thenReturn(getAnyAfiliadoDto());

	        mockMvc.perform(get("/api/v1/afiliado/1")
	                .content(MediaType.APPLICATION_JSON_VALUE))
	                .andExpect(jsonPath("$.numeroIdentificacion", is("1116266430")))
	                .andExpect(jsonPath("$.fechaCreacion", is("2021-03-20 16:00:00.000")))
	                .andExpect(jsonPath("$.afiliadoId", is(1)))
	                .andExpect(status().isOk());
	    }

	    @Test
	    public void shouldGetAfiliadoByIdentificacion() throws Exception {
	        when(afiliadoService.findByNumeroIdentificacion("1116266430")).thenReturn(getAnyAfiliadoDto());

	        mockMvc.perform(get("/api/v1/afiliado/filtrarIdentificacion")
	                .content(MediaType.APPLICATION_JSON_VALUE)
	                .param("numeroIdentificacion", "1116266430"))
	                .andExpect(jsonPath("$.numeroIdentificacion", is("1116266430")))
	                .andExpect(jsonPath("$.fechaCreacion", is("2021-03-20 16:00:00.000")))
	                .andExpect(jsonPath("$.afiliadoId", is(1)))
	                .andExpect(status().isOk());
	    }

	    @Test
	    public void shoulgGetAfiliadosByUsuarioCreacion() throws Exception{
	        when(afiliadoService.findByUsuarioCreacion("DESPINOG")).thenReturn(getAnyListAfiliadosDto());

	        mockMvc.perform(get("/api/v1/afiliado/filtrarUsuarioCreacion").
	                content(MediaType.APPLICATION_JSON_VALUE)
	                .param("usuarioCreacion", "DESPINOG"))
	                .andExpect(jsonPath("$[0].usuarioCreacion", is("DESPINOG")))
	                .andExpect(status().isOk());
	    }

	    @Test
	    public void shouldGetAfiliadosByFechaCreacion() throws Exception{
	        when(afiliadoService.filterByFechaCreacion("2021-03-20 16:00:00.000", "2022-02-20 16:00:00.000"))
	                .thenReturn(getAnyListAfiliadosDto());

	        mockMvc.perform(get("/api/v1/afiliado/filtrarFechaCreacion")
	                .content(MediaType.APPLICATION_JSON_VALUE)
	                .param("fromDate", "2021-03-20 16:00:00.000")
	                .param("toDate","2022-02-20 16:00:00.000"))
	                .andExpect(jsonPath("$[0].fechaCreacion", is("2021-03-20 16:00:00.000")))
	                .andExpect(jsonPath("$[1].fechaCreacion", is("2022-02-20 16:00:00.000")))
	                .andExpect(status().isOk());
	    }

	    @Test
	    public void shouldSaveAfiliado() throws Exception {
	        mockMvc.perform(post("/api/v1/afiliado")
	                        .contentType("application/json")
	                        .content(objectMapper.writeValueAsString(getAnyAfiliadoDto())))
	                .andExpect(status().isCreated());
	    }

	    @Test
	    public void shouldUpdateAfiliado() throws Exception{
	        mockMvc.perform(put("/api/v1/afiliado")
	                        .contentType("application/json")
	                        .content(objectMapper.writeValueAsString(getAnyAfiliadoDto())))
	                .andExpect(status().isOk());
	    }

	    @Test
	    public void shouldDeleteAfiliado() throws Exception{
	        mockMvc.perform(delete("/api/v1/afiliado/1")
	                .content(MediaType.APPLICATION_JSON_VALUE))
	                .andExpect(status().isOk());

	    }
	}