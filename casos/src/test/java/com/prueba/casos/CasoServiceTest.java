package com.prueba.casos;

import com.prueba.casos.dto.CasoDto;
import com.prueba.casos.exception.ApiRequestException;
import com.prueba.casos.model.Caso;
import com.prueba.casos.repository.CasoRepository;
import com.prueba.casos.service.CasoService;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("test")
public class CasoServiceTest extends AbstractTest{

    @Autowired
    private CasoService casoService;

    @MockBean
    private CasoRepository casoRepository;

    private List<CasoDto> casosDto = new ArrayList<>();
    private CasoDto casoDto = new CasoDto();

    @Test
    public void shouldListCasos(){
        when(casoRepository.findAll()).thenReturn(getAnyCasos());
        casosDto = casoService.getAll();

        assertTrue(casosDto.size() >= 0);

        verify(casoRepository, times(1)).findAll();
    }

    @Test
    public void shouldGetCasoById(){
        when(casoRepository.findById(1)).thenReturn(java.util.Optional.of(getAnyCaso()));
        casoDto = casoService.findById(1);

        assertEquals("830123489", casoDto.getNumeroIdentificacionEmp());

        verify(casoRepository, times(1)).findById(1);
    }

    @Test
    public void shouldGetCasosByUsuarioCreacion() {
        when(casoRepository.findCasosByUsuarioCreacion("POR11166"))
                .thenReturn(getAnyCasos());
        casosDto = casoService.findCasosByUsuarioCreacion("POR11166");
        assertTrue(casosDto.size() >= 0);
        assertEquals("POR11166", casosDto.get(0).getUsuarioCreacion());
        assertEquals("POR11166", casosDto.get(1).getUsuarioCreacion());

        verify(casoRepository, times(1)).findCasosByUsuarioCreacion("POR11166");
    }

    @Test
    public void shouldGetExceptionWhenUsuarioCreacionIsEmpty(){
        ApiRequestException apiRequestException = Assertions.catchThrowableOfType(
                () -> casoService.findCasosByUsuarioCreacion(""), ApiRequestException.class);

        assertEquals("El HttpQuery 'usuarioCreación' es requerido'", apiRequestException.getMessage());
    }

    @Test
    public void shouldGetCasosByGestorId(){
        when(casoRepository.findCasosByGestorId("POR0010"))
                .thenReturn(getAnyCasos());
        casosDto = casoService.findCasosByGestorId("POR0010");

        assertTrue(casosDto.size() >= 0);
        assertEquals("POR0010", casosDto.get(0).getGestorId());
        assertEquals("POR0010", casosDto.get(1).getGestorId());

        verify(casoRepository, times(1)).findCasosByGestorId("POR0010");
    }

    @Test
    public void shouldGetExceptionWhenGestorIdIsEmpty(){
        ApiRequestException apiRequestException = Assertions.catchThrowableOfType(
                () -> casoService.findCasosByGestorId(""), ApiRequestException.class);

        assertEquals("El HttpQuery 'gestorId' es requerido'", apiRequestException.getMessage());
    }

    @Test
    public void shouldGetCasosByFechaCreacion(){
        when(casoRepository.filterCasosByFechaInicioCaso("2021-03-22 15:31:12.243", "2021-06-21 14:07:44.543"))
                .thenReturn(getAnyCasos());

        casosDto = casoService.filterCasosByFechaInicioCaso("2021-03-22 15:31:12.243", "2021-06-21 14:07:44.543");
        assertTrue(casosDto.size() > 0);
        assertEquals("2021-04-22 09:28:57.127", casosDto.get(0).getFechaInicioCaso());
        assertEquals("2021-06-21 13:07:44.543", casosDto.get(1).getFechaInicioCaso());

        verify(casoRepository, times(1))
                .filterCasosByFechaInicioCaso("2021-03-22 15:31:12.243", "2021-06-21 14:07:44.543");
    }

    @Test
    public void shouldGetExceptionWhenFechaCreacionIsEmpty(){
        ApiRequestException apiRequestException = Assertions.catchThrowableOfType(
                () -> casoService.filterCasosByFechaInicioCaso("",""), ApiRequestException.class);

        assertEquals("Los HttpQuery 'fromDate' y 'toDate' son requeridos'", apiRequestException.getMessage());
    }

    @Test
    public void shouldSaveCaso(){
        casoDto = getAnyCasoDto();
        when(casoRepository.save(Mockito.any(Caso.class))).thenReturn(new Caso());
        casoService.saveCaso(casoDto);
        verify(casoRepository, times(1)).save(Mockito.any(Caso.class));
    }

    @Test
    public void shouldUpdateCaso(){
        casoDto = getAnyCasoDto();
        when(casoRepository.findById(1)).thenReturn(java.util.Optional.of(getAnyCaso()));
        when(casoRepository.save(Mockito.any(Caso.class))).thenReturn(new Caso());
        casoService.updateCaso(casoDto);
        verify(casoRepository, times(1)).findById(1);
        verify(casoRepository, times(1)).save(Mockito.any(Caso.class));
    }

    @Test
    public void shouldDeleteCaso(){
        casoService.deleteCasoById(1);
        verify(casoRepository, times(1)).deleteById(1);
    }

}
