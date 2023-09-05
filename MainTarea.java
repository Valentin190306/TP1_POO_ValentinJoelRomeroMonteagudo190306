import ar.edu.unlu.poo.ListaEnlazadaDoble;
import ar.edu.unlu.poo.Tarea;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
/*
Ejercicio 5: Lista de Tareas
Una tarea es una acción que debe realizarse. Habitualmente todas las tareas que tenemos pendientes las ponemos en una lista, y en la medida que las vamos cumpliendo, las vamos "tachando". Queremos empezar a construir una app que gestione esta lista de tareas.
Una tarea es una descripción, que además contiene una prioridad y un estado (Si está completa o incompleta). Además, una tarea puede tener una fecha límite. Si la tarea sobrepasa esta fecha y su estado es incompleta, vamos a decir que la tarea está vencida.
A una tarea, le podemos modificar su descripción, cambiarle la prioridad y avisar que está terminada. Además, podemos querer mostrar la tarea, en cuyo caso muestra la descripción. Pero, si la tarea está terminada, el mensaje debería iniciar con el string "(Vencida)...".
A una tarea queremos poder preguntarle si se encuentra vencida o no, como así también le podemos consultar si está completa o no.
Se pide:

    1_ Generar un diagrama de clase simple de la clase Tarea.
    2_ Generar el código en Java que represente la tarea. Debe incluir todos los métodos derivados de la descripción.
    3_ Generar un programa en Java que haga uso de la clase Tarea, y cree las siguientes tareas:

       a_ "Ir al supermercado mañana". Debe tener la fecha límite establecida y estar incompleta.
       b_ "Consultar repuesto del auto". Debe tener la fecha límite para ayer y estar completa.
       c_ "Ir al cine a ver la nueva película de Marvel". Debe tener fecha límite de ayer y estar incompleta.

Este último programa debe configurar el estado especificado en cada objeto, y mostrar sus mensajes respectivos.
* */
public class MainTarea {
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