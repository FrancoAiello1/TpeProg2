package TPE;
import java.util.Iterator;
import java.util.Comparator;

public class ListaOrdenada<T> implements Iterable<T>{

    private Nodo<T> primero;
    private Comparator<T> comp;


    public ListaOrdenada(ListaOrdenada<T> lista) { //No es una copia exacta, sino que quedan las mismas referencias a los objeto
        this.comp = lista.getComparator();
        for(T contenido: lista){
            this.add(contenido);
        }
    }

    public ListaOrdenada(Comparator<T> c) {
        this.primero = null;
        this.comp = c;
    }

    public boolean estaVacia(){
        return this.primero == null;
    }

    public Comparator<T> getComparator(){
        return this.comp;
    }

    public T getDato(int pos){
        Nodo<T> cursor = this.primero;
        int i = 0;
        while ((cursor != null) && (i != pos)){
            cursor = cursor.getSig();
            i++;
        }
        if (cursor != null)
            return cursor.getContenido();
        else
            return null;
    }

//a) INSERTAR UN ELEMENTO EN LA ESTRUCTURA
    public void add(T dato) {
        Nodo<T> nuevo = new Nodo<>(dato);
        if (this.primero == null) {
            this.primero = nuevo;
        } else {
            insertarOrdenado(nuevo);
        }
    }
    private void insertarOrdenado(Nodo<T> nodo) {
        Nodo<T> cursor = this.primero;
        if (this.comp.compare(nodo.getContenido(), cursor.getContenido()) < 0){
            nodo.setSig(this.primero);
            this.primero = nodo;
        } else {
            while ((cursor.getSig() != null) && (this.comp.compare(nodo.getContenido(), cursor.getSig().getContenido()) > 0)) {
                cursor = cursor.getSig();
            }
            nodo.setSig(cursor.getSig());
            cursor.setSig(nodo);
        }
    }

//b) ELMINAR DADA UNA POSICION
    public boolean remove(int pos) {
        // Elimino el primero
        Nodo<T> cursor = this.primero;
        if (pos == 0) {
            this.primero = cursor.getSig();
            return true;
        } else {
            // Recorre hasta (pos-1) para pararse en el nodo anterior
            int i = 0;
            while ((cursor.getSig() != null) && (i < pos - 1)) {
                cursor = cursor.getSig();
                i++;
            }
            if (i == pos - 1) {
                Nodo<T> aux = cursor.getSig().getSig();
                cursor.setSig(aux);
                return true;
            } else{
                return false; // No existe la posicion
            }
        } 
    }

    public int size() {
        int cont = 0;
        Nodo<T> cursor = this.primero;
        while (cursor != null) {
            cursor = cursor.getSig();
            cont++;
        }
        return cont;
    }

//c) ELIMINAR TODAS LAS OCURRENCIAS DADAS
    public void removeAll(T dato) {
        Nodo<T> cursor = this.primero;
        if (cursor.getContenido().equals(dato)){
            this.primero = cursor.getSig();
            removeAll(dato);
        }
        while (cursor.getSig() != null) {
            if (cursor.getSig().getContenido().equals(dato)) {
                Nodo<T> aux = cursor.getSig().getSig();
                cursor.setSig(aux);
            }
            cursor = cursor.getSig();
        }
    }
//d) OBTENER POSICION DE UN ELEMENTO DADO
    public int getPos(T dato){
        Nodo<T> cursor = this.primero;
        int pos = 0;
        while ((cursor != null) && (!cursor.getContenido().equals(dato))){
            pos++;
            cursor = cursor.getSig();
        }
        if (pos > this.size() - 1)
            return -1;
        else 
            return pos;
    }

    public void imprimirLista(){
        iteradorLista it = new iteradorLista(this.primero);
        while (it.hasNext()){
            T i = it.next();
            System.out.println(i);
        }
    }
    
    @Override
    public Iterator<T> iterator() {
        return new iteradorLista(this.primero);
    }

//e) MECANISMO QUE PERMITE RECORRER LA LISTA
    private class iteradorLista implements Iterator<T>{
        Nodo<T> cursor;
        

        public iteradorLista(Nodo<T> cursor) {
            this.cursor = cursor;
        }

        @Override
        public boolean hasNext() {
            return this.cursor != null;
        }

        @Override
        public T next() {
            T contenido = cursor.getContenido();
            cursor = cursor.getSig();
            return contenido;
        }
    }
    
//f) PERMITIR CAMBIAR ORDEN
    public void setComparador(Comparator<T> c){
        this.comp = c;
        this.ordenar();
    }
    private void ordenar(){
        iteradorLista it = new iteradorLista(primero);
        ListaOrdenada<T> aux = new ListaOrdenada<>(this.comp);
        while (it.hasNext())
            aux.add(it.next());
        this.primero = null;
        for (T elem: aux){
            this.add(elem);
        }
    }
}