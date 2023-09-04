import ar.edu.unlu.poo.EcuacionSegundoGrado;
import java.util.Scanner;
/*
Ejercicio 7
Se requiere implementar una clase que represente y pueda resolver una ecuación de segundo grado. Dada una ecuación de 2do grado de la forma y = a * x^2 + b * x + c, la fórmula para el cálculo de las raíces es (-b ± √((b^2) - (4 * a * c))) / (2 * a). Una vez que se crea una instancia de la clase no se podrán modificar sus coeficientes. Recordar que puede darse el caso donde exista una única raíz y para que esto ocurra el discriminante ((b^2) - 4 * a * c) debe ser igual a 0. En este último caso, en vez de retornar 2 raíces se debería retornar una sola. Existe el caso también donde necesitemos calcular el valor de y en base al valor de x, que se pasa como parámetro.
Objetivos:

    _ Definir estructura y comportamiento.
    _ Crear una clase que utilice a la anterior y que pruebe todos los métodos con varios resultados.
*/
public class MainEcSegGrad {
    public static void main (String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println(" > Ingrese el coeficiente principal <a>: ");
        Double a = scanner.nextDouble();

        System.out.println(" > Ingrese el coeficiente <b>: ");
        Double b = scanner.nextDouble();

        System.out.println(" > Ingrese el coeficiente principal <a>: ");
        Double c = scanner.nextDouble();

        EcuacionSegundoGrado ecuacion = new EcuacionSegundoGrado(a, b, c);

        Double[] raices = ecuacion.calcularRaices();

        if (raices != null) {
            if (raices[0].equals(raices[1]))
                System.out.println(" > La ecuacion tiene una unica raiz doble: " + raices[0]);
            else
                System.out.println(" > La ecuacion tiene las raices: "+ raices[0].toString() +", "+ raices[1].toString());
        } else
            System.out.println(" > La ecuacion no tiene raices reales . . .");

        for (int i = 0 ; i < 10 ; i++)
            System.out.println(" _> f("+ i +") = "+ ecuacion.calcularImagen((double)i));
    }
}
