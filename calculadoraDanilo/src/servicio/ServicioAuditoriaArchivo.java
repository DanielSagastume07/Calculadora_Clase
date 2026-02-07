package servicio;

import dominio.Auditoria;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ServicioAuditoriaArchivo implements IServicioAuditoria{

    private final String NOMBRE_ARCHIVO = "auditoria.txt";

    public ServicioAuditoriaArchivo() {
        var archivo = new File(NOMBRE_ARCHIVO);
        try {
            // Si no existe, lo crea. Si existe, muestra que se cargo.
            if (archivo.exists()) {
                System.out.println("ARCHIVO DE AUDITORIA CARGADO");
            }else{

                var salida = new PrintWriter(new FileWriter(archivo));
                salida.close();

            }
        } catch (IOException e) {
            System.out.println("Error al inicializar archivo de auditoría: " + e.getMessage());
        }
    }

    @Override
    public void registrarEvento(String accion, String detalle) {
        var archivo = new File(NOMBRE_ARCHIVO);
        try {
            // Usamos 'true' en FileWriter para anexar (append) y no borrar lo anterior
            var salida = new PrintWriter(new FileWriter(archivo, true));
            Auditoria log = new Auditoria(accion, detalle);
            salida.println(log.toString());
            salida.close();
        } catch (IOException e) {
            System.out.println("No se pudo escribir en la auditoría: " + e.getMessage());
        }
    }

    @Override
    public void mostrarAuditoria() {
        var archivo = new File(NOMBRE_ARCHIVO);
        try {
            System.out.println("\n========= HISTORIAL DE AUDITORÍA (ARCHIVO) =========");
            var entrada = new BufferedReader(new FileReader(archivo));
            String linea = entrada.readLine();

            if (linea == null) {
                System.out.println("El historial está vacío.");
            }

            while (linea != null) {
                System.out.println(linea);
                linea = entrada.readLine();
            }
            entrada.close();
            System.out.println("====================================================");
        } catch (IOException e) {
            System.out.println("Error al leer la auditoría: " + e.getMessage());
        }
    }

}