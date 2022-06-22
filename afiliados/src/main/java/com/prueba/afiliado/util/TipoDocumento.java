package com.prueba.afiliado.util;

public enum TipoDocumento {

    CC("CC","Cedula de ciudadania"),
    CE("CE","Cedula de extranjeria"),
    PA("PA","pasaporte");

    private String name;
    private String description;

    TipoDocumento(String name, String description){
        this.name = name;
        this.description = description;
    }

    public String getName() {
        return name;
    }

}
