package be.pxl.h1.opdracht12;

public class CelsiusFahrenheit {
    private double temperature;

    public double getFahrenheit() {
        return (9 / 5.0) * temperature + 32;
    }

    public double getTemperature() {
        return temperature;
    }

    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }
}
