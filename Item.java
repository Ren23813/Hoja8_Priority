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

