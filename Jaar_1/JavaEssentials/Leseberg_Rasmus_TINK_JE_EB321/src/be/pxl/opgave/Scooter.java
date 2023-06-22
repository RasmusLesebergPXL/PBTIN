package be.pxl.opgave;
//Rasmus Leseberg TINK

public class Scooter extends Voertuig {
    private String nummerRijbewijs;

    public Scooter(String nummerRijbewijs) {
        this.nummerRijbewijs = nummerRijbewijs;
    }

    public String getNummerRijbewijs() {
        return nummerRijbewijs;
    }
}
