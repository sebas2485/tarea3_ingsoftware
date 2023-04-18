package Clases;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Proveedor {
    private String nombre;
    private double precioEnvio;

    @JsonCreator
    public Proveedor(@JsonProperty("nombre") String nombre,
            @JsonProperty("precioEnvio") double precioEnvio) {
        this.nombre = nombre;
        this.precioEnvio = precioEnvio;
    }

    public Proveedor(String nombre) {
        this.nombre = nombre;
        this.precioEnvio = getPrecioEnvio();
    }

    public String getNombre() {
        return nombre;
    }

    public double getPrecioEnvio() {
        return precioEnvio;
    }

}
