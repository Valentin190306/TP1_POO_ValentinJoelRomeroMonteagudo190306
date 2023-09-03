import ar.edu.unlu.poo.EcuacionSegundoGrado;

import java.util.Scanner;

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
