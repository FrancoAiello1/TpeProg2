import java.util.ArrayList;

public class Participante {
	
	private String nombre;
	private String apellido;
	private int edad;
	private ArrayList<Genero> generos;
	private ArrayList<Idioma> idiomas;
	private ArrayList<Instrumento> instrumentos;
	
	public Participante(String nombre, String apellido, int edad, ArrayList<Genero> generos, ArrayList<Idioma> idiomas,
			ArrayList<Instrumento> instrumentos) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.edad = edad;
		this.generos = generos;
		this.idiomas = idiomas;
		instrumentos = new ArrayList<>();
	}

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

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public ArrayList<Genero> getGeneros() {
		return generos;
	}

	public ArrayList<Idioma> getIdiomas() {
		return idiomas;
	}

	public ArrayList<Instrumento> getInstrumentos() {
		return instrumentos;
	}
	
	
}
