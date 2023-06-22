package be.pxl.h1.oef4;

import java.util.Scanner;

public class HotelApp {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Geef het aantal volwassenen: ");
        int volwassenen = input.nextInt();
        input.nextLine();
        System.out.println("Geef het aantal kinderen: ");
        int kinderen = input.nextInt();
        input.nextLine();

        StringBuilder resultaten = new StringBuilder("");
        Hotel hotel = new Hotel();
        System.out.println("Geef een hotelcode: ");
        String hotelcode = input.nextLine();

        while (!hotelcode.equals("/")) {
            while (!hotelcode.matches("[A-Z]+") && !hotelcode.equals("/")) {
                System.out.println("De hotelcode moet een of meer grote chars bevatten, geef de hotelcode opnieuw in: ");
                hotelcode = input.nextLine();
            }
            hotel.setHotelcode(hotelcode);

            System.out.println("Geef het aantal sterren: ");
            int sterren = input.nextInt();
            input.nextLine();
            while (sterren > 5 | sterren < 1) {
                System.out.println("Het aantal sterren moet tussen 1 en 5 zijn, geef opnieuw het aantal sterren: ");
                sterren = input.nextInt();
                input.nextLine();
            }
            hotel.setSterren(sterren);

            System.out.println("Geef de kindercode: ");
            String kindercode = input.nextLine();
            while (!kindercode.matches("[A-Z]+")) {
                System.out.println("De kindercode moet een of meer chars bevatten, geef de kindercode opnieuw in: ");
                kindercode = input.nextLine();
            }
            hotel.setKindercode(kindercode);
            double prijs_totaal = hotel.getPrijs()*volwassenen + hotel.getPrijsKind()*kinderen;
            String hele_hotelcode = hotel.getHotelcode() + hotel.getSterren() + " " + hotel.getPrijs() + " " + hotel.getPrijsKind() + " " + prijs_totaal + "\n";

            resultaten.append(hele_hotelcode);

            hotel = new Hotel();
            System.out.println("Geef een hotelcode: ");
            hotelcode = input.nextLine();
        }
        System.out.print(resultaten);
    }
}

