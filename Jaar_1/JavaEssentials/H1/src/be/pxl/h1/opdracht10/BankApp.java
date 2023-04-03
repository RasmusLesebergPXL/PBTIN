package be.pxl.h1.opdracht10;

import java.util.Scanner;

public class BankApp {
    public static void main(String[] args) {
        BankAccountNumber bankAccountNumber = new BankAccountNumber();
        bankAccountNumber.setCode("BE");
        bankAccountNumber.setControlDigits(68);
        bankAccountNumber.setNumber(539007547034L);
        System.out.println(bankAccountNumber.getAccount());
        if (bankAccountNumber.isValid()) {
            System.out.println("This bank account number is valid.");
        } else {
            System.out.println("This bank account number is not valid.");
        }
        BankAccountNumber bedragOpRekening = new BankAccountNumber();
        Scanner input = new Scanner(System.in);
        System.out.println("Wat is het startbedrag van de rekening: ");
        double startbedrag = input.nextDouble();
        input.nextLine();
        bedragOpRekening.setAmount(startbedrag);

        System.out.println("Wil je geld afhalen (J/N)?");
        String antwoord = input.nextLine();

        while (antwoord.equals("J") && bedragOpRekening.getAmount() > 0) {
            String output = String.format("Hoeveel geld wil je afhalen (max %s)?", bedragOpRekening.getAmount());
            System.out.println(output);
            double amount = input.nextDouble();
            input.nextLine();
            bedragOpRekening.withdraw(amount);
            System.out.println("Wil je geld afhalen (J/N)?");
            antwoord = input.nextLine();

        }
    }
}
