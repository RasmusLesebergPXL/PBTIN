package be.pxl.h1.oef4;

public class Hotel {
    private String hotelcode;
    private int sterren;
    private String kindercode;

    public String getHotelcode() {
        return hotelcode;
    }

    public void setHotelcode(String hotelcode) {
        this.hotelcode = hotelcode;
    }

    public String getSterren() {
        if (sterren == 1) {
            return "    *";
        } else if (sterren == 2) {
            return "   **";
        } else if (sterren == 3) {
            return "  ***";
        } else if (sterren == 4) {
            return " ****";
        } else {
            return "*****";
        }
    }

    public void setSterren(int sterren) {
        this.sterren = sterren;    }

    public String getKindercode() {
        return kindercode;
    }

    public void setKindercode(String kindercode) {
        this.kindercode = kindercode;
    }

    public double getPrijs() {
        int basisprijs;
        if (sterren == 4 || sterren == 5) {
            basisprijs = 60;
        } else if (sterren == 3) {
            if (getHotelcode().equals("BR") || getHotelcode().equals("AN")) {
                basisprijs = 60;
            } else {
                basisprijs = 56;
            }
        } else {
            basisprijs = 48;
        }
        if (getHotelcode().equals("HI")) {
            basisprijs = 70;
        }
        return basisprijs;
    }

    public double getPrijsKind() {
        int kindprijs;
        if ((getKindercode().equals("A") || getKindercode().equals("HA")) && (sterren == 1 || sterren == 2)) {
            kindprijs = 0;
        } else {
            kindprijs = (int) (getPrijs() * 0.5);
        }
        return kindprijs;
}
}
//Vraag1: is er een makkelijkere manier om de * proces te doen
