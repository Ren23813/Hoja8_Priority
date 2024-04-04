//Extraído mayoritariamente de Geeks for Geeks. Editado para cumplir con las funcionalidades requeridas por la hoja. 

import java.util.ArrayList;
import java.util.List;

/**
 * @param <Object> Tipo de objeto asociado a los elementos de la cola de prioridad.
 * @param <T>      Tipo de datos que define la prioridad de los elementos en la cola de prioridad, debe ser comparable.
 */
public class PryQ<Object, T extends Comparable<T>> {
    private List<T> dataPry;
    private List<Item> dataConstr;

    /**
     * Constructor de la clase PryQ. Inicializa las listas internas para almacenar los elementos y sus prioridades.
     */
    public PryQ() {
        this.dataPry = new ArrayList<T>();
        this.dataConstr = new ArrayList<Item>();
    }

    /**
     * Inserta un elemento en la cola de prioridad con su correspondiente valor de prioridad (gravedad).
     *
     * @param object Objeto asociado al elemento que se inserta en la cola.
     * @param item   Valor de prioridad (gravedad) del elemento que se inserta en la cola.
     */
    public void Enqueue(Item object, T item) {
        // Insertar el elemento
        dataPry.add(item);
        int ci = dataPry.size() - 1;
        dataConstr.add(object);

        // Reestructurar el montículo (heap) para que el elemento máximo esté en la cima de la cola de prioridad
        while (ci > 0) {
            int pi = (ci - 1) / 2;
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

    /**
     * Elimina y devuelve el elemento con la máxima prioridad de la cola de prioridad.
     *
     * @return Elemento con la máxima prioridad.
     * @throws IllegalStateException si la cola está vacía.
     */
    public T Dequeue() {
        if (dataPry.isEmpty())
            throw new IllegalStateException("La cola está vacía");

        int li = dataPry.size() - 1;
        T frontItem = dataPry.get(0);
        Item frontObject = dataConstr.get(0);

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

    /**
     * Devuelve el valor de prioridad (gravedad) del elemento con la máxima prioridad en la cola de prioridad.
     *
     * @return Valor de prioridad (gravedad) del elemento en la cima de la cola de prioridad.
     */
    public T PeekGravedad() {
        if (dataPry.isEmpty()) {
            return null;
        }

        return (T) dataConstr.get(0).getGravedad();
    }

    /**
     * Devuelve el valor asociado al elemento con la máxima prioridad en la cola de prioridad.
     *
     * @return Valor del elemento en la cima de la cola de prioridad.
     */
    public String PeekItem() {
        if (dataConstr.isEmpty()) {
            return null;
        }
        return dataConstr.get(0).getAll();
    }

    /**
     * Obtiene el número de elementos en la cola de prioridad.
     *
     * @return Número de elementos en la cola de prioridad.
     */
    public int Count() {
        return dataPry.size();
    }
}
