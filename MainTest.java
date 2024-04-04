import static org.junit.Assert.*;
import org.junit.Test;

public class MainTest {
    PryQ<Object, String> pq;
    Item patient1, patient2, patient3, patient4, patient5, patient6;

    public MainTest() {
        pq = new PryQ<Object, String>();
        patient1 = new Item("Maria", "Ramirez", "apendicitis", "A");
        patient2 = new Item("Carmen", "Sarmientos", "dolores de parto", "B");
        patient3 = new Item("Juan", "Perez", "fractura de pierna", "C");
        patient4 = new Item("Lorenzo", "Toledo", "chikungunya", "E");
        patient5 = new Item("Claudoveo", "Miramar", "comezon", "E");
        patient6 = new Item("Xavier", "Lamentos", "dolor abdominal fuerte", "D");

        pq.Enqueue(patient1, patient1.getGravedad());
        pq.Enqueue(patient2, patient2.getGravedad());
        pq.Enqueue(patient3, patient3.getGravedad());
        pq.Enqueue(patient4, patient4.getGravedad());
        pq.Enqueue(patient5, patient5.getGravedad());
        pq.Enqueue(patient6, patient6.getGravedad());
    }

    @Test
    public void agregadoCorrecto() {
        assertEquals(6, pq.Count());
    }

    @Test
    public void pruebaPeek() {
        assertEquals(patient1.getAll(), pq.PeekItem());
        assertEquals(patient1.getGravedad(), pq.PeekGravedad());
    }

    @Test
    public void pruebaCantidadCorrectaPostDequeue() {
        pq.Dequeue();
        assertEquals(5, pq.Count());
    }

    @Test
    public void pruebaCantidadIncorrectaPostDequeue() {     //Se espera nativamente un error.
        pq.Dequeue();
        assertEquals(3, pq.Count());
    }

    @Test
    public void peekPostDequeue() {
        pq.Dequeue();
        assertEquals(patient2.getAll(), pq.PeekItem());
        assertEquals(patient2.getGravedad(), pq.PeekGravedad());
    }
}
