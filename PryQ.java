//Extraído de Geeks for Geeks

// Estructura que llevarán todos los elementos.

class PryQ {

public static Item[] pr = new Item[100000];
static int size = -1;

static void enqueue(int value, int priority)
{
	size++;
	pr[size] = new Item();
	pr[size].value = value;
	pr[size].priority = priority;
}


static int peek()
{
	int highestPriority = Integer.MIN_VALUE;
	int ind = -1;

	// Siempre accede al elemento con la prioridad más alta
	for (int i = 0; i <= size; i++) {

	// +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	if (highestPriority == pr[i].priority
		&& ind > -1
		&& pr[ind].value < pr[i].value) {
		highestPriority = pr[i].priority;
		ind = i;
	}

	else if (highestPriority < pr[i].priority) {
		highestPriority = pr[i].priority;
		ind = i;
	}
	}
	//Se devuelve el index del elemento 
	return ind;
}


static void dequeue()
{
	//Como es cola, se sigue el FIFO (priorizado)
	int ind = peek();
	for (int i = ind; i < size; i++) {
	pr[i] = pr[i + 1];
	}

	size--;
}

}