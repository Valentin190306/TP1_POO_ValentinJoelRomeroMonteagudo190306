import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class OperacionConFechas {
    private LocalDate fecha = null;

    public OperacionConFechas (LocalDate fecha) {
        this.fecha = fecha;
    }

    public void setFecha1 (LocalDate fecha1) {
        this.fecha = fecha;
    }

    public LocalDate getFecha () {
        return fecha;
    }

    public String formateadoDiaMesAnio () {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        return fecha.format(formatter);
    }

    public String formateadoMesDiaAnio () {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM-dd-yyyy");
        return fecha.format(formatter);
    }

    public boolean entreFechas (LocalDate fecha1, LocalDate fecha2) {
        if (fecha == null) return false;
        LocalDate fechaAnterior;
        LocalDate fechaPosterior;

        if (fecha1.isBefore(fecha2)) {
            fechaAnterior = fecha1;
            fechaPosterior = fecha2;
        } else {
            fechaAnterior = fecha2;
            fechaPosterior = fecha1;
        }

        if (fecha.isAfter(fechaAnterior) && fecha.isBefore(fechaPosterior))
            return true;
        else return false;
    }

    public boolean posteriorA (LocalDate fechaAnterior) {
        if (fecha == null) return false;
        else if (fecha.isAfter(fechaAnterior))
            return true;
        else return false;
    }

    public boolean anteriorA (LocalDate fechaPosterior) {
        if (fecha == null) return false;
        else if (fecha.isBefore(fechaPosterior))
            return true;
        else return false;
    }
}