package Clases;

public class Comprador {
    private double precioMaximo;
    private int edad;

    public Comprador(double precioMaximo, int edad) {
        this.precioMaximo = precioMaximo;
        this.edad = edad;
    }

    public double getPrecioMaximo() {
        return precioMaximo;
    }

    public int getEdad() {
        return edad;
    }

}
