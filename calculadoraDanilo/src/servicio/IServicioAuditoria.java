package servicio;

public interface IServicioAuditoria {
    void registrarEvento(String accion, String detalle);
    void mostrarAuditoria();
}
