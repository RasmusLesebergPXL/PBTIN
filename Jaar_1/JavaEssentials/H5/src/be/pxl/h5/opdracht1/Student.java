package be.pxl.h5.opdracht1;
//Persoon is superclasse
public class Student extends Persoon { //afgeleide klasse
    private static int aantal;
    private int leerkrediet = MAX_LEERKREDIET;
    private int studentennummer;
    private String opleiding;
    public static final int MAX_LEERKREDIET = 140;
    public static final int MIN_LEERKREDIET = 0;


    public int getLeerkrediet() {
        return leerkrediet;
    }

    public void setLeerkrediet(int leerkrediet) {
        if (leerkrediet < MIN_LEERKREDIET ) {
            leerkrediet = MIN_LEERKREDIET;
        } else if (leerkrediet > MAX_LEERKREDIET) {
            leerkrediet = MAX_LEERKREDIET;
        }
        this.leerkrediet = leerkrediet;
    }

    public void wijzigleerkrediet(int wijziging) {
        int nieuweLeerkrediet = getLeerkrediet() + wijziging;
        setLeerkrediet(nieuweLeerkrediet);
    }

    //bij public Student constructor met super: aantal ++

    @Override
    public void print() {
        super.print();
        System.out.println("studentnummer:" + studentennummer + "\n");
        System.out.println("leerkrediet:" + leerkrediet + "\n");
        System.out.println("opleiding:" + opleiding + "\n");    }

    public int getStudentennummer() {
        return studentennummer;
    }

    public void setStudentennummer(int studentennummer) {
        this.studentennummer = studentennummer;
    }

    public String getOpleiding() {
        return opleiding;
    }

    public void setOpleiding(String opleiding) {
        this.opleiding = opleiding;
    }

    public static int getAantal() {
        return aantal;
    }

}

