/**
 * Clase que representa un ítem de paciente con nombre, apellido, síntoma y gravedad.
 */
public class Item {
    private String nombre;
    private String apellido;
    private String sintoma;
    private String gravedad;

    /**
     * Constructor de la clase Item.
     *
     * @param nombre   Nombre del paciente.
     * @param apellido Apellido del paciente.
     * @param sintoma  Síntoma del paciente.
     * @param gravedad Gravedad del síntoma del paciente (A, B, C, D o E).
     */
    public Item(String nombre, String apellido, String sintoma, String gravedad) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.sintoma = sintoma;
        this.gravedad = gravedad;
    }

    /**
     * Obtiene el valor numérico asociado a la gravedad del síntoma del paciente.
     *
     * @return Valor numérico de la gravedad (1 para A, 2 para B, 3 para C, 4 para D, 5 para E).
     */
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
                return 0; 
        }
    }

    /**
     * Devuelve una cadena que representa todos los atributos del paciente excepto la gravedad.
     *
     * @return Cadena que contiene el nombre, apellido y síntoma del paciente.
     */
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
