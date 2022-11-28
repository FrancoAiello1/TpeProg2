package TPE;
public abstract class ElementoAlumno {
    protected String nombre;
    

	public ElementoAlumno(String nombre) {
		this.nombre = nombre;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
    
    public abstract int cantidadAlumnos();
    
	public abstract String getApellido();

	public abstract int getEdad();
	
	public abstract long getDni();

	public abstract ListaOrdenada<String> getIntereses();

}