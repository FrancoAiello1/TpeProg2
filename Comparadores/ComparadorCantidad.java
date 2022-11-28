package Comparadores;

import java.util.Comparator;

import TPE.ElementoAlumno;

public class ComparadorCantidad implements Comparator<ElementoAlumno>{

    public int compare(ElementoAlumno a1, ElementoAlumno a2){
        return a1.cantidadAlumnos() - a2.cantidadAlumnos();
    }
}
