public class Main {
    public static void main(String[] args)
{
	// mayor numero = mayor prioridad 
	PryQ.enqueue(10, 2);
	PryQ.enqueue(14, 4);
	PryQ.enqueue(16, 4);
	PryQ.enqueue(12, 3);
    PryQ.enqueue(27, 1);
    PryQ.enqueue(77, 5);


	int ind = PryQ.peek();
	System.out.println(PryQ.pr[ind].value);
	PryQ.dequeue();

	ind = PryQ.peek();
	System.out.println(PryQ.pr[ind].value);
	PryQ.dequeue();

	ind = PryQ.peek();
	System.out.println(PryQ.pr[ind].value);
}
}
