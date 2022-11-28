package Comparadores.Alumno;
import java.util.Comparator;

import TPE.ElementoAlumno;

public class ComparadorDni<T> implements Comparator<ElementoAlumno> {
    
    public ComparadorDni() {

    }

    @Override
    public int compare(ElementoAlumno a1, ElementoAlumno a2) {
        long res = a1.getDni()-(a2.getDni());
        return ((int)res);
    }
    
}
