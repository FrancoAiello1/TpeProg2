package Comparadores.Alumno;
import java.util.Comparator;

import TPE.ElementoAlumno;

public class ComparadorApellido<T> implements Comparator<ElementoAlumno> {

    public ComparadorApellido() {

    }

    @Override
    public int compare(ElementoAlumno a1, ElementoAlumno a2) {
        return a1.getApellido().compareTo(a2.getApellido());
    }
}