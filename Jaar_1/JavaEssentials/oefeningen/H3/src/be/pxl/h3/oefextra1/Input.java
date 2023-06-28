package be.pxl.h3.oefextra1;

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
}
