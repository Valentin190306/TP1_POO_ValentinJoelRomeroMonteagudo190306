import ar.edu.unlu.poo.Cola;
/*
Ejercicio 4: Cola
Implemente el TAD Cola. Defina cuál debe ser la interfaz a implementar; cuantos objetos están involucrados en la solución; responsabilidades de cada objeto involucrado y ejemplifique el uso.
*/
public class MainCola {

    public static void main (String[] args) {
        int a = 123;
        byte b = 100;
        double c = 123456789;

        Cola cola = new Cola();

        System.out.println(" > Cola de clientes: ");
        for (int i = 1 ; i <= 10 ; i++)
            cola.encolar("Cliente " + i);

        cola.mostrar();
        System.out.println(" > El primer cliente de la cola: " + cola.recuperar());

        System.out.println(" > Atendemos a los clientes . . .");
        for (int i = 0 ; i < 4 ; i++)
            System.out.println(" > " + cola.desencolar());

        System.out.println(" > La cola esta vacia: " + cola.vacio());
        System.out.println(" > Clientes que quedan en la cola: " + cola.cantidad());

        cola.mostrar();
    }
}
