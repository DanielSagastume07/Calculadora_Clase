package servicio;

import dominio.Aritmeticas;
import dominio.Trigonometricas;
import dominio.Logaritmos;

public interface IServicioCalculadora {

    //Aritmeticas
    double suma(Aritmeticas valor);
    double resta(Aritmeticas valor);
    double multi(Aritmeticas valor);
    double div(double num1, double num2);

    // Logaritmicas
    double logNatural(Logaritmos valor);
    double logBase10(Logaritmos valor);

    // Trigonometricas
    double sen0(Trigonometricas valor);
    double cos0(Trigonometricas valor);
    double tan0(Trigonometricas valor);
}
