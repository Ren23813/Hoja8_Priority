import java.util.ArrayList;
import java.util.List;


// Priority queue implementation in Java
public class PryQ<Objetct, T extends Comparable<T>> {
	private List<T> dataPry;
	private List<Item> dataConstr;

	// Implementing Priority Queue using inbuilt available List in Java
	public PryQ() {
		this.dataPry = new ArrayList<T>();
		this.dataConstr = new ArrayList<Item>();
	}

	// Element Inserting function
	public void Enqueue(Item object, T item) {
        // item Insertion
        dataPry.add(item);
        int ci = dataPry.size() - 1;
		dataConstr.add(object);

        // Re-structure heap(Max Heap) so that after addition max element will lie on top of pq
        while (ci > 0) {
            int pi = (ci - 1) / 2;
            if (dataPry.get(ci).compareTo(dataPry.get(pi)) >= 0)
                break;
            T tmp = dataPry.get(ci);
            dataPry.set(ci, dataPry.get(pi));
			Item tmp2 = dataConstr.get(ci);
			dataConstr.set(ci,dataConstr.get(pi));
            dataPry.set(pi, tmp);
			dataConstr.set(pi,tmp2);
            ci = pi;
        }
    }

	public T Dequeue() {
		// Deleting top element of pq
		int li = dataPry.size() - 1;
		T frontItem = dataPry.get(0);
		dataPry.set(0, dataPry.get(li));
		dataPry.remove(li);
		// Remove corresponding item from dataConstr
		dataConstr.remove(0);
	
		--li;
		int pi = 0;
	
		// Re-structure heap(Max Heap) so that after deletion max element will lie on top of pq
		while (true) {
			int ci = pi * 2 + 1;
			if (ci > li)
				break;
			int rc = ci + 1;
			if (rc <= li && dataPry.get(rc).compareTo(dataPry.get(ci)) < 0)
				ci = rc;
			if (dataPry.get(pi).compareTo(dataPry.get(ci)) <= 0)
				break;
			T tmp = dataPry.get(pi);
			dataPry.set(pi, dataPry.get(ci));
			dataPry.set(ci, tmp);
			pi = ci;
		}
		return frontItem;
	}
	

	// Function which returns peek element
	public T PeekGravedad() {
		if(dataPry.isEmpty()){
			return null;
		}
		T frontItem = dataPry.get(0);
		
		return frontItem;
	}

	public String PeekItem() {
		if(dataConstr.isEmpty()){
			return null;
		}		
		return dataConstr.get(0).getAll();
	}

	public int Count() {
		return dataPry.size();
	}
}
