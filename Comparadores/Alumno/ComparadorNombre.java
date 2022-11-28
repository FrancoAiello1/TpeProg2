package Comparadores.Alumno;
import java.util.Comparator;

import TPE.ElementoAlumno;

public class ComparadorNombre<T> implements Comparator<ElementoAlumno> {

    public ComparadorNombre() {
        
    }

    @Override
    public int compare(ElementoAlumno a1, ElementoAlumno a2) {
        return a1.getNombre().compareTo(a2.getNombre());
    }
}