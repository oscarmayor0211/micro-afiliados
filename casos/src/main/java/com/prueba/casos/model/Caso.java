package com.prueba.casos.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "COB_CASO", schema = "GCCOBRANZAS")
public class Caso {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CASO_ID")
    private Integer idCaso;

    @Column(name = "ITEM_TYPE")
    private String itemType;

    @Column(name = "ITEM_KEY")
    private String itemKey;

    @Column(name = "PROCESO")
    private String proceso;

    @Column(name = "PROCESO_ETAPA")
    private String procesoEtapa;

    @Column(name = "FECHA_ACTUAL_ETAPA")
    private String fechaActualEtapa;

    @Column(name = "CLASIFICACION_DEUDA")
    private String clasificacionDeuda;

    @Column(name = "ORIGEN_ASIGNACION_CAT")
    private String origenAsignacionCat;

    @Column(name = "COMPORTAMIENTO")
    private float comportamiento;

    @Column(name = "TIPO_IDENTIFICACION_EMP")
    private String tipoIdentificacionEmp;

    @Column(name = "NUMERO_IDENTIFICACION_EMP")
    private String numeroIdentificacionEmp;

    @Column(name = "RIESGO_EMP_CAT")
    private String riesgoEmpCat;

    @Column(name = "PERIODO_COSECHA")
    private float periodoCosecha;

    @Column(name = "FECHA_ULTIMO_PAGO")
    private String fechaUltimoPago;

    @Column(name = "ULTIMO_PERIODO_PAGADO")
    private float ultimoPeriodoPagado;

    @Column(name = "ESTADO_CASO_CAT")
    private String estadoCasoCat;

    @Column(name = "GESTOR_ID")
    private String gestorId;

    @Column(name = "PERIODO_INICIAL")
    private float periodoInicial;

    @Column(name = "PERIODO_FINAL")
    private float periodoFinal;

    @Column(name = "FECHA_INICIO_CASO")
    private String fechaInicioCaso;

    @Column(name = "FECHA_INICIO_PROCESO")
    private String fechaInicioProceso;

    @Column(name = "PROCESO_CAUSAL")
    private String procesoCausal;

    @Column(name = "FECHA_PROCESO_CAUSAL")
    private String fechaProcesoCausal;

    @Column(name = "EXCLUIR_COMUNICADO")
    private char excluirComunicado;

    @Column(name = "SOLICITUD_COBRO_ID")
    private Integer solicitudCobroId;

    @Column(name = "USUARIO_CREACION")
    private String usuarioCreacion;

    @Column(name = "FECHA_CREACION")
    private String fechaCreacion;

    @Column(name = "USUARIO_ULTIMA_MODIFICACION")
    private String usuarioUltimaModificacion;

    @Column(name = "FECHA_ULTIMA_MODIFICACION")
    private String fechaUltimaModificacion;

    @Column(name = "GESTOR_EXTERNO_ID")
    private Integer gestorExternoId;

    @Column(name = "FECHA_CORTE")
    private String fechaCorte;

    @Column(name = "GESTION_EXTENDIDA")
    private char gestionExtendida;

    @Column(name = "GESTION_EXTENDIDA_FECHA")
    private String gestionExtendidaFecha;

}
