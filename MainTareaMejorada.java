import ar.edu.unlu.poo.TareaMejorada;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
/*
Ejercicio 10
Queremos extender la clase Tarea que tuvimos que desarrollar como ejercicio en la clase introductoria. Ahora se les puede establecer una fecha de recordatorio a las tareas, si esa fecha de recordatorio es mayor o igual a la fecha actual entonces las tareas se van a imprimir con el prefijo “(por vencer)”. Además, si la tarea se encuentra próxima a vencer (fecha posterior o igual a la del recordatorio) la prioridad sube a la más alta.
Objetivos:

    1_ Definir estructura y comportamiento.
    2_ Implementar los cambios y realizar pruebas para verificar el correcto funcionamiento
 */
public class MainTareaMejorada {
    public static void main (String[] args) {
        System.out.println(" __ Implementando clase - TareaMejorada - __");

        LocalDate fechaVencimiento = LocalDate.now().plus(5, ChronoUnit.DAYS);
        LocalDate fechaRecordatorio = LocalDate.now();

        TareaMejorada tarea = new TareaMejorada("Hacer las compras", fechaVencimiento, "INDIFERENTE", fechaRecordatorio);

        System.out.println(" > Descripcion: "+ tarea.mostrar());
        System.out.println(" > Actualizar prioridad: "+ tarea.actualizarPrioridad());
    }
}
