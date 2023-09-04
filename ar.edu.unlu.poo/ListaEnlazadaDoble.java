package ar.edu.unlu.poo;
/*
Ejercicio 2: Lista enlazada doble
Teniendo implementada la TAD Lista enlazada simple orientada a objetos, implemente la TAD Lista enlazada doble.
*/
public class ListaEnlazadaDoble {
    private Nodo primero;

    public ListaEnlazadaDoble () {
        primero = null;
    }

    public boolean esVacio () {
        return primero == null;
    }

    public int cantidad () {
        if (primero == null) return 0;
        int cantidad = 0;
        Nodo nodoAux = primero;
        while (nodoAux != null) {
            nodoAux = nodoAux.getSiguiente();
            cantidad++;
        }
        return cantidad;
    }

    public void agregar (Object dato) {
        Nodo nuevoNodo = new Nodo();
        nuevoNodo.setDato(dato);

        if (primero == null) primero = nuevoNodo;

        else {
            Nodo nodoAux = primero;
            while (nodoAux.getSiguiente() != null) nodoAux = nodoAux.getSiguiente();
            nodoAux.setSiguiente(nuevoNodo);
            nuevoNodo.setAnterior(nodoAux);
        }
    }

    public void eliminar (int posicion) {
        if (primero == null) return;

        else if (posicion == 1) {
            primero = primero.getSiguiente();
            primero.setAnterior(null);
        }

        else {
            Nodo nodoAux = primero;
            for (int i = 2 ; i < posicion ; i++) {
                nodoAux = nodoAux.getSiguiente();
            }
            nodoAux.setSiguiente(nodoAux.getSiguiente().getSiguiente());
            nodoAux = nodoAux.getSiguiente().getSiguiente();
            nodoAux.setAnterior(nodoAux.getAnterior().getAnterior());
        }
    }

    public Object recuperar (int posicion) {
        if (primero == null) return null;

        Object dato = null;
        Nodo nodoAux = primero;
        for (int i = 1 ; i <= posicion ; i++) {
            if (i == posicion) dato = nodoAux.getDato();
            else nodoAux = nodoAux.getSiguiente();
        }
        return dato;
    }

    public void insertar (Object dato, int posicion) {
        if (primero == null) return;

        Nodo nuevoNodo = new Nodo();
        nuevoNodo.setDato(dato);

        Nodo nodoAux = primero;
        if (posicion != 1) {
            for (int i = 2 ; i < posicion ; i++) {
                nodoAux = nodoAux.getSiguiente();
            }
            nuevoNodo.setSiguiente(nodoAux.getSiguiente());
            nuevoNodo.setAnterior(nodoAux);
            nodoAux.getSiguiente().setAnterior(nuevoNodo);
            nodoAux.setSiguiente(nuevoNodo);
        }

        else {
            nuevoNodo.setSiguiente(nodoAux);
            nodoAux.setAnterior(nuevoNodo);
            primero = nuevoNodo;
        }
    }
}
