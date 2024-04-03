
public class Main {
    public static void main(String[] args)
{
	PryQ<String> pq = new PryQ<String>();
	pq.Enqueue("E");
	pq.Enqueue("A");

	System.out.println("Size of pq is : " + pq.Count() + " and Peek Element is : " + pq.Peek());

	pq.Enqueue("B");
	pq.Enqueue("C");
	System.out.println("Size of pq is : " + pq.Count() + " and Peek Element is : " + pq.Peek());

	pq.Dequeue();
	System.out.println("Size of pq is : " + pq.Count() + " and Peek Element is : " + pq.Peek());

	pq.Dequeue();
	System.out.println("Size of pq is : " + pq.Count() + " and Peek Element is : " + pq.Peek());
	pq.Enqueue("D");
	System.out.println("Size of pq is : " + pq.Count() + " and Peek Element is : " + pq.Peek());
	pq.Dequeue();
	System.out.println("Size of pq is : " + pq.Count() + " and Peek Element is : " + pq.Peek());
	pq.Dequeue();
	System.out.println("Size of pq is : " + pq.Count() + " and Peek Element is : " + pq.Peek());
	pq.Dequeue();
	System.out.println("Size of pq is : " + pq.Count() + " and Peek Element is : " + pq.Peek());
}
}

