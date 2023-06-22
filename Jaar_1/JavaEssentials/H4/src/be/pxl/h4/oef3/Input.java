package be.pxl.h4.oef3;

import java.util.Scanner;

public class Input {
    private static Scanner scanner;

    public static Scanner getScanner() {
        if (scanner == null) {
            scanner = new Scanner(System.in);
        }
        return scanner;
    }

    public static String readLine(){
        Scanner input = getScanner();
        return input.nextLine();
    }

    public static String readLine(String message){
        System.out.println(message);
        return readLine();
    }

    public static int readInt(){
        Scanner input = getScanner();
        return input.nextInt();

    }


    public static int readInt(String message){
        System.out.println(message);
        return readInt();
    }

    public static double readDouble(){
        Scanner input = getScanner();
        return input.nextDouble();

    }

    public static double readDouble(String message){
        System.out.println(message);
        return readDouble();
    }
}
