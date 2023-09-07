import ar.edu.unlu.poo.Diccionario;
import ar.edu.unlu.poo.Jugador;
/*
Ejercicio 11
Debemos resolver una pequeña parte de un juego donde cada jugador puede formar palabras, y cada palabra tendrá un puntaje.
Por el momento, el puntaje de una palabra va a estar dado por:

   * la cantidad de letras de la palabra y
   * las letras k, z, x, y, w, q suman un punto más.

El puntaje de cada jugador se determina en base a las palabras que pudo “formar”, pero para que esa palabra sea válida tiene que existir en un diccionario.
Se requiere poder agregar nuevas palabras a cada jugador, siempre y cuando éstas sean válidas. Finalmente, debo poder obtener el puntaje total
de cada jugador y poder determinar cuál es el jugador con el puntaje más alto.
Objetivos:

    1- Encontrar los objetos que participan del problema.
    2- Definir asociaciones entre los objetos y comportamiento de cada uno.
    3- Desarrollar una clase que cree 2 jugadores. Luego, asignarles palabras a cada uno y, finalmente, determinar cuál es el ganador.
 */
public class MainJuegoDiccionario {
    public static void main (String[] args) {
        System.out.println(" __ Juego del Diccionario __\n");
        String[] palabrasDelDiccionario = {"Manzana", "Perro", "Feliz", "Cielo", "Libro", "Amarillo", "Esperanza", "Lluvia"};

        for (String s : palabrasDelDiccionario) Diccionario.agregarPalabra(s);

        Jugador jugador1 = new Jugador("Juan");
        Jugador jugador2 = new Jugador("Carlos");

        String[] palabrasDeJugador1 = {"Perro","Luna","Estrella","Planeta","Universo"};
        String[] palabrasDeJugador2 = {"Amor","Feliz","Paz","Sueños","Esperanza"};

        for (int i = 0 ; i < palabrasDeJugador1.length ; i++) {
            System.out.println(" _ Turno: " + i + " ---> " + jugador1.getNombre() + " juega la palabra " + palabrasDeJugador1[i]);
            if (jugador1.crearPalabra(palabrasDeJugador1[i]))
                System.out.println(" ** La palabra es valida **\n");
            else
                System.out.println(" ** La palabra no es valida **\n");

            System.out.println(" _ Turno: " + i + " ---> " + jugador2.getNombre() + " juega la palabra " + palabrasDeJugador2[i]);
            if (jugador2.crearPalabra(palabrasDeJugador2[i]))
                System.out.println(" ** La palabra es valida **\n");
            else
                System.out.println(" ** La palabra no es valida **\n");
        }

        System.out.println(" > El jugador " + jugador1.getNombre() + " obtuvo " + jugador1.getPuntajeTotal() + " puntos . . .");
        System.out.println(" > El jugador " + jugador2.getNombre() + " obtuvo " + jugador2.getPuntajeTotal() + " puntos . . .");

        if (jugador1.getPuntajeTotal() < jugador2.getPuntajeTotal())
            System.out.println(" >> " + jugador1.getNombre() + " ha ganado la ronda . . .");
        else if (jugador1.getPuntajeTotal() > jugador2.getPuntajeTotal())
            System.out.println(" >> " + jugador2.getNombre() + " ha ganado la ronda . . .");
        else
            System.out.println(" >> Empate . . .");
    }
}
