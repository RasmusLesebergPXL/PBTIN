package be.pxl.h1.oef6;

public class PhoneApp {
    public static void main(String[] args) {
        Phone phone1 = new Phone();
        Phone phone2 = new Phone();
        phone1.setProvider("Floximus");
        phone2.setProvider("Youfone");

        double totale_cost = 0;
        for(int i = 10; i<=30; i++) {
            System.out.println("Calling 0121234" + i);
            phone1.setNumber("0121234" + i);
            phone1.setNumberOfCalls(i);
            totale_cost += phone1.getCost();
        }
        System.out.println("Calling 070245245");
        phone1.setNumber("070245245");
        totale_cost += phone1.getCost();
        phone1.setNumberOfCalls(+1);

        if (phone1.getProvider().equals("Floximus") && totale_cost > 5 ) { //Dit werkt niet helemaal juist, gaat altijd naar else
            totale_cost -= totale_cost * 0.05;
            System.out.printf("Phone cost: %.2f %n", totale_cost);
        } else {
            System.out.println("Phone cost: " + totale_cost);
        }
        System.out.printf("Phone cost after reset: %.2f Euro ", phone1.reset());

    }

    }


