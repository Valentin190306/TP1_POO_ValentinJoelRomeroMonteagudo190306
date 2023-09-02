package ar.edu.unlu.poo;

public class Nodo {
  private Object dato;
  private Nodo anterior = null;
  private Nodo siguiente = null;
  
  public void setDato (Object dato) {
    this.dato = dato;
  }
  public Object getDato () {
    return dato;
  }
  public void setAnterior (Nodo nodo) { this.anterior = nodo; }
  public Nodo getAnterior () { return  anterior; }
  public void setSiguiente (Nodo nodo) {
    this.siguiente = nodo;
  }
  public Nodo getSiguiente () {
    return siguiente;
  }
}