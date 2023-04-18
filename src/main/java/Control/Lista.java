package Control;

import java.util.List;
import Clases.*;

public class Lista {

    private List<Regalo> regalos;
    private List<Proveedor> proveedores;
    private Comprador comprador;

    public Lista(List<Regalo> regalos, List<Proveedor> proveedores, Comprador comprador) {
        this.regalos = regalos;
        this.proveedores = proveedores;
        this.comprador = comprador;
    }

    /**
     * Metodo que genera un String con la lista de regalos que cumplen con los
     * criterios del comprador
     *
     * @return String con la lista de regalos
     */
    public String mostrarListaRegalos() {

        double envio = 0;
        int cont = 0;
        StringBuilder sb = new StringBuilder(); // StringBuilder para generar el String de la lista de regalos

        for (int i = 0; i < regalos.size(); i++) {

            for (int j = 0; j < proveedores.size(); j++) {
                if (regalos.get(i).getProveedor().getNombre().equals(proveedores.get(j).getNombre())) {
                    envio = proveedores.get(j).getPrecioEnvio(); // Se obtiene el precio de envio del proveedor
                                                                 // correspondiente
                }
            }

            if (comprador.getEdad() == regalos.get(i).getEdad()
                    & comprador.getPrecioMaximo() >= regalos.get(i).getPrecioBase()) { // Se verifica si el regalo
                                                                                       // cumple con los criterios del
                                                                                       // comprador
                cont++; // Contador de regalos encontrados
                sb.append(regalos.get(i).getNombre()).append(": Precio Base: ").append(regalos.get(i).getPrecioBase())
                        .append(". Precio Envio: ").append(envio).append(". Precio Total: ")
                        .append(regalos.get(i).getPrecioBase() + envio).append("\n"); // Se agrega la información del
                                                                                      // regalo al StringBuilder
            }

        }
        if (cont == 0) { // Si no se encontraron regalos que cumplan con los criterios del comprador
            sb.append("\nNo se tiene productos para esa edad o precio\n"); // Se agrega un mensaje indicando que no se
                                                                           // encontraron regalos
        }
        return sb.toString(); // Se retorna el String con la lista de regalos
    }
}
