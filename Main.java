import java.io.IOException;
import java.util.List;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) {
		System.out.println("Hecho por el programa realizado sin javaUtil");
        miPriorityQueue();
		System.out.println("\n \n Hecho por el programa realizado con javaUtil");
		javaPremadePriorityQueue();
    }

    static void peekThis(PryQ pq) {
        System.out.println("Tamaño del Queue: " + pq.Count() + "\nSe atendió al paciente " + pq.PeekItem() + ", de gravedad: " + pq.PeekGravedad());
    }

	static void miPriorityQueue(){
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
				System.out.println(" Gravedad: " + pacienteAtendido.getGravedad());                priorityQueue.poll();
            }
        } catch (IOException e) {
            System.err.println("Error al leer el archivo: " + e.getMessage());
        }
    }
}
