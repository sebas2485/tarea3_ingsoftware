package Clases;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Regalo {
    private String nombre;
    private int edad;
    private double precioBase;
    private Proveedor proveedor;

    /**
     * Este tipo de constructor se utiliza para que el ObjectMapper sepa como es la estructura de la clase.
     * La anotación "@JsonCreator" indica que este constructor es utilizado por la biblioteca Jackson para
     * deserializar objetos JSON en objetos Java de la clase Regalo.Cada uno de los argumentos del constructor
     * está anotado con "@JsonProperty", lo que indica a Jackson qué campo de JSON corresponde a cada argumento del constructor.
     * Los valores de estos campos JSON se usan para inicializar los campos correspondientes del objeto Regalo.
     * @param nombre
     * @param edad
     * @param precioBase
     * @param proveedor
     */
    @JsonCreator
    public Regalo(@JsonProperty("nombre") String nombre,
            @JsonProperty("edad") int edad,
            @JsonProperty("precio") double precioBase,
            @JsonProperty("proveedor") String proveedor) {
        this.nombre = nombre;
        this.edad = edad;
        this.precioBase = precioBase;
        this.proveedor = new Proveedor(proveedor);
    }

    public String getNombre() {
        return nombre;
    }

    public int getEdad() {
        return edad;
    }

    public double getPrecioBase() {
        return precioBase;
    }

    public Proveedor getProveedor() {
        return proveedor;
    }

}
