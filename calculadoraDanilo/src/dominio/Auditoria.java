package dominio;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Auditoria {

    private String accion;
    private String detalle;
    private LocalDateTime fecha;

    public Auditoria(String accion, String detalle){
        this.accion = accion;
        this.detalle = detalle;
        this.fecha = LocalDateTime.now();
    }

    @Override
    public String toString() {
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        return String.format("[%s] ACCIÓN: %-15s | DETALLE: %s",
                fecha.format(fmt), accion, detalle);
    }
}