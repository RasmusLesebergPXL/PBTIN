package be.pxl.h1.opdracht13;

public class SalesPerson {
    private String naam;
    private double[] monthlySales = new double[12];

    public String getNaam() {
        return naam;
    }

    public void setNaam(String naam) {
        this.naam = naam;
    }

    public void setMonthlySale(int month, double amount) {
        if (month >= 1 && month <= 12)
            monthlySales[month - 1] = amount;
    }

    public double getTotalSale() {
        double totalAmount = 0;
        for(int i = 0; i < monthlySales.length; i++) {
            totalAmount += monthlySales[i];
        }
        return totalAmount;
    }

    public double getAverageSale() {
        return getTotalSale()/12;
    }





}
