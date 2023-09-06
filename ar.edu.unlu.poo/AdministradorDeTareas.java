package ar.edu.unlu.poo;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

public class AdministradorDeTareas {
    private final List<Tarea> listaDeTareas = new ArrayList<>();

    public void crearTarea (String descripcion, LocalDate fechaVencimiento, Enum prioridad) {
        Tarea nuevaTarea = new Tarea(descripcion, fechaVencimiento, prioridad);
        listaDeTareas.add(nuevaTarea);
    }

    public void crearTarea (String titulo, String descripcion, LocalDate fechaVencimiento, Enum prioridad, LocalDate fechaRecordatorio) {
        Tarea nuevaTarea = new Tarea(titulo, descripcion, fechaVencimiento, prioridad, fechaRecordatorio);
        listaDeTareas.add(nuevaTarea);
    }

    public void agregarTarea(Tarea tarea) {
        listaDeTareas.add(tarea);
    }

    public List<Tarea> getListaDeTareas () {
        return listaDeTareas;
    }

    public List<Tarea> ordenarTareasNoVencidas () {
        List<Tarea> tareas_no_vencidas = listaDeTareas.stream().filter(tarea -> tarea.getEstado().toString().startsWith("REALIZADO")).collect(Collectors.toList());
        Collections.sort(listaDeTareas, new TareaComparator().reversed());
        return tareas_no_vencidas;
    }

    public boolean realizar (Tarea tarea) {
        Tarea auxiliar = null;

        for (Tarea listaDeTarea : listaDeTareas) {
            auxiliar = listaDeTarea;
            if (auxiliar == tarea) {
                tarea.tachar();
                break;
            }
        }

        return tarea.getEstado() == Tarea.estados.REALIZADO;
    }

    public Tarea buscar (String titulo) {
        Tarea auxiliar = null;

        for (int i = 0 ; i < listaDeTareas.size() ; i++) {
            auxiliar = listaDeTareas.get(i);
            if (auxiliar.getTitulo().equals(titulo))
                break;
        }

        return auxiliar;
    }

    private class TareaComparator implements Comparator<Tarea> {
        @Override
        public int compare (Tarea tarea1, Tarea tarea2) {
            int resultado = tarea1.getPrioridad().ordinal() - tarea2.getPrioridad().ordinal();

            if (resultado == 0)
                resultado = tarea1.getFechaVencimiento().compareTo(tarea2.getFechaVencimiento());

            return resultado;
        }
    }
}
