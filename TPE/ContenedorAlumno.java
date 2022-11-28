package TPE;

import java.util.Comparator;

import Comparadores.Alumno.ComparadorApellido;
import Comparadores.Alumno.ComparadorCompuesto;
import Comparadores.Alumno.ComparadorNombre;
import Comparadores.Alumno.ComparadorDni;
import Comparadores.TipoPrimitivo.ComparadorString;
 
public class ContenedorAlumno extends ElementoAlumno{

    private ListaOrdenada<ElementoAlumno> elementos;
    private Comparator<ElementoAlumno> cond;
    private final int POSICION = 0;

    public ContenedorAlumno(String nombre) {
        super(nombre);
        ComparadorApellido<ElementoAlumno> c1 = new ComparadorApellido<ElementoAlumno>();
        ComparadorNombre<ElementoAlumno> c2 = new ComparadorNombre<ElementoAlumno>();
        ComparadorDni<ElementoAlumno> c3 = new ComparadorDni<ElementoAlumno>();
        ComparadorCompuesto<ElementoAlumno> compuesto = new ComparadorCompuesto<ElementoAlumno>(c2, c3);
        this.cond = new ComparadorCompuesto<ElementoAlumno>(c1, compuesto);
        this.elementos = new ListaOrdenada<ElementoAlumno>(this.cond);
    }

    public ContenedorAlumno(String nombre, Comparator<ElementoAlumno> comp) {
        this(nombre);
        this.cond = comp;
    }
    
    public void setCondicion(Comparator<ElementoAlumno> comp) {
        this.cond = comp;
        this.elementos.setComparador(comp);
    }

    @Override
    public int cantidadAlumnos() {
        int count = 0;
        for(ElementoAlumno e: elementos){
            count += e.cantidadAlumnos();
        }
        return count;
    }

    @Override
    public String getApellido() {
        if (!this.elementos.estaVacia()){
            if (this.elementos.getDato(POSICION).getApellido() != "Sin apellido")
                return this.elementos.getDato(POSICION).getApellido();
        }
        return "Sin apellido";
    }

    @Override
    public int getEdad() {
        if (!this.elementos.estaVacia()){
            if (this.elementos.getDato(POSICION).getEdad() != 0)
                return this.elementos.getDato(POSICION).getEdad();
        }
        return 0;   
    }

    @Override
    public long getDni() {
        if (!this.elementos.estaVacia()){
            if (this.elementos.getDato(POSICION).getDni() != 0)
                return this.elementos.getDato(POSICION).getDni();
        }
        return 0;
    }

    @Override
    public ListaOrdenada<String> getIntereses() {
        ListaOrdenada<String> res = new ListaOrdenada<String>(new ComparadorString());
        for(ElementoAlumno i: elementos){
            ListaOrdenada<String> aux = new ListaOrdenada<String>(i.getIntereses());
            for (String s: aux)
                res.add(s);
        }
        return res;
    }

    public void add(ElementoAlumno e){
        this.elementos.add(e);
    }
    
    public boolean remove(ElementoAlumno e){
        return this.elementos.remove(this.elementos.getPos(e));
    }

    @Override
    public String toString() {
        return "[Nombre= " + this.getNombre() + ", Cantidad de alumnos: " + this.cantidadAlumnos() + "]";
    }

    
}