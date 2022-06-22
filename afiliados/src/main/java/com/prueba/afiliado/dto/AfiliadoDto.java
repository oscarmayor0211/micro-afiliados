package com.prueba.afiliado.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AfiliadoDto {

    private Integer afiliadoId;
    private String tipoIdentificacion;
    private String numeroIdentificacion;
    private String primerNombre;
    private String segundoNombre;
    private String primerApellido;
    private String segundoApellido;
    private String riesgoCat;
    private char activo;
    private String usuarioCreacion;
    private String fechaCreacion;
    private String usuarioUltimaModificacion;
    private String fechaUltimaModificacion;
    private String numeroCuenta;
    private String estadoCuenta;

}
