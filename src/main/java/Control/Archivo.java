package Control;

import java.util.List;
import java.io.File;
import java.io.IOException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;

public class Archivo {

    /**
     * Lee un archivo JSON y lo convierte en una lista de objetos del tipo especificado.
     *
     * @param <T>   el tipo de objeto que se espera en la lista
     * @param ruta  el archivo a leer
     * @param lista la lista en la que se almacenarán los objetos leídos
     * @param tipo  la clase del tipo de objeto esperado en la lista
     * @throws RutaNoEncontrada si la ruta especificada no existe
     */
    public <T> void leerArchivo(File ruta, List<T> lista, Class<T> tipo) throws RutaNoEncontrada {

        // Se crea un ObjectMapper para leer el archivo JSON
        ObjectMapper objectMapper = new ObjectMapper();

        // Si la ruta no existe, se lanza una excepción RutaNoEncontrada
        if (!ruta.exists()) {
            throw new RutaNoEncontrada("Error Ruta no encontrada");
        }

        // Leer el archivo JSON y convertirlo en un objeto Java
        try {
            JsonNode rootNode = objectMapper.readTree(ruta);

            // Si el archivo contiene un array, se procesa cada elemento del array
            if (rootNode.isArray()) {
                ArrayNode arrayNode = (ArrayNode) rootNode;
                for (JsonNode node : arrayNode) {
                    // Se convierte cada elemento del array en un objeto del tipo especificado
                    lista.add(objectMapper.treeToValue(node, tipo));
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
