import ar.edu.unlu.poo.OperacionConFechas;
import java.time.temporal.ChronoUnit;
/*
Ejercicio 9
Se requiere crear una clase que ayude a realizar operaciones con fechas. Las operaciones requeridas son:

    1_ Devolver una fecha a partir de un string, con un formato específico. Los formatos pueden ser 2:
       - dd-MM-yyyy
       - MM-dd-yyyy

    2_ Determinar si una fecha se encuentra entre otras dos fechas.
    3_ Determinar si una fecha es mayor a otra fecha.
    4_ Determinar si una fecha es menor a otra fecha.

Objetivos:
    1_ Definir estructura y comportamiento.
    2_ Crear una clase que la utilice enviando mensajes para probar el correcto funcionamiento.
*/
public class MainFecha {
    public static void main (String[] args) {
        LocalDate fecha = LocalDate.now();
        OperacionConFechas fecha_operando = new OperacionConFechas(fecha);

        System.out.println(" > Fecha actual formateado a dd-MM-yyyy: "+ fecha_operando.formateadoDiaMesAnio());
        System.out.println(" > Fecha actual formateado a MM-dd-yyyy: "+ fecha_operando.formateadoMesDiaAnio());

        LocalDate fechaAnterior = LocalDate.now().minus(1, ChronoUnit.DAYS);
        LocalDate fechaPosterior = LocalDate.now().plus(1, ChronoUnit.DAYS);
        LocalDate fechaPosteriorPlus = LocalDate.now().plus(2, ChronoUnit.DAYS);

        OperacionConFechas fecha_anterior = new OperacionConFechas(fechaAnterior);
        OperacionConFechas fecha_posterior = new OperacionConFechas(fechaPosterior);
        OperacionConFechas fecha_posterior_plus = new OperacionConFechas(fechaPosteriorPlus);


        System.out.println(" > La fecha "+ fecha_operando.formateadoDiaMesAnio() +" se encuentra entre "+ fecha_anterior.formateadoDiaMesAnio() +
                " y "+ fecha_posterior.formateadoDiaMesAnio() +": "+ fecha_operando.entreFechas(fechaAnterior, fechaPosterior));

        System.out.println(" > La fecha "+ fecha_operando.formateadoDiaMesAnio() +" se encuentra entre "+ fecha_posterior.formateadoDiaMesAnio() +
                " y "+ fecha_posterior_plus.formateadoDiaMesAnio() +": "+ fecha_operando.entreFechas(fechaPosterior, fechaPosteriorPlus));

        System.out.println(" > La fecha actual es posterior a "+ fecha_anterior.formateadoMesDiaAnio() +" : "+ fecha_operando.posteriorA(fechaAnterior));
        System.out.println(" > La fecha actual es posterior a "+ fecha_posterior.formateadoMesDiaAnio() +" : "+ fecha_operando.posteriorA(fechaPosterior));
        System.out.println(" > La fecha actual es anterior a "+ fecha_anterior.formateadoMesDiaAnio() +" : "+ fecha_operando.anteriorA(fechaAnterior));
        System.out.println(" > La fecha actual es anterior a "+ fecha_posterior.formateadoMesDiaAnio() +" : "+ fecha_operando.anteriorA(fechaPosterior));
    }
}
