package ar.edu.unlu.poo;

public class Pila {
    private Nodo tope;
    public Pila () {
        this.tope = null;
    }

    public void apilar (Object dato) {
        Nodo nuevoNodo = new Nodo();
        nuevoNodo.setDato(dato);

        if (tope == null) {
            tope = nuevoNodo;
        } else {
            nuevoNodo.setSiguiente(tope);
            tope = nuevoNodo;
        }
    }

    public Object desapilar () {
        if (tope == null) {
            return null;
        } else {
            Object dato = tope.getDato();
            tope = tope.getSiguiente();
            return dato;
        }
    }

    public Object recuperar () {
        return tope.getDato();
    }

    public int cantidad () {
        int cantidad = 0;
        Nodo nodoAux = tope;
        while (nodoAux != null) {
            nodoAux = nodoAux.getSiguiente();
            cantidad++;
        }
        return cantidad;
    }

    public boolean vacio () {
        return tope == null;
    }

    public void mostrar () {
        int indice = 1;
        if (tope == null) System.out.println("<Pila vacia>");
        else {
            Nodo nodoAux = tope;
            System.out.println("_Contenido de la pila: ");
            while (nodoAux != null) {
                System.out.println("_ " + indice + " : " + nodoAux.getDato());
                nodoAux = nodoAux.getSiguiente();
                indice++;
            }
        }
    }
}
