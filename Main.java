
public class Main {
    public static void main(String[] args)
{
	PryQ<Object, String> pq = new PryQ<Object, String>();
	Item paciente1 = new Item("Juan", "García", "Fiebre", "E");
	pq.Enqueue(paciente1, paciente1.getGravedad());
	Item paciente2 = new Item("babab", "bb", "Sida", "A");
	pq.Enqueue(paciente2,paciente2.getGravedad());
	Item paciente3 = new Item("cccc", "cac", "comezon", "B");
	pq.Enqueue(paciente3,paciente3.getGravedad());

	int size = pq.Count();
	for (int i = 0; i < size; i++) {
		peekThis(pq);
		pq.Dequeue();	
	}
	
}
static void peekThis(PryQ pq){
	System.out.println("Tamaño del Queue: " + pq.Count() + " \n Se atendió al paciente " + pq.PeekItem() + ", de gravedad: " + pq.PeekGravedad());

}

}

