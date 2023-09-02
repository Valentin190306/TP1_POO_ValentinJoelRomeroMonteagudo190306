import ar.edu.unlu.poo.ListaEnlazada;
import ar.edu.unlu.poo.ListaEnlazadaDoble;
import ar.edu.unlu.poo.Tarea;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;

public class ToDoList {
    public static void main (String[] args) {
        ListaEnlazadaDoble ToDoList = new ListaEnlazadaDoble();

        System.out.println(" -- Lista de tareas -- ");

        Tarea tarea1 = new Tarea();
        tarea1.setDescripcion("Ir al supermercado mañana");
        tarea1.setFechaVencimiento(LocalDate.now().plus(1, ChronoUnit.DAYS));
        tarea1.setPrioridad("IMPORTANTE");
        ToDoList.agregar(tarea1);

        Tarea tarea2 = new Tarea();
        tarea2.setDescripcion("Consultar repuesto del auto");
        tarea2.setFechaVencimiento(LocalDate.now().minus(1, ChronoUnit.DAYS));
        tarea2.tachar();
        tarea2.setPrioridad("IMPORTANTE");
        ToDoList.agregar(tarea2);

        Tarea tarea3 = new Tarea();
        tarea3.setDescripcion("Ir al cine a ver la nueva pelicula de Marvel");
        tarea3.setFechaVencimiento(LocalDate.now().minus(1, ChronoUnit.DAYS));
        tarea3.setPrioridad("INDIFERENTE");
        ToDoList.agregar(tarea3);

        tarea1.mostrar();
        tarea2.mostrar();
        tarea3.mostrar();
    }

}
