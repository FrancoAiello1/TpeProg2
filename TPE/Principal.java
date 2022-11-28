package TPE;

import Comparadores.TipoPrimitivo.*;

import Comparadores.ComparadorCantidad;
import Comparadores.ComparadorNOT;

public class Principal {
    public static void main(String[] args) {

// ----------- a) Crear lista con valores asignados en determinado orden. -------------------------------
        System.out.println("a) Crear lista con valores asignados en determinado orden.");
        ComparadorInteger c = new ComparadorInteger();
        ListaOrdenada<Integer> listaInt = new ListaOrdenada<Integer>(c);
        listaInt.add(10);
        listaInt.add(21);
        listaInt.add(1);
        listaInt.add(5);
        listaInt.add(11);
// ----------- b) Recorrer lista usando foreach e imprimirla. -------------------------------------------
        System.out.println("b) Recorrer lista usando foreach e imprimirla.");
        for(int i: listaInt){
            System.out.println(i);
        }

// ----------- c) Eliminar el primer elemento, luego el elemento "5" y luego el elemento "11" -----------
        System.out.println("c) Eliminar el primer elemento, luego el elemento '5' y luego el elemento '11'");
        listaInt.remove(0);
        listaInt.remove(listaInt.getPos(5));
        listaInt.remove(listaInt.getPos(11));
        listaInt.imprimirLista();

// ----------- d) Crear lista de String con valores "Facil", "Es", "Parcial", "Prog 2" ------------------
        System.out.println("d) Crear lista de String con valores 'Facil', 'Es', 'Parcial', 'Prog 2'");
        ComparadorString cS = new ComparadorString();
        ListaOrdenada<String> listaString = new ListaOrdenada<String>(cS);
        listaString.add("Fácil");
        listaString.add("Es");
        listaString.add("Parcial");
        listaString.add("Prog 2");
// ----------- e) Recorrer lista e imprimir. ------------------------------------------------------------
    System.out.println("e) Recorrer lista e imprimir");
    for(String s: listaString){
        System.out.println(s);
    }
// ----------- f) Imprimir la posicion de la palabra "Parcial" ------------------------------------------
    System.out.println("f) Posicion de la palabra Parcial: " + listaString.getPos("Parcial"));

// ----------- g) Imprimir la posicion de la palabra "Recuperatorio" ------------------------------------
    System.out.println("g) Posicion de la palabra Recuperatorio: " + listaString.getPos("Recuperatorio"));

// ----------- h) Cambiar orden de lista de Strings para que sea descendente
    System.out.println("h) Cambiar orden de lista de Strings para que sea descendente");
    ComparadorNOT<String> not = new ComparadorNOT<String>(cS);
    listaString.setComparador(not);
    listaString.imprimirLista();
         
// ----------- i) Estructura 1 --------------------------------------------------------------------------
    ContenedorAlumno unicen = new ContenedorAlumno("Unicen", new ComparadorCantidad());
    ContenedorAlumno exactas = new ContenedorAlumno("Exactas");
    ContenedorAlumno humanas = new ContenedorAlumno("Humanas");
    ContenedorAlumno historia = new ContenedorAlumno("historia");
    humanas.add(historia);
    unicen.add(exactas);
    unicen.add(humanas);
    
    ListaOrdenada<String> intereses1 = new ListaOrdenada<>(new ComparadorString());
    intereses1.add("intercambio");
    Alumno a1 = new Alumno("John", "Doe", 1200000, 22, new ListaOrdenada<String>(intereses1));

    unicen.add(a1);

    ListaOrdenada<String> intereses2 = new ListaOrdenada<>(new ComparadorString());
    intereses2.add("redes");
    intereses2.add("php");
    intereses2.add("java");
    intereses2.add("python");
    Alumno a2 = new Alumno("Federico", "Lopez", 35999888, 22, new ListaOrdenada<String>(intereses2));

    ListaOrdenada<String> intereses3 = new ListaOrdenada<>(new ComparadorString());
    intereses3.add("programacion");
    intereses3.add("php");
    intereses3.add("java");
    Alumno a3 = new Alumno("Juana", "Garcia", 27123455, 27, new ListaOrdenada<String>(intereses3));

    exactas.add(a2);
    exactas.add(a3);

    ListaOrdenada<String> intereses4 = new ListaOrdenada<>(new ComparadorString());
    intereses4.add("psicologia");
    intereses4.add("Freud");
    Alumno a4 = new Alumno("Mora", "Diaz", 37724425, 25, new ListaOrdenada<String>(intereses4));
    
    humanas.add(a4);

    ListaOrdenada<String> intereses5 = new ListaOrdenada<>(new ComparadorString());
    intereses5.add("historia");
    intereses5.add("antigua");
    Alumno a5 = new Alumno("Flora", "Rivas", 34555111, 22, new ListaOrdenada<String>(intereses5));

    ListaOrdenada<String> intereses6 = new ListaOrdenada<>(new ComparadorString());
    intereses6.add("romanos");
    intereses6.add("egipcios");
    intereses6.add("grigos");
    Alumno a6 = new Alumno("Martin", "Gomez", 34111222, 23, new ListaOrdenada<String>(intereses6));

    ListaOrdenada<String> intereses7 = new ListaOrdenada<>(new ComparadorString());
    intereses7.add("argentina");
    Alumno a7 = new Alumno("Roman", "Bazar", 32555111, 44, new ListaOrdenada<String>(intereses7));

    historia.add(a5);
    historia.add(a6);
    historia.add(a7);

// ----------- Estructura 2 -----------------------------------------------------------------------------
    ContenedorAlumno olimpiadas = new ContenedorAlumno("Olimpiadas Matematicas", new ComparadorCantidad());
    ContenedorAlumno matea2 = new ContenedorAlumno("Matea2");
    ContenedorAlumno losfibo = new ContenedorAlumno("LosFibo");
    olimpiadas.add(matea2);
    olimpiadas.add(losfibo);

    ListaOrdenada<String> intereses8 = new ListaOrdenada<>(new ComparadorString());
    intereses8.add("sucesiones");
    intereses8.add("algebra");
    Alumno a8 = new Alumno("Juan", "Juarez", 33222444, 24, new ListaOrdenada<String>(intereses8));
    
    Alumno a9 = new Alumno("Julio", "Cesar", 33222111, 23, new ListaOrdenada<String>(intereses8));
    
    matea2.add(a8);
    matea2.add(a9);

    ListaOrdenada<String> intereses10 = new ListaOrdenada<>(new ComparadorString());
    intereses10.add("matematicas");
    Alumno a10 = new Alumno("Bernardino", "Rivas", 30987654, 22, new ListaOrdenada<String>(intereses10));

    ListaOrdenada<String> intereses11 = new ListaOrdenada<>(new ComparadorString());
    intereses11.add("problemas");
    Alumno a11 = new Alumno("Jose", "Paso", 33322112, 18, new ListaOrdenada<String>(intereses11));

    ListaOrdenada<String> intereses12 = new ListaOrdenada<>(new ComparadorString());
    intereses12.add("sucesiones");
    Alumno a12 = new Alumno("Isaac", "Newton", 12343465, 30, new ListaOrdenada<String>(intereses12));

    losfibo.add(a10);
    losfibo.add(a11);
    losfibo.add(a12);

// ----------- Lista vinculada de estructuras, ordenada descendentemente---------------------------------

    
    ListaOrdenada<ElementoAlumno> lista = new ListaOrdenada<ElementoAlumno>(new ComparadorNOT<>(new ComparadorCantidad()));
    lista.add(unicen);
    lista.add(olimpiadas);
    System.out.println("i) Estructuras ordenadas por cantidad de alumnos");
    lista.imprimirLista();
    }
}