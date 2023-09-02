package ar.edu.unlu.poo;

public class Cola {
    private Nodo primero;
    private Nodo ultimo;

    public Cola () {
        primero = null;
        ultimo = null;
    }

    public void encolar (Object dato) {
        Nodo nuevoNodo = new Nodo();
        nuevoNodo.setDato(dato);
        if (primero == null) {
            primero = nuevoNodo;
            ultimo = primero;
        } else {
            ultimo.setSiguiente(nuevoNodo);
            ultimo = nuevoNodo;
        }
    }

    public Object desencolar () {
        if (primero == null) return null;
        Object dato = primero.getDato();
        Nodo nodoAux = primero;
        primero = primero.getSiguiente();
        nodoAux.setSiguiente(null);
        return dato;
    }

    public int cantidad () {
        int contador = 0;
        Nodo nodoAux = primero;
        while (nodoAux != null) {
            nodoAux = nodoAux.getSiguiente();
            contador++;
        }
        return contador;
    }

    public boolean vacio () {
        return (primero == null && ultimo == null);
    }

    public Object recuperar () {
        if (primero == null) return null;
        return primero.getDato();
    }

    public void mostrar () {
        int indice = 1;
        if (primero == null) System.out.println("<Cola vacia>");
        else {
            Nodo nodoAux = primero;
            System.out.println("_Contenido de la cola: ");
            while (nodoAux != null) {
                System.out.println("_ " + indice + " : " + nodoAux.getDato());
                nodoAux = nodoAux.getSiguiente();
                indice++;
            }
        }
    }
}
