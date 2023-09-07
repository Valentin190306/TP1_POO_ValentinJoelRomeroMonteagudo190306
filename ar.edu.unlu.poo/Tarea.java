package ar.edu.unlu.poo;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Tarea {
    private String titulo;
    private String descripcion;
    private Enum prioridad;
    private Enum estado;
    private LocalDate fecha;
    private LocalDate fechaVencimiento;
    private LocalDate fechaRecordatorio;
    private LocalDate fechaFinalozacion = null;
    private Colaborador colaboradorFinal = null;

    public enum prioridades {MINIMO, MEDIO, MAXIMO}

    public enum estados {REALIZADO, NO_REALIZADO, VENCIDO}

    public Tarea () {
        setTitulo(null);
        setDescripcion(null);
        setPrioridad(prioridades.MINIMO);
        this.estado = estados.NO_REALIZADO;
        this.fecha = LocalDate.now();
        setFechaVencimiento(null);
        setFechaRecordatorio(null);
    }

    public Tarea (String descripcion, LocalDate fechaVencimiento, Enum prioridad) {
        setTitulo(null);
        setDescripcion(descripcion);
        setPrioridad(prioridad);
        this.estado = estados.NO_REALIZADO;
        this.fecha = LocalDate.now();
        setFechaVencimiento(fechaVencimiento);
        setFechaRecordatorio(null);
    }

    public Tarea (String titulo, String descripcion, LocalDate fechaVencimiento, Enum prioridad, LocalDate fechaRecordatorio) {
        setTitulo(titulo);
        setDescripcion(descripcion);
        setPrioridad(prioridad);
        this.estado = estados.NO_REALIZADO;
        this.fecha = LocalDate.now();
        setFechaVencimiento(fechaVencimiento);
        setFechaRecordatorio(fechaRecordatorio);
    }

    public void setTitulo (String titulo) {
        this.titulo = titulo;
    }

    public String getTitulo () {
        return titulo;
    }

    public void setDescripcion (String descripcion) {
        this.descripcion = descripcion;
    }

    public String getDescripcion () {
        return descripcion;
    }

    public void setPrioridad (Enum prioridad) {
        this.prioridad = prioridad;
    }

    public Enum getPrioridad () {
        if (fechaRecordatorio != null)
            if (fechaRecordatorio.isEqual(LocalDate.now()) || fechaRecordatorio.isEqual(LocalDate.now().minus(1, ChronoUnit.DAYS)))
                this.prioridad = prioridades.MAXIMO;
        return prioridad;
    }

    public void tachar () {
        this.estado = estados.REALIZADO;
        this.fechaFinalozacion = LocalDate.now();
    }

    public Enum getEstado () {
        if (fechaVencimiento != null && LocalDate.now().isAfter(fechaVencimiento) && estado != estados.REALIZADO) {
            this.estado = estados.VENCIDO;
        }
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

    public void setFechaRecordatorio(LocalDate fechaRecordatorio) {
        this.fechaRecordatorio = fechaRecordatorio;
    }

    public LocalDate getFechaRecordatorio() {
        return fechaRecordatorio;
    }

    public void setColaboradorFinal (Colaborador colaborador) {
        this.colaboradorFinal = colaborador;
    }

    public Colaborador getColaboradorFinal () {
        return colaboradorFinal;
    }

    public boolean estaVencida () {
        return LocalDate.now().isAfter(fechaVencimiento);
    }

    public boolean estaCompleta () {
        return estado == estados.REALIZADO;
    }

    public String mostrar () {
        String descripcion_tarea;
        if (getEstado() == estados.VENCIDO) {
            descripcion_tarea = "(Vencido) " + getTitulo() + " : " + descripcion;
            return descripcion_tarea;
        }
        else if (fechaRecordatorio != null && fechaVencimiento != null && getEstado() != estados.REALIZADO) {
            if ((fechaRecordatorio.isEqual(LocalDate.now()) || fechaRecordatorio.isAfter(LocalDate.now())) && LocalDate.now().isBefore(fechaVencimiento)) {
                descripcion_tarea = "(por vencer) " + getTitulo() + " : " + descripcion;
                return descripcion_tarea;
            }
        }
        else if (getEstado() == estados.REALIZADO) {
            descripcion_tarea = "(realizado) " + getTitulo() + " : " + descripcion;
            return descripcion_tarea;
        }
        descripcion_tarea = getTitulo() + " : " + descripcion;
        return descripcion;
    }
}
