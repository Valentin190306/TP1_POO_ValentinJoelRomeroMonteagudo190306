package ar.edu.unlu.poo;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

public class AdministradorDeTareas {
    private List<Tarea> listaDeTareas = new ArrayList<>();
    private List<Colaborador> colaboradores = new ArrayList<>();

    public Tarea crearTarea (String descripcion, LocalDate fechaVencimiento, Enum prioridad) {
        Tarea nuevaTarea = new Tarea(descripcion, fechaVencimiento, prioridad);
        listaDeTareas.add(nuevaTarea);
        return nuevaTarea;
    }

    public Tarea crearTarea (String titulo, String descripcion, LocalDate fechaVencimiento, Enum prioridad, LocalDate fechaRecordatorio) {
        Tarea nuevaTarea = new Tarea(titulo, descripcion, fechaVencimiento, prioridad, fechaRecordatorio);
        listaDeTareas.add(nuevaTarea);
        return nuevaTarea;
    }

    public Colaborador crearColaborador (String nombre, String apellido, String rol) {
        Colaborador nuevoColaborador = new Colaborador(nombre, apellido, rol);
        colaboradores.add(nuevoColaborador);
        return nuevoColaborador;
    }

    public void agregarTarea(Tarea tarea) {
        listaDeTareas.add(tarea);
    }

    public void eliminarTarea (Tarea tarea) {
        listaDeTareas.remove(tarea);
    }

    public void agregarColaborador (Colaborador colaborador) {
        colaboradores.add(colaborador);
    }

    public void eliminarColaborador (Colaborador colaborador) {
        colaboradores.remove(colaborador);
    }

    public List<Tarea> getListaDeTareas () {
        return listaDeTareas;
    }

    public List<Tarea> tareasRealizadasPorColaborador (Colaborador colaborador) {
        if (colaboradores.contains(colaborador)) {
            List<Tarea> tareasRealizadas = listaDeTareas.stream().filter(tarea -> tarea.getEstado().toString().startsWith("REALIZADO")).toList();
            List<Tarea> tareasDelColaborador = tareasRealizadas.stream().filter(tarea -> tarea.getColaboradorFinal().equals(colaborador)).toList();
            return tareasDelColaborador;
        } else return null;
    }

    public List<Tarea> ordenarTareasNoVencidas () {
        List<Tarea> tareas_no_vencidas = listaDeTareas.stream().filter(tarea -> tarea.getEstado().toString().startsWith("REALIZADO")).collect(Collectors.toList());
        Collections.sort(listaDeTareas, new TareaComparator().reversed());
        return tareas_no_vencidas;
    }

    public boolean realizar (Tarea tarea, Colaborador colaborador) {
        if (listaDeTareas.contains(tarea) && colaborador != null) {
            tarea.tachar();
            if (colaboradores.contains(colaborador))
                colaboradores.add(colaborador);
            tarea.setColaboradorFinal(colaborador);
            return true;
        } else return false;
    }

    public boolean realizar (Tarea tarea) {
        if (listaDeTareas.contains(tarea)) {
            tarea.tachar();
            return true;
        } else return false;
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
