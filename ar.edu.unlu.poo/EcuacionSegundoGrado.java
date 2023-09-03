package ar.edu.unlu.poo;
import java.util.ArrayList;
import java.util.List;

public class EcuacionSegundoGrado {
    private Double y;
    private Double x = 0.0;
    private Double a;
    private Double b;
    private Double c;

    public EcuacionSegundoGrado (Double a, Double b, Double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }
    
    public Double[] calcularRaices () {
        Double[] raices = new Double[2];
        Double discriminante = (double) (Math.pow(b, 2) - 4 * a * c);
        if (discriminante > 0) {
            raices[0] = (double) ((-b + Math.sqrt(discriminante)) / (2 * a));
            raices[1] = (double) ((-b - Math.sqrt(discriminante)) / (2 * a));
            return raices;
        } else if (discriminante == 0) {
            raices[0] = (double) ((-b + Math.sqrt(discriminante)) / (2 * a));
            raices[1] = (double) raices[0];
            return raices;
        } else if (discriminante < 0);
            return null;
    }

    public Double calcularImagen (Double x) {
        return (a * Math.pow(x, 2) + b * x + c);
    }
}
