package com.prueba.casos;

import com.prueba.casos.dto.CasoDto;
import com.prueba.casos.model.Caso;

import java.util.ArrayList;
import java.util.List;

abstract class AbstractTest {

    private List<CasoDto> casosDto = new ArrayList<>();
    private List<Caso> casos = new ArrayList<>();

    public List<CasoDto> getAnyCasosDto(){
        casosDto.add(new CasoDto(1, "Item","Key","DF","PP_LIQUIDACION",
                "2020-06-14 05:44:58.000", "FLUJO", "SA", 2,
                "NIT", "830123489", "RB", 200,
                "2020-03-05 06:25:26.000", 201901, "EST_CASO_EN_GESTION",
                "POR0010",202020, 202020, "2021-04-22 09:28:57.127",
                "2021-04-22 09:28:57.127", "JURID_HIST_RETIRO_DEMANDA",
                "2020-10-16 04:25:09.000", 'N', 20202, "POR11166",
                "2020-04-02 00:40:56.000", null, null, 2,
                "2020-07-05 00:00:00.000", 'N', "2021-01-09 00:00:00.000"));

        casosDto.add(new CasoDto(2, "Item","Key","DF","PP_LIQUIDACION",
                "2020-06-14 05:44:58.000", "FLUJO", "SA", 2,
                "NIT", "95547885", "RB", 200,
                "2020-03-05 06:25:26.000", 201901, "EST_CASO_EN_GESTION",
                "POR0010",202020, 202020, "2021-06-21 13:07:44.543",
                "2021-06-21 13:07:44.543", "JURID_HIST_RETIRO_DEMANDA",
                "2020-10-16 04:25:09.000", 'N', 20202, "POR11166",
                "2020-04-02 00:40:56.000", null, null, 2,
                "2020-07-05 00:00:00.000", 'N', "2021-01-09 00:00:00.000"));

        return casosDto;
    }

    public List<Caso> getAnyCasos(){
        casos.add(new Caso(1, "Item","Key","DF","PP_LIQUIDACION",
                "2020-06-14 05:44:58.000", "FLUJO", "SA", 2,
                "NIT", "830123489", "RB", 200,
                "2020-03-05 06:25:26.000", 201901, "EST_CASO_EN_GESTION",
                "POR0010",202020, 202020, "2021-04-22 09:28:57.127",
                "2021-04-22 09:28:57.127", "JURID_HIST_RETIRO_DEMANDA",
                "2020-10-16 04:25:09.000", 'N', 20202, "POR11166",
                "2020-04-02 00:40:56.000", null, null, 2,
                "2020-07-05 00:00:00.000", 'N', "2021-01-09 00:00:00.000"));

        casos.add(new Caso(2, "Item","Key","DF","PP_LIQUIDACION",
                "2020-06-14 05:44:58.000", "FLUJO", "SA", 2,
                "NIT", "830123489", "RB", 200,
                "2020-03-05 06:25:26.000", 201901, "EST_CASO_EN_GESTION",
                "POR0010",202020, 202020, "2021-06-21 13:07:44.543",
                "2021-06-21 13:07:44.543", "JURID_HIST_RETIRO_DEMANDA",
                "2020-10-16 04:25:09.000", 'N', 20202, "POR11166",
                "2020-04-02 00:40:56.000", null, null, 2,
                "2020-07-05 00:00:00.000", 'N', "2021-01-09 00:00:00.000"));

        return casos;
    }

    public CasoDto getAnyCasoDto(){
        return new CasoDto(1, "Item","Key","DF","PP_LIQUIDACION",
                "2020-06-14 05:44:58.000", "FLUJO", "SA", 2,
                "NIT", "830123489", "RB", 200,
                "2020-03-05 06:25:26.000", 201901, "EST_CASO_EN_GESTION",
                "POR0010",202020, 202020, "2020-09-25 04:10:22.000",
                "2021-04-22 09:28:57.127", "JURID_HIST_RETIRO_DEMANDA",
                "2020-10-16 04:25:09.000", 'N', 20202, "POR11166",
                "2020-04-02 00:40:56.000", null, null, 2,
                "2020-07-05 00:00:00.000", 'N', "2021-01-09 00:00:00.000");
    }

    public Caso getAnyCaso(){
        return new Caso(1, "Item","Key","DF","PP_LIQUIDACION",
                "2020-06-14 05:44:58.000", "FLUJO", "SA", 2,
                "NIT", "830123489", "RB", 200,
                "2020-03-05 06:25:26.000", 201901, "EST_CASO_EN_GESTION",
                "POR0010",202020, 202020, "2020-09-25 04:10:22.000",
                "2021-04-22 09:28:57.127", "JURID_HIST_RETIRO_DEMANDA",
                "2020-10-16 04:25:09.000", 'N', 20202, "POR11166",
                "2020-04-02 00:40:56.000", null, null, 2,
                "2020-07-05 00:00:00.000", 'N', "2021-01-09 00:00:00.000");
    }
}
