package ar.edu.unlu.poo;
import java.time.LocalDate;

public class Tarea {
    private String descripcion;
    private String prioridad;
    private Enum estado;
    private LocalDate fecha;
    private LocalDate fechaVencimiento;

    public enum estados {
        INCOMPLETA,
        COMPLETADO
    }

    public Tarea () {
        setDescripcion(null);
        setPrioridad("INDIFERENTE");
        this.estado = estados.INCOMPLETA;
        this.fecha = LocalDate.now();
        setFechaVencimiento(null);
    }

    public Tarea (String descripcion, LocalDate fechaVencimiento, String prioridad) {
        setDescripcion(descripcion);
        setPrioridad(prioridad);
        this.estado = estados.INCOMPLETA;
        this.fecha = LocalDate.now();
        setFechaVencimiento(fechaVencimiento);
    }

    public void setDescripcion (String descripcion) {
        this.descripcion = descripcion;
    }

    public String getDescripcion () {
        return descripcion;
    }

    public void setPrioridad (String prioridad) {
        this.prioridad = prioridad;
    }

    public String getPrioridad () {
        return prioridad;
    }

    public void tachar () {
        this.estado = estados.COMPLETADO;
    }

    public Enum getEstado () {
        return estado;
    }

    public LocalDate getFechaDeCreacion () {
        return fecha;
    }

    public void setFechaVencimiento (LocalDate fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
    }

    public LocalDate getFechaVencimiento () {
        return fechaVencimiento;
    }

    public boolean estaVencida () {
        return LocalDate.now().isAfter(fechaVencimiento);
    }

    public boolean estaCompleta () {
        return estado == estados.COMPLETADO;
    }

    public String mostrar () {
        String descripcion_tarea;
        if (fechaVencimiento != null)
            if (LocalDate.now().isAfter(fechaVencimiento) && estado != estados.COMPLETADO) {
                descripcion_tarea = "(Vencido) " + descripcion;
                return descripcion_tarea;
            }
        return descripcion;
    }
}
