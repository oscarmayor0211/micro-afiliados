package com.prueba.casos.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CasoDto {

    private Integer idCaso;
    private String itemType;
    private String itemKey;
    private String proceso;
    private String procesoEtapa;
    private String fechaActualEtapa;
    private String clasificacionDeuda;
    private String origenAsignacionCat;
    private float comportamiento;
    private String tipoIdentificacionEmp;
    private String numeroIdentificacionEmp;
    private String riesgoEmpCat;
    private float periodoCosecha;
    private String fechaUltimoPago;
    private float ultimoPeriodoPagado;
    private String estadoCasoCat;
    private String gestorId;
    private float periodoInicial;
    private float periodoFinal;
    private String fechaInicioCaso;
    private String fechaInicioProceso;
    private String procesoCausal;
    private String fechaProcesoCausal;
    private char excluirComunicado;
    private Integer solicitudCobroId;
    private String usuarioCreacion;
    private String fechaCreacion;
    private String usuarioUltimaModificacion;
    private String fechaUltimaModificacion;
    private Integer gestorExternoId;
    private String fechaCorte;
    private char gestionExtendida;
    private String gestionExtendidaFecha;

}
