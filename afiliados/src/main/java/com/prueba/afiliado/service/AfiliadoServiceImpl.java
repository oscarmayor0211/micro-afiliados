package com.prueba.afiliado.service;


import com.prueba.afiliado.dto.AfiliadoDto;
import com.prueba.afiliado.exception.ApiRequestException;
import com.prueba.afiliado.model.Afiliado;
import com.prueba.afiliado.repository.AfiliadoRepository;
import com.prueba.afiliado.util.TipoDocumento;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class AfiliadoServiceImpl implements AfiliadoService {

    private final AfiliadoRepository afiliadoRepository;
    private Afiliado afiliado;
    private AfiliadoDto afiliadoDto;
    private List<Afiliado> afiliados;
    private List<AfiliadoDto> afiliadosDto;
    private TipoDocumento[] tiposDocumento;
    private ModelMapper modelMapper;

    public AfiliadoServiceImpl(AfiliadoRepository afiliadoRepository){
        this.afiliadoRepository = afiliadoRepository;
        this.afiliado = new Afiliado();
        this.afiliadoDto = new AfiliadoDto();
        this.afiliados = new ArrayList<>();
        this.afiliadosDto = new ArrayList<>();
        this.tiposDocumento = TipoDocumento.values();
        this.modelMapper = new ModelMapper();
    }
    
    public List<AfiliadoDto> getAll(){
        afiliados = afiliadoRepository.findAll();
        return mapListAfiliadosDto(afiliados);
    }

    public AfiliadoDto findById(Integer id){
        afiliado = afiliadoRepository.findById(id).orElse(null);
        afiliadoDto = modelMapper.map(afiliado, AfiliadoDto.class);
        return afiliadoDto;
    }

    public AfiliadoDto findByNumeroIdentificacion(String numeroIdentificacion){
        if(numeroIdentificacion.isEmpty()){
            throw new ApiRequestException("El HttpQuery 'numeroIdentificacion' es requerido'");
        }
        afiliado = afiliadoRepository.findAfiliadoByNumeroIdentificacion(numeroIdentificacion);
        afiliadoDto = modelMapper.map(afiliado, AfiliadoDto.class);
        return afiliadoDto;
    }

    public List<AfiliadoDto> findByUsuarioCreacion(String usuarioCreacion){
        if(usuarioCreacion.isEmpty()){
            throw new ApiRequestException("El HttpQuery 'usuarioCreación' es requerido'");
        }
        afiliados = afiliadoRepository.findAfiliadoByUsuarioCreacion(usuarioCreacion);
        return mapListAfiliadosDto(afiliados);
    }

    public List<AfiliadoDto> filterByFechaCreacion(String fromDate, String toDate){
        if(fromDate.isEmpty() || toDate.isEmpty()){
            throw new ApiRequestException("Los HttpQuery 'fromDate' y 'toDate' son requeridos'");
        }
        afiliados = afiliadoRepository.filterByFechaCreacion(fromDate, toDate);
        return mapListAfiliadosDto(afiliados);
    }

    public void saveAfiliado(AfiliadoDto afiliadoDtoReq){
        if (Arrays.stream(tiposDocumento).map(TipoDocumento::getName)
                .noneMatch(afiliadoDtoReq.getTipoIdentificacion()::equals)) {
            throw new ApiRequestException("Tipo de documento invalido.");
        }

        afiliado = modelMapper.map(afiliadoDtoReq, Afiliado.class);

        afiliadoRepository.save(afiliado);
    }

    public void updateAfiliado(AfiliadoDto afiliadoDtoReq){
        afiliadoDto = findById(afiliadoDtoReq.getAfiliadoId());

        afiliado = modelMapper.map(afiliadoDto, Afiliado.class);

        afiliado.setTipoIdentificacion(afiliadoDtoReq.getTipoIdentificacion());
        afiliado.setNumeroIdentificacion(afiliadoDtoReq.getNumeroIdentificacion());
        afiliado.setPrimerNombre(afiliadoDtoReq.getPrimerNombre());
        afiliado.setSegundoNombre(afiliadoDtoReq.getSegundoNombre());
        afiliado.setPrimerApellido(afiliadoDtoReq.getPrimerApellido());
        afiliado.setSegundoApellido(afiliadoDtoReq.getSegundoApellido());
        afiliado.setRiesgoCat(afiliadoDtoReq.getRiesgoCat());
        afiliado.setActivo(afiliadoDtoReq.getActivo());
        afiliado.setUsuarioUltimaModificacion(afiliadoDtoReq.getUsuarioUltimaModificacion());
        afiliado.setFechaUltimaModificacion(afiliadoDtoReq.getFechaUltimaModificacion());
        afiliado.setNumeroCuenta(afiliadoDtoReq.getNumeroCuenta());
        afiliado.setEstadoCuenta(afiliadoDtoReq.getEstadoCuenta());

        afiliadoRepository.save(afiliado);
    }

    public void deleteAfiliadoById(Integer id){
        afiliadoRepository.deleteById(id);
    }

    public List<AfiliadoDto> mapListAfiliadosDto(List<Afiliado> afiliadosList){
        this.afiliadosDto = new ArrayList<>();
        afiliadosList.forEach( a -> {
            this.afiliadoDto = modelMapper.map(a, AfiliadoDto.class);
            this.afiliadosDto.add(afiliadoDto);
        } );
        return this.afiliadosDto;
    }
}
