package ar.edu.unlu.poo;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class TareaConRecordatorio extends Tarea {
    private LocalDate fechaRecordatorio;

    public TareaConRecordatorio (String descripcion, LocalDate fechaVencimiento, String prioridad, LocalDate fechaRecordatorio) {
        super(descripcion, fechaVencimiento, prioridad);
        setFechaRecordatorio(fechaRecordatorio);
    }

    public void setFechaRecordatorio (LocalDate fechaRecordatorio) {
        this.fechaRecordatorio = fechaRecordatorio;
    }

    public LocalDate getFechaRecordatorio () {
        return fechaRecordatorio;
    }

    public String mostrar () {
        String descripcion_tarea;
        if (fechaRecordatorio != null)
            if ((fechaRecordatorio.isEqual(LocalDate.now()) || fechaRecordatorio.isAfter(LocalDate.now())) && LocalDate.now().isBefore(getFechaVencimiento())) {
                descripcion_tarea = "(por vencer) " + getDescripcion();
                return descripcion_tarea;
            }
        return getDescripcion();
    }

    public String actualizarPrioridad () {
        String prioridad;
        if (fechaRecordatorio != null)
            if (fechaRecordatorio.isEqual(LocalDate.now()) || fechaRecordatorio.isEqual(LocalDate.now().minus(1, ChronoUnit.DAYS)))
                setPrioridad("IMPORTANTE");
        return getPrioridad();
    }
}
