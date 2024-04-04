public class Item {
    private String nombre;
    private String apellido;
    private String sintoma;
    private String gravedad; // Podrías usar un tipo de dato más específico si lo necesitas, como un enum

    // Constructor
    public Item(String nombre, String apellido, String sintoma, String gravedad) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.sintoma = sintoma;
        this.gravedad = gravedad;
    }
    public int getGravedadValue() {
    switch (gravedad) {
        case "A":
            return 1;
        case "B":
            return 2;
        case "C":
            return 3;
        case "D":
            return 4;
        case "E":
            return 5;
        default:
            return 0; // Valor por defecto en caso de gravedad desconocida
    }
}

    public String getAll() {
        return "Nombre: " + nombre + ", Apellido: " + apellido + ", Síntoma: " + sintoma;
    }
    
    // Métodos getters y setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getSintoma() {
        return sintoma;
    }

    public void setSintoma(String sintoma) {
        this.sintoma = sintoma;
    }

    public String getGravedad() {
        return gravedad;
    }

    public void setGravedad(String gravedad) {
        this.gravedad = gravedad;
    }
}

