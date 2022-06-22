package com.prueba.casos.service;

import com.prueba.casos.dto.CasoDto;
import com.prueba.casos.model.Caso;

import java.util.List;

public interface CasoService {
    public List<CasoDto> getAll();

    public CasoDto findById(Integer id);

    public List<CasoDto> findCasosByUsuarioCreacion(String usuarioCreacion);

    public List<CasoDto> findCasosByGestorId(String gestorId);

    public List<CasoDto> filterCasosByFechaInicioCaso(String fromDate, String toDate);

    public void saveCaso(CasoDto casoDto);

    public void updateCaso(CasoDto casoDtoReq);

    public void deleteCasoById(Integer id);

    public List<CasoDto> mapListCasosToDto(List<Caso> casos);
}