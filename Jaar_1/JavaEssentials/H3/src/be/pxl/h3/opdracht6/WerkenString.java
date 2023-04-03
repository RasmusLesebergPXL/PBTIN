package be.pxl.h3.opdracht6;

public class WerkenString {
    public static void main(String[] args) {

        char geval_e = 'e';
        int count_e = 0;
        String tekst = "Dit is en redelijk korte zin, en er zijn geen lange onangename worden in te vinden";
        for (int i = 0; i < tekst.length(); i++) {
            if (tekst.charAt(i) == geval_e) {
                count_e++;
            }
        }
        System.out.println(tekst.length());

        String new_String = tekst.replace('a', 'o');
        System.out.println(new_String);

        System.out.println(count_e);

        if (new_String.equals(tekst)) {
            System.out.println("De strings zijn gelijk");
        } else {
            System.out.println("De strings zijn niet gelijk");
        }

    }
}
