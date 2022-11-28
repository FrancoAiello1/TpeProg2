package TPE;
public class Nodo<T>{
    
    private Nodo<T> sig;
    private T contenido;


    public Nodo(T contenido) {
        this.contenido = contenido;
        this.sig = null;
    }
    
    public T getContenido() {
        return this.contenido;
    } 
    
    public void setContenido(T contenido) {
        this.contenido = contenido;
    }
    
    public Nodo<T> getSig() {
        return sig;
    }
    
    public void setSig(Nodo<T> sig) {
        this.sig = sig;
    }
    
    @Override //No sabemos si lo vamos a usar
    public boolean equals(Object nodo){
        return this.contenido.equals(((Nodo<?>) nodo).getContenido());
    }
}