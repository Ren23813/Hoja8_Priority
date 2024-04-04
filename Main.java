import java.io.IOException;
import java.util.List;

public class Main {
    public static void main(String[] args) {
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

    static void peekThis(PryQ pq) {
        System.out.println("Tamaño del Queue: " + pq.Count() + "\nSe atendió al paciente " + pq.PeekItem() + ", de gravedad: " + pq.PeekGravedad());
    }
}
