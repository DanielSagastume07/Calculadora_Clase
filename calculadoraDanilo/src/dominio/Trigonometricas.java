package dominio;

public class Trigonometricas {
    private double grados;

    public Trigonometricas() {}

    public Trigonometricas(double grados){
        this.grados = grados;
    }

    public double getGrados() {
        return grados;
    }

    public void setGrados(double grados) {
        this.grados = grados;
    }

    public double Radianes(){
        return Math.toRadians(grados);
    }
}
