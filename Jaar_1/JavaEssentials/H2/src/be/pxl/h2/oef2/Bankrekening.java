package be.pxl.h2.oef2;

public class Bankrekening {
    private String rekeningnummer;
    private String naam;
    private double saldo;
    private double rentepercentage;

    public Bankrekening(String rekeningnummer, String naam, double saldo, double rentepercentage) {
        this.rekeningnummer = rekeningnummer;
        this.naam = naam;
        if (saldo < 0) {
            saldo = 0;
        }
        if (rentepercentage < 0) {
            rentepercentage = 0;
        }
        this.saldo = saldo;
        this.rentepercentage = rentepercentage;

    }

    public Bankrekening() {
        this("geen", "onbekend", 0, 0.012);
    }

    public void setNaam(String naam) {
        this.naam = naam;
    }

    public void setRekeningnummer(String rekeningnummer) {
        this.rekeningnummer = rekeningnummer;
    }

    public double getSaldo() {
        return saldo;
    }

    public void stort(double bedrag) {
        saldo += bedrag;
    }

    public void neemOp(double bedrag) {
        if (saldo - bedrag < 0) {
            System.out.println("U mag enkel " + saldo + " opnemen");
            saldo = 0;
        } else if (saldo == 0) {
            System.out.println("u kunt geen geld meer opnemen");
        }
        saldo -= bedrag;
    }

    public void doeVerrichting() {
//        stort();
//        neemOp();
//        Array
    }

    public double getRentepercentage() {
        return rentepercentage;
    }

    public void schrijfRenteBij() {
        saldo += getSaldo() * getRentepercentage();
    }

    public boolean valideerRekening() {
        return rekeningnummer != null && naam != null;
    }

    public void print() {
        System.out.printf("Saldo op spaarrekening %s op naam van %s bedraagt %.2f\n", getRekeningnummer(), getNaam(), getSaldo());
    }

    public String getRekeningnummer() {
        return rekeningnummer;
    }

    public String getNaam() {
        return naam;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public void setRentepercentage(double rentepercentage) {
        this.rentepercentage = rentepercentage;
    }
}
