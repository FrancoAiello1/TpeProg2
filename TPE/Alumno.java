package TPE;

public class Alumno extends ElementoAlumno{
    private String apellido;
    private long dni;
    private int edad;
    private ListaOrdenada<String> intereses;
    
    public Alumno(String nombre, String apellido, long dni, int edad, ListaOrdenada<String> intereses) {
        super(nombre);
        this.setNombre(nombre);
        this.apellido = apellido;
        this.dni = dni;
        this.intereses = new ListaOrdenada<String>(intereses);
    }

    
    @Override
    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    @Override
    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    @Override
    public long getDni() {
        return dni;
    }

    public void setDni(long dni) {
        this.dni = dni;
    }

    public void addIntereses(String interes) {
        this.intereses.add(interes);
    }
    
    public ListaOrdenada<String> getIntereses() {
        return new ListaOrdenada<String>(intereses);
    }

    @Override
    public int cantidadAlumnos() {
        return 1;
    }
}
