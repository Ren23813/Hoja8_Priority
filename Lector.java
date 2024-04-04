import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase utilitaria para leer datos de pacientes desde un archivo de texto.
 */
public class Lector {

    /**
     * Lee los datos de los pacientes desde un archivo de texto y los convierte en una lista de objetos Item.
     *
     * @param rutaArchivo Ruta del archivo desde el cual se leerán los datos de los pacientes.
     * @return Lista de objetos Item que representan a los pacientes leídos del archivo.
     * @throws IOException Si ocurre un error de E/S al leer el archivo.
     */
    public static List<Item> leerPacientes(String rutaArchivo) throws IOException {
        List<Item> pacientes = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(rutaArchivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] partes = linea.split(",");
                if (partes.length == 3) { // Verifica si hay suficientes partes en la línea
                    String[] nombreApellido = partes[0].trim().split(" ");
                    String nombre = nombreApellido[0].trim();
                    String apellido = nombreApellido.length > 1 ? nombreApellido[1].trim() : "";
                    String sintoma = partes[1].trim(); // Síntoma debe ser la segunda parte
                    String gravedad = partes[2].trim(); // Gravedad debe ser la tercera parte
                    Item paciente = new Item(nombre, apellido, sintoma, gravedad);
                    pacientes.add(paciente);
                } else {
                    // Manejo de error si la línea no tiene el formato esperado
                    System.err.println("Error: La línea no tiene el formato esperado: " + linea);
                }
            }
        }

        return pacientes;
    }
}
