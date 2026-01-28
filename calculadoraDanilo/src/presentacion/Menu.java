package presentacion;

import dominio.*;
import servicio.IServicioCalculadora;
import servicio.ServicioCalculadora;

import java.util.Scanner;

public class Menu {
    //variables locales

    private static final Scanner entrada = new Scanner(System.in);

    // Declaramos la interfaz de implementacion

    private static final IServicioCalculadora calculadora = new ServicioCalculadora();

    public static void main(String[] args) {
        var salir = false;

        try {
            while (!salir) {
                mostrarMenu();
                salir = ejecutarOpciones();
            }
        } catch (Exception e) {
            System.out.println("Error en operación: " + e.getMessage());
        }
    }

    private static void mostrarMenu() {
        System.out.println("""
                1. Operaciones Aritmeticas
                2. Logaritmicas
                3. Trigonometricas
                0. Salir
                """);
        System.out.println("Ingrese una opcion: ");
    }

    private static boolean ejecutarOpciones() {
        int opcion = Integer.parseInt(entrada.nextLine());
        var salir = false;

        switch(opcion){
            case 1 ->{
                menuAritmeticas();
            }
            case 2 ->{
                menuLogaritmicas();
            }
            case 3 ->{
                menuTrigonometricas();
            }
            case 0 -> salir = true;

            default -> {
                System.out.println("Error......");
            }
        }
        return salir;
    }

    //SUB MENU OPERACIONES ARITMETICAS
    private static void menuAritmeticas() {
        var salir = false;

        try {
            while (!salir) {
                System.out.println("""
                        \n========= OPERACIONES ARITMETICAS =========
                            1. Suma
                            2. Resta
                            3. Multiplicación
                            4. División
                            0. Volver al menú principal
                        """);
                System.out.print("Ingrese una opción: ");
                int opcion = Integer.parseInt(entrada.nextLine());

                switch (opcion) {
                    case 1 -> {
                        double[] nums = pedirNumerosArray();
                        Aritmeticas result = new Aritmeticas(nums);
                        System.out.println("Resultado suma: " + calculadora.suma(result));

                    }
                    case 2 -> {
                        double[] nums = pedirNumerosArray();
                        Aritmeticas result = new Aritmeticas(nums);
                        System.out.println("Resultado resta: " + calculadora.resta(result));

                    }
                    case 3 -> {
                        double[] nums = pedirNumerosArray();
                        Aritmeticas result = new Aritmeticas(nums);
                        System.out.println("Resultado multiplicacion: " + calculadora.multi(result));

                    }
                    case 4 -> {
                        System.out.println("\nIngrese numerador:");
                        double a = Double.parseDouble(entrada.nextLine());
                        System.out.println("Ingrese denominador:");
                        double b = Double.parseDouble(entrada.nextLine());

                        System.out.println("Resultado división: " + calculadora.div(a, b));

                    }
                    case 0 -> salir = true;
                    default -> System.out.println("Opción inválida.");
                }
            }
        }   catch (Exception e){
            System.out.println("Error en operación: " + e.getMessage());
        }
    }
    //SUB MENU OPERACIONES LOGARITMICAS

    private static void menuLogaritmicas() {
        var salir = false;

        try {
            while (!salir) {
                System.out.println("""
                        \n========= OPERACIONES LOGARITMICAS =========
                            1. Logaritmo Natural
                            2. Logaritmo Base10
                            0. Volver al menú principal
                        """);
                System.out.print("Ingrese una opción: ");
                int opcion = Integer.parseInt(entrada.nextLine());

                switch (opcion) {
                    case 1 -> {
                        System.out.println("\nIngrese un numero:");
                        double num = Double.parseDouble(entrada.nextLine());
                        Logaritmos resultado = new Logaritmos(num);
                        System.out.println("Resultado: "+calculadora.logNatural(resultado));

                    }
                    case 2 -> {
                        System.out.println("\nIngrese un numero:");
                        double num = Double.parseDouble(entrada.nextLine());
                        Logaritmos resultado = new Logaritmos(num);
                        System.out.println("Resultado: "+calculadora.logBase10(resultado));
                    }

                    case 0 -> salir = true;

                    default -> System.out.println("Opción inválida.");
                }
            }
        }   catch (Exception e){
            System.out.println("Error en operación: " + e.getMessage());
        }
    }

    //SUB MENU OPERACIONES TRIGONOMETRICAS
    private static void menuTrigonometricas() {
        var salir = false;

        try {
            while (!salir) {
                System.out.println("""
                        \n========= OPERACIONES LOGARITMICAS =========
                            1. Seno
                            2. Coseno
                            3. Tangente
                            0. Volver al menú principal
                        """);
                System.out.print("Ingrese una opción: ");
                int opcion = Integer.parseInt(entrada.nextLine());

                switch (opcion) {
                    case 1 -> {
                        System.out.println("\nIngrese un numero:");
                        double num = Double.parseDouble(entrada.nextLine());
                        Trigonometricas resultado = new Trigonometricas(num);
                        System.out.println("Resultado: "+calculadora.cos0(resultado));
                    }
                    case 2 -> {
                        System.out.println("\nIngrese un numero:");
                        double num = Double.parseDouble(entrada.nextLine());
                        Trigonometricas resultado = new Trigonometricas(num);
                        System.out.println("Resultado: "+calculadora.sen0(resultado));
                    }
                    case 3 ->{
                        System.out.println("\nIngrese un numero:");
                        double num = Double.parseDouble(entrada.nextLine());
                        Trigonometricas resultado = new Trigonometricas(num);
                        System.out.println("Resultado: "+calculadora.tan0(resultado));
                    }

                    case 0 -> salir = true;

                    default -> System.out.println("Opción inválida.");
                }
            }
        }   catch (Exception e){
            System.out.println("Error en operación: " + e.getMessage());
        }
    }


    // METODOS AUXILIARES
    private static double[] pedirNumerosArray () {
        System.out.print("Ingrese la cantidad de numeros: ");
        int cant = Integer.parseInt(entrada.nextLine());
        double[] nums = new double[cant];

        for (int i = 0; i < cant; i++) {
            System.out.print("Numero " + (i + 1) + ": ");
            nums[i] = Double.parseDouble(entrada.nextLine());
        }
        return nums;
    }
}