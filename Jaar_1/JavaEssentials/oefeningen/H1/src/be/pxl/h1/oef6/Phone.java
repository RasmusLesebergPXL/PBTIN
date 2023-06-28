package be.pxl.h1.oef6;

public class Phone {
    private String number;
    private String provider;
    private int numberOfCalls;
    private int numberOfFreeCalls;

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getProvider() {
        return provider;
    }


    public void setProvider(String provider) {
        this.provider = provider;
    }

    public int getNumberOfCalls() {
        return numberOfCalls;
    }

    public void setNumberOfCalls(int numberOfCalls) {
        this.numberOfCalls = numberOfCalls;
    }

    public int getNumberOfFreeCalls() {
        return numberOfFreeCalls;
    }

    public void setNumberOfFreeCalls(int numberOfFreeCalls) {
        this.numberOfFreeCalls = numberOfFreeCalls;
    }

    public String getCall(String number) {
        return number;
    }

    public double getCost() {
        double call_cost = 0;
        if (getCall(number).equals("112") | getCall(number).equals("102") | getCall(number).equals("070245245")) {
            setNumberOfFreeCalls(+1);
        } else if (getProvider().equals("Floximus")) {
            call_cost = 0.25;
        } else {
            call_cost = 0.21;
        }
        setNumberOfCalls(+1);
        return call_cost;
    }

    public double reset() {
        return 0;
    }


}

