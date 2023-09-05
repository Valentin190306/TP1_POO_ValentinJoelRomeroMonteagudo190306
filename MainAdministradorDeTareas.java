import ar.edu.unlu.poo.AdministradorDeTareas;
import ar.edu.unlu.poo.Tarea;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;
/*
Ejercicio 12
Necesitamos también crear un administrador de tareas para nuestra lista, que me permita crear nuevas tareas y agregarlas a una lista. Se necesita que retorne la lista de tareas no vencidas ordenadas primero según la prioridad y luego según la fecha de vencimiento. Debe permitir la búsqueda de tareas por título, y dada una tarea poder marcarla como realizada.
Objetivos:

    1_ Definir estructura y comportamiento. Implementar.
    2_ Crear una lista de tareas
    3_ Agregar varias tareas y luego marcar algunas como realizadas.
    4_ Agregar algunas tareas con recordatorio mayor a la fecha actual, y algunas con la fecha actual. Luego pedir el listado de tareas e imprimirlas por consola.
 */
public class MainAdministradorDeTareas {
    public static void main (String[] args) {
        AdministradorDeTareas admin = new AdministradorDeTareas();


        LocalDate fechaVencimiento = LocalDate.now().plus(5, ChronoUnit.DAYS);
        LocalDate fechaRecordatorio = LocalDate.now().plus(4, ChronoUnit.DAYS);
        admin.crearTarea("Cita", "123 Calle Importante, 21:00", fechaVencimiento, Tarea.prioridades.MAXIMO, fechaRecordatorio);

        fechaVencimiento = LocalDate.now().plus(3, ChronoUnit.DAYS);
        fechaRecordatorio = LocalDate.now();
        admin.crearTarea("Dentista", "123 Calle No Tan Importante, 15:00", fechaVencimiento, Tarea.prioridades.MEDIO, fechaRecordatorio);

        fechaVencimiento = LocalDate.now().plus(8, ChronoUnit.DAYS);
        fechaRecordatorio = LocalDate.now().plus(8, ChronoUnit.DAYS);
        admin.crearTarea("Cumple del primo", "Recordar buscar al tio", fechaVencimiento, Tarea.prioridades.MAXIMO, fechaRecordatorio);

        fechaVencimiento = LocalDate.now().plus(2, ChronoUnit.DAYS);
        fechaRecordatorio = LocalDate.now();
        admin.crearTarea("Compras", "Huevos, cafe, y un cinta metrica", fechaVencimiento, Tarea.prioridades.MINIMO, fechaRecordatorio);

        Tarea buscando = admin.buscar("Cita");
        admin.realizar(buscando);
        buscando = admin.buscar("Compras");
        admin.realizar(buscando);

        List<Tarea> lista = admin.getListaDeTareas();

        Tarea auxiliar;
        for (int i = 0 ; i < lista.size() ; i++) {
            auxiliar = lista.get(i);
            System.out.println(" > "+ auxiliar.mostrar());
        }
    }
}
