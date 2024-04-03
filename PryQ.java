import java.util.ArrayList;
import java.util.List;


// Priority queue implementation in Java
public class PryQ<T extends Comparable<T>> {
	private List<T> data;

	// Implementing Priority Queue using inbuilt available List in Java
	public PryQ() {
		this.data = new ArrayList<T>();
	}

	// Element Inserting function
	public void Enqueue(T item) {
        // item Insertion
        data.add(item);
        int ci = data.size() - 1;

        // Re-structure heap(Max Heap) so that after addition max element will lie on top of pq
        while (ci > 0) {
            int pi = (ci - 1) / 2;
            if (data.get(ci).compareTo(data.get(pi)) >= 0)
                break;
            T tmp = data.get(ci);
            data.set(ci, data.get(pi));
            data.set(pi, tmp);
            ci = pi;
        }
    }

	public T Dequeue() {
        // deleting top element of pq
        int li = data.size() - 1;
        T frontItem = data.get(0);
        data.set(0, data.get(li));
        data.remove(li);

        --li;
        int pi = 0;

        // Re-structure heap(Max Heap) so that after deletion max element will lie on top of pq
        while (true) {
            int ci = pi * 2 + 1;
            if (ci > li)
                break;
            int rc = ci + 1;
            if (rc <= li && data.get(rc).compareTo(data.get(ci)) < 0)
                ci = rc;
            if (data.get(pi).compareTo(data.get(ci)) <= 0)
                break;
            T tmp = data.get(pi);
            data.set(pi, data.get(ci));
            data.set(ci, tmp);
            pi = ci;
        }
        return frontItem;
    }

	// Function which returns peek element
	public T Peek() {
		if(data.isEmpty()){
			return null;
		}
		T frontItem = data.get(0);
		return frontItem;
	}

	public int Count() {
		return data.size();
	}
}
