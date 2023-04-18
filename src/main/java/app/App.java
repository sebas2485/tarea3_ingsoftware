package app;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import Clases.*;
import Control.*;
import Control.RutaNoEncontrada;

public final class App {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Crear listas vacías de Regalos y Proveedores
        List<Regalo> regalos = new ArrayList<Regalo>();
        List<Proveedor> proveedores = new ArrayList<Proveedor>();

        // Crear objetos File con las rutas de los archivos JSON
        File rutaRegalo = new File("C:\\Users\\HP\\OneDrive\\Escritorio\\EDITORES\\javaprojects\\tarea3\\src\\main\\java\\Json\\regalos.json");
        File rutaProveedor = new File("C:\\Users\\HP\\OneDrive\\Escritorio\\EDITORES\\javaprojects\\tarea3\\src\\main\\java\\Json\\proveedores.json");

        // Solicitar la edad y precio máximo al usuario y crear un objeto Comprador
        System.out.println("\nIngrese la edad:");
        int edad = sc.nextInt();

        System.out.println("\nIngrese el precio maximo: ");
        double precio = sc.nextDouble();

        Comprador comprador = new Comprador(precio, edad);

        // Crear un objeto Lista con las listas de Regalos y Proveedores y el objeto Comprador
        Lista lista = new Lista(regalos, proveedores, comprador);

        // Crear un objeto Archivo y leer los archivos JSON para agregar los objetos a las listas correspondientes
        Archivo archivo = new Archivo();
        try {
            archivo.leerArchivo(rutaProveedor, proveedores, Proveedor.class);
            archivo.leerArchivo(rutaRegalo, regalos, Regalo.class);
        } catch (RutaNoEncontrada e) {
            System.out.println(e.getMessage());
        }

        // Mostrar la lista de regalos que cumplen con los criterios del comprador
        System.out.println(lista.mostrarListaRegalos());

        // Cerrar el scanner
        sc.close();
    }
}

