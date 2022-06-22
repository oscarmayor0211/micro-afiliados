package com.prueba.afiliado;

import static org.junit.Assert.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.prueba.afiliado.dto.AfiliadoDto;
import com.prueba.afiliado.exception.ApiRequestException;
import com.prueba.afiliado.repository.AfiliadoRepository;
import com.prueba.afiliado.service.AfiliadoService;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import com.prueba.afiliado.model.Afiliado;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("test")
public class AfiliadoServiceImplTest extends FakeUserTest {
	  @Autowired
	    private AfiliadoService afiliadoService;

	    
	    @MockBean
	    private AfiliadoRepository afiliadoRepository;

	    private List<AfiliadoDto> afiliadosDto = new ArrayList<>();
	    private AfiliadoDto afiliadoDto = new AfiliadoDto();

	    @Test
	    public void shouldListAfiliados(){
	        when(afiliadoRepository.findAll()).thenReturn(getAnyListAfiliados());
	        afiliadosDto = afiliadoService.getAll();

	        assertTrue(afiliadosDto.size() >= 0);

	        verify(afiliadoRepository, times(1)).findAll();
	    }

	    @Test
	    public void shouldGetAfiliadoById(){
	        when(afiliadoRepository.findById(1)).thenReturn(java.util.Optional.of(getAnyAfiliado()));
	        afiliadoDto = afiliadoService.findById(1);

	        assertEquals("1000185557", afiliadoDto.getNumeroIdentificacion());

	        verify(afiliadoRepository, times(1)).findById(1);
	    }

	    @Test
	    public void shouldGetAfiliadoByIdentificacion() {
	        when(afiliadoRepository.findAfiliadoByNumeroIdentificacion("1000185557"))
	                .thenReturn(getAnyAfiliado());
	        afiliadoDto = afiliadoService.findByNumeroIdentificacion("1000185557");
	        assertEquals("1000185557", afiliadoDto.getNumeroIdentificacion());
	        assertEquals("CC", afiliadoDto.getTipoIdentificacion());

	        verify(afiliadoRepository, times(1)).findAfiliadoByNumeroIdentificacion("1000185557");
	    }

	    @Test
	    public void shouldGetExceptionWhenIdentificacionIsEmpty(){
	        ApiRequestException apiRequestException = Assertions.catchThrowableOfType(
	                () -> afiliadoService.findByNumeroIdentificacion(""), ApiRequestException.class);

	        assertEquals("El HttpQuery 'numeroIdentificacion' es requerido'", apiRequestException.getMessage());
	    }

	    @Test
	    public void shouldGetAfiliadoByUsuarioCreacion(){
	        when(afiliadoRepository.findAfiliadoByUsuarioCreacion("DESPINOG"))
	                .thenReturn(getAnyListAfiliados());
	        afiliadosDto = afiliadoService.findByUsuarioCreacion("DESPINOG");

	        assertTrue(afiliadosDto.size() >= 0);
	        assertEquals("DESPINOG", afiliadosDto.get(0).getUsuarioCreacion());

	        verify(afiliadoRepository, times(1)).findAfiliadoByUsuarioCreacion("DESPINOG");
	    }

	    @Test
	    public void shouldGetExceptionWhenUsuarioCreacionIsEmpty(){
	        ApiRequestException apiRequestException = Assertions.catchThrowableOfType(
	                () -> afiliadoService.findByUsuarioCreacion(""), ApiRequestException.class);

	        assertEquals("El HttpQuery 'usuarioCreación' es requerido'", apiRequestException.getMessage());
	    }

	    @Test
	    public void shouldGetAfiliadosByFechaCreacion(){
	        when(afiliadoRepository.filterByFechaCreacion("2021-03-20 16:00:00.000", "2021-11-17 16:00:00.000"))
	                .thenReturn(getAnyListAfiliados());

	        afiliadosDto = afiliadoService.filterByFechaCreacion("2021-03-20 16:00:00.000", "2021-11-17 16:00:00.000");
	        assertTrue(afiliadosDto.size() > 0);
	        assertEquals("2022-02-20 16:00:00.000", afiliadosDto.get(1).getFechaCreacion());

	        verify(afiliadoRepository, times(1))
	                .filterByFechaCreacion("2021-03-20 16:00:00.000", "2021-11-17 16:00:00.000");
	    }

	    @Test
	    public void shouldGetExceptionWhenFechaCreacionIsEmpty(){
	        ApiRequestException apiRequestException = Assertions.catchThrowableOfType(
	                () -> afiliadoService.filterByFechaCreacion("",""), ApiRequestException.class);

	        assertEquals("Los HttpQuery 'fromDate' y 'toDate' son requeridos'", apiRequestException.getMessage());
	    }

	    @Test
	    public void shouldSaveAfiliado(){
	        afiliadoDto = getAnyAfiliadoDto();
	        when(afiliadoRepository.save(Mockito.any(Afiliado.class))).thenReturn(new Afiliado());
	        afiliadoService.saveAfiliado(afiliadoDto);
	        verify(afiliadoRepository, times(1)).save(Mockito.any(Afiliado.class));
	    }

	    @Test
	    public void shouldGetExceptionWhenTipoIdentificacionIsInvalid(){
	        afiliadoDto = getAnyAfiliadoDto();
	        afiliadoDto.setTipoIdentificacion("cedula");
	        ApiRequestException apiRequestException = Assertions.catchThrowableOfType(
	                () -> afiliadoService.saveAfiliado(afiliadoDto), ApiRequestException.class);

	        assertEquals("Tipo de documento invalido.", apiRequestException.getMessage());
	    }

	    @Test
	    public void shouldUpdateAfiliado(){
	        afiliadoDto = getAnyAfiliadoDto();
	        when(afiliadoRepository.findById(1)).thenReturn(Optional.of(getAnyAfiliado()));
	        when(afiliadoRepository.save(Mockito.any(Afiliado.class))).thenReturn(new Afiliado());
	        afiliadoService.updateAfiliado(afiliadoDto);
	        verify(afiliadoRepository, times(1)).findById(1);
	        verify(afiliadoRepository, times(1)).save(Mockito.any(Afiliado.class));
	    }

	    @Test
	    public void shouldDeleteAfiliado(){
	        afiliadoService.deleteAfiliadoById(1);
	        verify(afiliadoRepository, times(1)).deleteById(1);
	    }
	}

