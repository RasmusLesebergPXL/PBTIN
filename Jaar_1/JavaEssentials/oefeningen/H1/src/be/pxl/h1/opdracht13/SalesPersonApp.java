package be.pxl.h1.opdracht13;

public class SalesPersonApp {
    public static void main(String[] args) {
        SalesPerson person1 = new SalesPerson();
        person1.setNaam("Jan");
        person1.setMonthlySale(1, 23873);
        person1.setMonthlySale(2, 436334);
        person1.setMonthlySale(3, 23763);
        person1.setMonthlySale(4, 23093);
        person1.setMonthlySale(5, 23844);
        person1.setMonthlySale(6, 23873);
        person1.setMonthlySale(7, 4783472);
        person1.setMonthlySale(8, 239839);
        person1.setMonthlySale(9, 484433);
        person1.setMonthlySale(10, 23983);
        person1.setMonthlySale(11, 239023);
        person1.setMonthlySale(12, 237843);

        System.out.println(person1.getTotalSale());
        System.out.println(person1.getAverageSale());


    }

    }

