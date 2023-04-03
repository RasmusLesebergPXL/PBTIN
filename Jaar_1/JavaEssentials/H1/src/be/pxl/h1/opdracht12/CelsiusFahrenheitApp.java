package be.pxl.h1.opdracht12;

import be.pxl.h1.opdracht9.Thermometer;

public class CelsiusFahrenheitApp {
    public static void main(String[] args) {
        Thermometer thermometer = new Thermometer();
        System.out.printf("|%10s|%10s|%n", "Celsius", "Fahrenheit");
        for (int i = -10; i <= 25; i += 5) {
            thermometer.setTemperature(i);
            System.out.printf("|%10.2f|%10.2f|%n", thermometer.getTemperature(), thermometer.getFahrenheit());
        }
    }
}
