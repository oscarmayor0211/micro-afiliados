package com.prueba.afiliado;
import java.util.ArrayList;
import java.util.List;


import com.prueba.afiliado.dto.AfiliadoDto;
import com.prueba.afiliado.model.Afiliado;

abstract class FakeUserTest {

    private List<AfiliadoDto> afiliadoDtos = new ArrayList<>();
    private List<Afiliado> afiliados = new ArrayList<>();

    public List<AfiliadoDto> getAnyListAfiliadosDto(){

        afiliadoDtos.add(new AfiliadoDto(1,"CC","1000185557",
                "Milton", "Fabian", "Gallego", "Jaramillo",
                "RM", 'S', "DESPINOG", "2021-03-20 16:00:00.000",
                null, null, "4124123", "VIGENTE"));

        afiliadoDtos.add(new AfiliadoDto(1,"CC","4234123",
                "Cristiano", "Ronaldo", "Saopaolo", "gaucho",
                "RM", 'S', "DESPINOG", "2022-02-20 16:00:00.000",
                null, null, "4124123", "VIGENTE"));

        return afiliadoDtos;
    }

    public AfiliadoDto getAnyAfiliadoDto(){
        return new AfiliadoDto(1,"CC","1116266430",
                "Oscar", "Eduardo", "Mayor", "Jaramillo",
                "RM", 'S', "DESPINOG", "2021-03-20 16:00:00.000",
                null, null, "4124123", "VIGENTE");
    }

    public List<Afiliado> getAnyListAfiliados(){

        afiliados.add(new Afiliado(1,"CC","8727827",
                "Gildardo", "Andres", "Mayor", "Marin",
                "RM", 'S', "DESPINOG", "2021-03-20 16:00:00.000",
                null, null, "4124123", "VIGENTE"));

        afiliados.add(new Afiliado(1,"CC","4234123",
                "Thomas", "Eduardo", "Marin", "Mayor",
                "RM", 'S', "DESPINOG", "2022-02-20 16:00:00.000",
                null, null, "4124123", "VIGENTE"));

        return afiliados;
    }

    public Afiliado getAnyAfiliado(){
        return new Afiliado(1,"CC","1000185557",
                "Juan", "Manuel", "Mayor", "Morales",
                "RM", 'S', "DESPINOG", "2022-11-17 16:00:00.000",
                null, null, "4124123", "VIGENTE");
    }


}
