package be.pxl.h1.opdracht10;

public class BankAccountNumber {
    private String name;
    private String code;
    private int controldigits;
    private long cardnumber;
    private double amount;


    public void setAmount(double amount) {
        this.amount = amount;
    }

    public double getAmount() {
        return amount;
    }

    public void withdraw(double amount) {
        if (this.amount >= amount) {
            this.amount -= amount;
        } else {
            System.out.println("Het bedrag is niet beschikbaar");
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public int getControlDigits() {
        return controldigits;
    }

    public void setControlDigits(int controldigits) {
        this.controldigits = controldigits;
    }

    public long getNumber() {
        return cardnumber;
    }

    public void setNumber(long cardnumber) {
        this.cardnumber = cardnumber;
    }

    public String getAccount() {
        return (code + controldigits + cardnumber);
    }

    public boolean isValid() {
        long control = (cardnumber * 1000000 + 111400) % 97;
        return (98 - control == controldigits);
    }
}
