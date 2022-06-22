package com.prueba.casos.service;

import com.prueba.casos.dto.CasoDto;
import com.prueba.casos.exception.ApiRequestException;
import com.prueba.casos.model.Caso;
import com.prueba.casos.repository.CasoRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CasoServiceImpl implements CasoService{

    private final CasoRepository casoRepository;
    private ModelMapper modelMapper = new ModelMapper();

    public CasoServiceImpl(CasoRepository casoRepository){
        this.casoRepository = casoRepository;
    }

    public List<CasoDto> getAll(){
        List<Caso> casos = casoRepository.findAll();
        return mapListCasosToDto(casos);
    }

    public CasoDto findById(Integer id){
        Caso caso = casoRepository.findById(id).orElse(null);
        return modelMapper.map(caso, CasoDto.class);
    }

    public List<CasoDto> findCasosByUsuarioCreacion(String usuarioCreacion){
        if(usuarioCreacion.isEmpty()){
            throw new ApiRequestException("El HttpQuery 'usuarioCreación' es requerido'");
        }
        List<Caso> casos = casoRepository.findCasosByUsuarioCreacion(usuarioCreacion);
        return mapListCasosToDto(casos);
    }

    public List<CasoDto> findCasosByGestorId(String gestorId){
        if(gestorId.isEmpty()){
            throw new ApiRequestException("El HttpQuery 'gestorId' es requerido'");
        }
        List<Caso> casos = casoRepository.findCasosByGestorId(gestorId);
        return mapListCasosToDto(casos);
    }

    public List<CasoDto> filterCasosByFechaInicioCaso(String fromDate, String toDate){
        if(fromDate.isEmpty() || toDate.isEmpty()){
            throw new ApiRequestException("Los HttpQuery 'fromDate' y 'toDate' son requeridos'");
        }
        List<Caso> casos = casoRepository.filterCasosByFechaInicioCaso(fromDate, toDate);
        return mapListCasosToDto(casos);
    }

    public void saveCaso(CasoDto casoDto){
        casoRepository.save(modelMapper.map(casoDto, Caso.class));
    }

    public void updateCaso(CasoDto casoDtoReq){
        CasoDto casoDto = findById(casoDtoReq.getIdCaso());
        Caso caso = modelMapper.map(casoDto, Caso.class);
        caso.setItemType(casoDtoReq.getItemType());
        caso.setItemKey(casoDtoReq.getItemKey());
        caso.setProceso(casoDtoReq.getProceso());
        caso.setProcesoEtapa(casoDtoReq.getProcesoEtapa());
        caso.setFechaActualEtapa(casoDtoReq.getFechaActualEtapa());
        caso.setClasificacionDeuda(casoDtoReq.getClasificacionDeuda());
        caso.setOrigenAsignacionCat(casoDtoReq.getOrigenAsignacionCat());
        caso.setComportamiento(casoDtoReq.getComportamiento());
        caso.setTipoIdentificacionEmp(casoDtoReq.getTipoIdentificacionEmp());
        caso.setNumeroIdentificacionEmp(casoDtoReq.getNumeroIdentificacionEmp());
        caso.setRiesgoEmpCat(casoDtoReq.getRiesgoEmpCat());
        caso.setPeriodoCosecha(casoDtoReq.getPeriodoCosecha());
        caso.setFechaUltimoPago(casoDtoReq.getFechaUltimoPago());
        caso.setUltimoPeriodoPagado(casoDtoReq.getUltimoPeriodoPagado());
        caso.setEstadoCasoCat(casoDtoReq.getEstadoCasoCat());
        caso.setGestorId(casoDtoReq.getGestorId());
        caso.setPeriodoInicial(casoDtoReq.getPeriodoInicial());
        caso.setPeriodoFinal(casoDtoReq.getPeriodoFinal());
        caso.setFechaInicioCaso(casoDtoReq.getFechaInicioCaso());
        caso.setFechaInicioProceso(casoDtoReq.getFechaInicioProceso());
        caso.setProcesoCausal(casoDtoReq.getProcesoCausal());
        caso.setFechaProcesoCausal(casoDtoReq.getFechaProcesoCausal());
        caso.setExcluirComunicado(casoDtoReq.getExcluirComunicado());
        caso.setSolicitudCobroId(casoDtoReq.getSolicitudCobroId());
        caso.setUsuarioUltimaModificacion(casoDtoReq.getUsuarioUltimaModificacion());
        caso.setFechaUltimaModificacion(casoDtoReq.getFechaUltimaModificacion());
        caso.setGestorExternoId(casoDtoReq.getGestorExternoId());
        caso.setFechaCorte(casoDtoReq.getFechaCorte());
        caso.setGestionExtendida(casoDtoReq.getGestionExtendida());
        caso.setGestionExtendidaFecha(casoDtoReq.getGestionExtendidaFecha());

        casoRepository.save(caso);
    }

    public void deleteCasoById(Integer id){
        casoRepository.deleteById(id);
    }

    public List<CasoDto> mapListCasosToDto(List<Caso> casos){
        List<CasoDto> casosDto = new ArrayList<>();
        CasoDto casoDto;
        for (Caso c : casos) {
            casoDto = modelMapper.map(c, CasoDto.class);
            casosDto.add(casoDto);
        }
        return casosDto;
    }

}
