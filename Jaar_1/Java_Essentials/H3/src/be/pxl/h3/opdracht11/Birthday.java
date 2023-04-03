package be.pxl.h3.opdracht11;

import java.time.LocalDate;

public class Birthday {
    public static void main(String[] args) {
        LocalDate birthday = LocalDate.of(1995, 7, 4);
        System.out.println("Rasmus was born on: " + birthday);
        System.out.println("Day " + birthday.getDayOfYear() + " of the year " + birthday.getYear());
        System.out.println("It was a " + birthday.getDayOfWeek());

        String answer ="";
        if (birthday.isLeapYear()) {
            answer = "Yes";
        } else {
            answer = "No...";
        }

        System.out.println("Was it a leap year? " + answer );

    }
}
