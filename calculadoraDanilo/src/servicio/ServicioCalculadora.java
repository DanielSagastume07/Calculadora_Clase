package servicio;

import dominio.Aritmeticas;
import dominio.Trigonometricas;
import dominio.Logaritmos;

public class ServicioCalculadora implements IServicioCalculadora {

//--------------------OPERACIONES ARITMETICAS--------------------

    @Override
    public double suma(Aritmeticas valor) {
        double suma = 0;
        for (double n : valor.getNums()) {
            suma += n;
        }
        return suma;
    }

    @Override
    public double resta(Aritmeticas valor) {
        double[] nums = valor.getNums();
        if (nums.length == 0) return 0;

        double resta = nums[0];
        for (double n : valor.getNums()) {
            resta -= n;
        }
        return resta;
    }

    @Override
    public double multi(Aritmeticas valor) {
        double[] nums = valor.getNums();
        if (nums.length == 0) return 0;

        double multi = nums[0];
        for (double n : valor.getNums()) {
            multi *= n;
        }
        return multi;
    }

    @Override
    public double div(double num1, double num2) {
        if (num1 == 0) {
            System.out.println("Error: No se puede dividir entre cero.");
            return 0;
        }
        return num1 / num2;
    }

    //--------------------OPERACIONES LOGARITMOS--------------------

    @Override
    public double logNatural(Logaritmos valor) {
        if(valor.getNums() <= 0){
            System.out.println("Error: solo puede ser positivo");
            return 0;
        }
        return Math.log(valor.getNums());
    }

    @Override
    public double logBase10(Logaritmos valor) {
        if(valor.getNums()<= 0){
            System.out.println("Error: solo puede ser positivo");
            return 0;
        }
      return Math.log10(valor.getNums());
    }

        //--------------------OPERACIONES TRIGONOMETRICAS--------------------

    @Override
    public double sen0(Trigonometricas valor) {return Math.sin(valor.Radianes());}

    @Override
    public double cos0(Trigonometricas valor) {
        return Math.cos(valor.Radianes());
    }

    @Override
    public double tan0(Trigonometricas valor) {
        return Math.tan(valor.Radianes());
    }
}
