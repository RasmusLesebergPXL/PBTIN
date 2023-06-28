package be.pxl.h1.opdracht9;

import be.pxl.h1.opdracht7.Planet;

import java.util.Scanner;

public class ThermometerApp {
    public static void main(String[] args) {
        Thermometer thermometer = new Thermometer();
        Scanner input = new Scanner(System.in);
        System.out.println("Geef de Temperatuur: ");
        double temperature = input.nextDouble();
        thermometer.setTemperature(temperature);

        System.out.println("De temperatuur in Fahrenheit is: " + thermometer.getFahrenheit());
    }
}
