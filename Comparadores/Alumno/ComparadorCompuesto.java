package Comparadores.Alumno;
import java.util.Comparator;


public class ComparadorCompuesto<T> implements Comparator<T> {

    private Comparator<T> c1, c2;

    public ComparadorCompuesto(Comparator<T> c1, Comparator<T> c2){
        this.c1 = c1;
        this.c2 = c2;
    }

    @Override
    public int compare(T a1, T a2){
        int aux = c1.compare(a1, a2);
        if(aux != 0)
            return aux;
        return c2.compare(a1, a2);
    }
}