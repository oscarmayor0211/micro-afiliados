package com.prueba.afiliado.controller;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.prueba.afiliado.dto.AfiliadoDto;
import com.prueba.afiliado.service.AfiliadoServiceImpl;

import java.util.List;

@RestController
@RequestMapping("/api/v1/afiliado")
@Api
public class AfiliadoController {

    private final AfiliadoServiceImpl afiliadoService;

    public AfiliadoController(AfiliadoServiceImpl afiliadoService){
        this.afiliadoService = afiliadoService;
    }

    @ApiOperation(value = "Listar todos los afiliados", response = AfiliadoDto.class)
    @GetMapping(value = "", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<AfiliadoDto>> getAll(){
        return new ResponseEntity<>(afiliadoService.getAll(), HttpStatus.OK);
    }

    @ApiOperation(value = "Buscar afiliado por id", response = AfiliadoDto.class)
    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<AfiliadoDto> findById(@PathVariable Integer id){
        return new ResponseEntity<>(afiliadoService.findById(id), HttpStatus.OK);
    }

    @ApiOperation(value= "Filtrar busqueda por numero de identificacion", response = AfiliadoDto.class)
    @GetMapping(value = "/filtrarIdentificacion", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<AfiliadoDto> findByNumeroIdentificacion(@RequestParam String numeroIdentificacion){
        return new ResponseEntity<>(afiliadoService.findByNumeroIdentificacion(numeroIdentificacion), HttpStatus.OK);
    }

    @ApiOperation( value ="Filtrar busqueda por usuario de creacion" , response = AfiliadoDto.class)
    @GetMapping(value = "/filtrarUsuarioCreacion", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<AfiliadoDto>> filtrarByUsuarioCreacion(@RequestParam String usuarioCreacion){
        return new ResponseEntity<>(afiliadoService.findByUsuarioCreacion(usuarioCreacion), HttpStatus.OK);
    }

    @ApiOperation(value = "Filtrar busqueda por intervalo de fecha de creacion" ,response = AfiliadoDto.class)
    @GetMapping(value = "/filtrarFechaCreacion", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<AfiliadoDto>> filtrarFechaCreacion(@RequestParam String fromDate,
                                                               @RequestParam String toDate){
        return new ResponseEntity<>(afiliadoService.filterByFechaCreacion(fromDate, toDate), HttpStatus.OK);
    }

    @ApiOperation(value = "Guardar un nuevo afiliado" , response = AfiliadoDto.class)
    @PostMapping(value = "", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> saveAfiliado(@RequestBody AfiliadoDto afiliadoDto){
        afiliadoService.saveAfiliado(afiliadoDto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @ApiOperation(value = "Actualizar un afiliado",response = Object.class)
    @PutMapping(value = "", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> updatedAfiliado(@RequestBody AfiliadoDto afiliadoDto){
        afiliadoService.updateAfiliado(afiliadoDto);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @ApiOperation(value = "Eliminar un afiliado" , response = Object.class)
    @DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> deleteAfiliadoById(@PathVariable Integer id){
        afiliadoService.deleteAfiliadoById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
