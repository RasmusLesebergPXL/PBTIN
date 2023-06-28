package be.pxl.h5.opdracht1;

public class Lector extends Persoon{
    private double salaris;
    private double percentage;
    private String diploma;
    public static final int MAX_PERCENTAGE = 100;
    public static final int MIN_PERCENTAGE = 0;

    public double getSalaris() {
        return salaris;
    }

    public void setSalaris(double salaris) {
        this.salaris = salaris;
    }

    public double getPercentage() {
        return percentage;
    }

    public String getDiploma() {
        return diploma;
    }

    public void setDiploma(String diploma) {
        this.diploma = diploma;
    }

    public void setPercentage(double percentage) {
        if (percentage < MIN_PERCENTAGE ) {
            percentage = MIN_PERCENTAGE;
        } else if (percentage > MAX_PERCENTAGE) {
            percentage = MAX_PERCENTAGE;
        }
        this.percentage = percentage;
    }

    @Override
    public void print () {
        super.print();
        System.out.println("salaris:" + salaris + "\n");
        System.out.println("percentage:" + percentage + "\n");
        System.out.println("diploma:" + diploma + "\n");    }
    }

