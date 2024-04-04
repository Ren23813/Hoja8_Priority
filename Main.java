import java.io.IOException;
import java.util.List;
import java.util.PriorityQueue;

public class Main {

    /**
     *
     * @param args Argumentos de la línea de comandos (no se utilizan en este caso).
     */
    public static void main(String[] args) {
        System.out.println("Hecho por el programa realizado sin javaUtil");
        miPriorityQueue();
        System.out.println("\n \n Hecho por el programa realizado con javaUtil");
        javaPremadePriorityQueue();
    }

    /**
     * Método que imprime la información del paciente en la parte superior de la cola de prioridad.
     *
     * @param pq Cola de prioridad de la cual se extraerá la información del paciente.
     */
    static void peekThis(PryQ pq) {
        System.out.println("Tamaño del Queue: " + pq.Count() + "\nSe atendió al paciente " + pq.PeekItem() + ", de gravedad: " + pq.PeekGravedad());
    }

    /**
     * Método que demuestra el uso de la implementación personalizada de una cola de prioridad.
     * Lee los datos de los pacientes desde un archivo, los encola en la cola de prioridad personalizada,
     * y luego atiende a los pacientes según su prioridad.
     * Este método maneja posibles errores si ocurren al leer el archivo.
     */
    static void miPriorityQueue() {
        try {
            List<Item> pacientes = Lector.leerPacientes("pacientes.txt");
            PryQ<Object, String> pq = new PryQ<Object, String>();

            for (Item paciente : pacientes) {
                pq.Enqueue(paciente, paciente.getGravedad());
            }

            int size = pq.Count();
            for (int i = 0; i < size; i++) {
                peekThis(pq);
                pq.Dequeue();
            }
        } catch (IOException e) {
            System.err.println("Error al leer el archivo: " + e.getMessage());
        }
    }

    /**
     * Método que demuestra el uso de la implementación de la cola de prioridad proporcionada por Java (PriorityQueue).
     * Lee los datos de los pacientes desde un archivo, los encola en la PriorityQueue de Java,
     * y luego atiende a los pacientes según su prioridad.
     * Este método maneja posibles errores de E/S si ocurren al leer el archivo.
     */
    static void javaPremadePriorityQueue() {
        try {
            List<Item> pacientes = Lector.leerPacientes("pacientes.txt");
            PriorityQueue<Item> priorityQueue = new PriorityQueue<>(pacientes.size(), (a, b) -> a.getGravedadValue() - b.getGravedadValue());

            for (Item paciente : pacientes) {
                priorityQueue.add(paciente);
            }

            int size = priorityQueue.size();
            for (int i = 0; i < size; i++) {
                System.out.println("Tamaño del Queue: " + priorityQueue.size() + "\nSe atendió al paciente: ");
                Item pacienteAtendido = priorityQueue.peek();
                System.out.print("Nombre: " + pacienteAtendido.getNombre());
                System.out.print(" Apellido: " + pacienteAtendido.getApellido());
                System.out.print(" Síntoma: " + pacienteAtendido.getSintoma());
                System.out.println(" Gravedad: " + pacienteAtendido.getGravedad());
                priorityQueue.poll();
            }
        } catch (IOException e) {
            System.err.println("Error al leer el archivo: " + e.getMessage());
        }
    }
}
