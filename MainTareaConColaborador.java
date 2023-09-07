import ar.edu.unlu.poo.AdministradorDeTareas;
import ar.edu.unlu.poo.Colaborador;
import ar.edu.unlu.poo.Tarea;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;
/*
Ejercicio 13
Seguimos extendiendo el ToDoList, se agregan nuevas funcionalidades. Ahora las tareas pueden resolverlas varias personas,
por lo cual una lista de tareas puede tener varios colaboradores y una tarea, cuando se marca finalizada, será realizada por un colaborador.
Cuando la tarea se marca finalizada debería registrar la fecha de finalización. Se debe poder obtener un listado de las tareas realizadas por un colaborador.
 */
public class MainTareaConColaborador {
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

        Colaborador colaborador = admin.crearColaborador("Valentin", "Romero Monteagudo", "Estudiante");

        Tarea buscando = admin.buscar("Cita");
        admin.realizar(buscando, colaborador);
        buscando = admin.buscar("Compras");
        admin.realizar(buscando, colaborador);

        List<Tarea> listaDelColaborador = admin.tareasRealizadasPorColaborador(colaborador);

        System.out.println(" __ Tareas realizadas por: " + colaborador.toString());

        for (Tarea tarea : listaDelColaborador) {
            System.out.println(" > " + tarea.mostrar());
        }
    }
}
