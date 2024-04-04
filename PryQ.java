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
		// Insertar el elemento
		dataPry.add(item);
		int ci = dataPry.size() - 1;
		dataConstr.add(object);
	
		// Reestructurar el montículo (heap) para que el elemento máximo esté en la cima de la cola de prioridad
		while (ci > 0) {
			int pi = (ci - 1) / 2;
			// Comparar los valores numéricos de gravedad
			if (object.getGravedadValue() >= dataConstr.get(pi).getGravedadValue())
				break;
			T tmp = dataPry.get(ci);
			dataPry.set(ci, dataPry.get(pi));
			Item tmp2 = dataConstr.get(ci);
			dataConstr.set(ci, dataConstr.get(pi));
			dataPry.set(pi, tmp);
			dataConstr.set(pi, tmp2);
			ci = pi;
		}
	}

	public T Dequeue() {
		if (dataPry.isEmpty())
			throw new IllegalStateException("La cola está vacía");
	
		int li = dataPry.size() - 1;
		T frontItem = dataPry.get(0);
		Item frontObject = dataConstr.get(0); // Guarda el objeto que se va a desencolar
	
		dataPry.set(0, dataPry.get(li));
		dataPry.remove(li);
		dataConstr.set(0, dataConstr.get(li));
		dataConstr.remove(li);
	
		--li;
		int pi = 0;
	
		while (true) {
			int ci = pi * 2 + 1;
			if (ci > li)
				break;
			int rc = ci + 1;
			if (rc <= li && dataConstr.get(rc).getGravedadValue() < dataConstr.get(ci).getGravedadValue())
				ci = rc;
			if (dataConstr.get(pi).getGravedadValue() <= dataConstr.get(ci).getGravedadValue())
				break;
			Item tmp = dataConstr.get(pi);
			dataConstr.set(pi, dataConstr.get(ci));
			dataConstr.set(ci, tmp);
			pi = ci;
		}
		return frontItem;
	}
	
	

	// Function which returns peek element
	public T PeekGravedad() {
		if(dataPry.isEmpty()){
			return null;
		}
		
		return (T) dataConstr.get(0).getGravedad();
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
