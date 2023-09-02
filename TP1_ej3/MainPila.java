import ar.edu.unlu.poo.Pila;

public class MainPila {
  public static void main (String[] args) {
    int a = 123;
    byte b = 100;
    double c = 123456789;

    Pila pila = new Pila();

    System.out.println(" > Pila de platos: ");
    for (int i = 1 ; i <= 10 ; i++)
      pila.apilar("Plato " + i);

    pila.mostrar();
    System.out.println(" > El plato superior de la pila: " + pila.recuperar());

    System.out.println(" > Ponemos la messa . . .");
    for (int i = 0 ; i < 4 ; i++)
      System.out.println(" > " + pila.desapilar());

    System.out.println(" > La pila esta vacia: " + pila.vacio());
    System.out.println(" > Platos que quedaron en la pila: " + pila.cantidad());

    pila.mostrar();
  }
}