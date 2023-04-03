package be.pxl.h8.oefextra1;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class test {
    public static void main(String[] args) {
        LocalDate dt = LocalDate.parse("2018-11-01");

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd MMMM yyyy");
        System.out.print(formatter.format(dt));
    }

}
