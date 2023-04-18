package Control;

/*Esta excepcion es lanzada cuando la ruta del archivo no existe */
public class RutaNoEncontrada extends Exception {
    RutaNoEncontrada(String error){
        super(error);
    }
}
