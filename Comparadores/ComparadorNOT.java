package Comparadores;
import java.util.Comparator;

public class ComparadorNOT<T> implements Comparator<T>{

    private Comparator<T> comp;

    public ComparadorNOT(Comparator<T> comp){
        this.comp = comp;
    }

    @Override
    public int compare(T o1, T o2) {
        return (-1)*this.comp.compare(o1, o2);
    }
    
}