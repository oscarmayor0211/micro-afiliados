package com.prueba.casos.controller;

import com.prueba.casos.dto.CasoDto;
import com.prueba.casos.service.CasoService;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/caso")
public class CasoController {

    private final CasoService casoService;

    public CasoController(CasoService casoService){
        this.casoService = casoService;
    }

    @ApiOperation(value = "Listar todos los casos")
    @GetMapping
    public ResponseEntity<List<CasoDto>> getAll(){
        return new ResponseEntity<>(casoService.getAll(), HttpStatus.OK);
    }

    @ApiOperation(value = "Listar caso por Id")
    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CasoDto> findById(@PathVariable Integer id){
        return new ResponseEntity<>(casoService.findById(id), HttpStatus.OK);
    }

    @ApiOperation(value = "Listar casos por usuario de creacion")
    @GetMapping(value = "/filtrarUsuarioCreacion", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<CasoDto>> findByUsuarioCreacion(@RequestParam String usuarioCreacion){
        return new ResponseEntity<>(casoService.findCasosByUsuarioCreacion(usuarioCreacion), HttpStatus.OK);
    }

    @ApiOperation(value = "Listar casos por gestorId")
    @GetMapping(value = "/filtrarGestorId", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<CasoDto>> findCasoByGestorId(@RequestParam String gestorId){
        return new ResponseEntity<>(casoService.findCasosByGestorId(gestorId), HttpStatus.OK);
    }

    @ApiOperation(value = "Filtrar busqueda por intervalo de fecha de inicio de proceso")
    @GetMapping(value = "/filtrarFechaInicioCaso", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<CasoDto>> filterCasosByFechaInicioCaso(@RequestParam String fromDate,
                                                                      @RequestParam String toDate){
        return new ResponseEntity<>(casoService.filterCasosByFechaInicioCaso(fromDate, toDate), HttpStatus.OK);
    }

    @ApiOperation(value = "Guardar un nuevo caso")
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> saveCaso(@RequestBody CasoDto casoDto){
        casoService.saveCaso(casoDto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @ApiOperation(value = "Actualizar un caso")
    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> updateCaso(@RequestBody CasoDto casoDto){
        casoService.updateCaso(casoDto);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @ApiOperation(value = "Eliminar un caso por Id")
    @DeleteMapping(value = "{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> deleteCasoById(@PathVariable Integer id){
        casoService.deleteCasoById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
