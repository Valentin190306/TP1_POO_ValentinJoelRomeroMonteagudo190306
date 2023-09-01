package ar.edu.unlu.poo;

public class ListaEnlazada {
  private Nodo primero;

  public ListaEnlazada () {
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
    }
  }

  public void eliminar (int posicion) {
    if (primero == null) return;

    else if (posicion == 1) primero = primero.getSiguiente();

    else {
      Nodo nodoAux = primero;
      for (int i = 2 ; i < posicion ; i++) {
        nodoAux = nodoAux.getSiguiente();
      }
      nodoAux.setSiguiente(nodoAux.getSiguiente().getSiguiente());
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

    if (posicion != 1) {
      Nodo nodoAux = primero;
      for (int i = 2 ; i < posicion ; i++) {
          nodoAux = nodoAux.getSiguiente();
      }
      nuevoNodo.setSiguiente(nodoAux.getSiguiente());
      nodoAux.setSiguiente(nuevoNodo);
    }

    else {
      nuevoNodo.setSiguiente(primero);
      primero = nuevoNodo;
    }
  }

  public String toString() {
    String acumulador = "";
    Nodo nodoAux = primero;
    int i = 1;
    
    if (primero == null) acumulador = "Lista vacia...";
    
    else {
      while (nodoAux != null) {
        acumulador += "Nodo " + i + " " + nodoAux.getDato() + "\n";
        i++;
        nodoAux = nodoAux.getSiguiente();
      }
      //return acumulador;
    }
    
    return acumulador;
  }
}