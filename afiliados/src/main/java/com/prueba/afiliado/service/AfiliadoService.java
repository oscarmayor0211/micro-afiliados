package com.prueba.afiliado.service;

import java.util.List;

import com.prueba.afiliado.dto.AfiliadoDto;
import com.prueba.afiliado.model.Afiliado;

public interface AfiliadoService {
	   public List<AfiliadoDto> getAll();
	   public AfiliadoDto findById(Integer id);
	   public AfiliadoDto findByNumeroIdentificacion(String numeroIdentificacion);
	   public List<AfiliadoDto> findByUsuarioCreacion(String usuarioCreacion);
	   public List<AfiliadoDto> filterByFechaCreacion(String fromDate, String toDate);
	   public void saveAfiliado(AfiliadoDto afiliadoDtoReq);
	   public void updateAfiliado(AfiliadoDto afiliadoDtoReq);
	   public void deleteAfiliadoById(Integer id);
	   public List<AfiliadoDto> mapListAfiliadosDto(List<Afiliado> afiliadosList);
}
