package be.pxl.rct.visitor;


import be.pxl.rct.rollercoaster.RollerCoaster;
import be.pxl.rct.shop.ItemType;
import be.pxl.rct.shop.Shop;
import be.pxl.rct.themepark.ThemePark;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class Visitor extends Thread {
    private int age;
    private String firstname;
    private double cashAvailable = 100;
    private double cashSpent;
    private boolean hungry = false;
    private boolean thirsty = false;
    private boolean inWaitingLine = false;
    private int numberOfRides;
    private double timeSpentInThemePark;
    private int happinessLevel = 100;
    private static final Random RANDOM = new Random();
    private ThemePark themePark;


    public Visitor(String name, ThemePark themePark) {
        this.firstname = name;
        this.themePark = themePark;
        //2% kans op honger of dorst
        boolean visitorIsHungryOrThirsty = RANDOM.nextInt(50) == 0;
        if (visitorIsHungryOrThirsty) {
            if (RANDOM.nextInt(2) == 0) {
                setThirsty(true);
            } else {
                setHungry(true);
            }
        }
        cashAvailable -= themePark.getEntranceFee();
        cashSpent += themePark.getEntranceFee();
        themePark.addCash(themePark.getEntranceFee());
        themePark.addVisitor(this);
    }

    public int getAge() {
        return age;
    }

    public boolean isHungry() {
        return hungry;
    }

    public void setHungry(boolean hungry) {
        this.hungry = hungry;
    }

    public boolean isThirsty() {
        return thirsty;
    }

    public void setThirsty(boolean thirsty) {
        this.thirsty = thirsty;
    }

    public boolean isInWaitingLine() {
        return inWaitingLine;
    }

    public void setInWaitingLine(boolean inWaitingLine) {
        this.inWaitingLine = inWaitingLine;
    }

    public int getNumberOfRides() {
        return numberOfRides;
    }

    public void setNumberOfRides(int numberOfRides) {
        this.numberOfRides = numberOfRides;
    }

    public double getCashAvailable() {
        return cashAvailable;
    }

    public synchronized double getCashSpent() {
        return cashSpent;
    }

    public synchronized String getFirstname() {
        return firstname;
    }

    public synchronized double getTimeSpentInThemePark() {
        return timeSpentInThemePark;
    }

    public synchronized void setTimeSpentInThemePark(double timeSpentInThemePark) {
        this.timeSpentInThemePark = timeSpentInThemePark;
    }

    public synchronized int getHappinessLevel() {
        return happinessLevel;
    }

    public synchronized void setHappinessLevel(int happinessLevel) {
        this.happinessLevel = happinessLevel;
    }

    public boolean hasEnoughCash(double amount) {
        return getCashAvailable() - amount >= 0;
    }

    @Override
    public synchronized void run() {
        long startVisit = System.currentTimeMillis();
        long startTime = System.currentTimeMillis();
        long endTime = (long) (startTime + themePark.getDayTimeDuration());

        while (startTime < endTime) {

////        Als de bezoeker in de wachtrij van een rollercoaster -> happiness -2 (indien honger of dorstig -5 (in totaal?)
            if (isInWaitingLine()) {
                if (isHungry() || isThirsty()) {
                    happinessLevel -= 5;
                }
                happinessLevel -= 2;
            }
//          Als de bezoeker niet in een wachtrij, dan wordt max. 1 van onderstaande acties uitgevoerd:
            else {
//              A. de bezoeker is hongerig -> kies willekeurig een shop met food en koop iets (happiness +15)*
                if (isHungry()) {
                    List<Shop> foodShops = themePark.getShops()
                            .stream()
                            .filter(t -> t.getShopType().getItemType() == ItemType.FOOD)
                            .collect(Collectors.toList());
                    if (foodShops.size() != 0) {
                        Shop foodTypeShop = foodShops.get(RANDOM.nextInt(foodShops.size()));
                        double pricePerItem = foodTypeShop.getShopType().getPricePerItem();
                        if (hasEnoughCash(pricePerItem)) {
                            cashAvailable -= pricePerItem;
                            cashSpent += pricePerItem;
                            themePark.addCash(foodTypeShop.getShopType().getProfitPerItem());
                            setHungry(false);
                            happinessLevel += 15;
                        }
                    }
//              *Als de bezoeker het bedrag niet kon betalen, zal hij uiteraard hongerig en/of dorstig blijven en zal zijn happiness niet verhogen.
                }
//              B. de bezoeker is dorstig -> kies willekeurig een shop met drank en koop iets (happiness +10)*
                else if (isThirsty()) {
                    List<Shop> drinkShops = themePark.getShops()
                            .stream()
                            .filter(t -> t.getShopType().getItemType() == ItemType.DRINKS)
                            .collect(Collectors.toList());

                    if (drinkShops.size() != 0) {
                        Shop drinkTypeShop = drinkShops.get(RANDOM.nextInt(drinkShops.size()));
                        double pricePerItem = drinkTypeShop.getShopType().getPricePerItem();
                        if (hasEnoughCash(pricePerItem)) {
                            cashAvailable -= pricePerItem;
                            cashSpent += pricePerItem;
                            themePark.addCash(drinkTypeShop.getShopType().getProfitPerItem());
                            setThirsty(false);
                            happinessLevel += 10;
                        }
                    }
//              *Als de bezoeker het bedrag niet kon betalen, zal hij uiteraard hongerig en/of dorstig blijven en zal zijn happiness niet verhogen.
                } else {
//                  C. kies een random rollercoaster en ga in de wachtrij staan
                    if (themePark.getRollerCoasters().size() != 0) {
                        for (RollerCoaster rollercoaster : themePark.getRollerCoasters()) {
                            if (!rollercoaster.getWaitingLine().getWaitingLineIsFull()) {
                                rollercoaster.getWaitingLine().addVisitor(this);
                            }
                            else {
                                RollerCoaster randomRollercoaster = themePark.getRollerCoasters().get(RANDOM.nextInt(themePark.getRollerCoasters().size()));
                                randomRollercoaster.getWaitingLine().addVisitor(this);
                            }
                            setInWaitingLine(true);
                        }
                    }
                }
            }
//          Stap 3: sleep 200 ms
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
//            Stap 4: willekeurig bezoeker uit het park smijten
                if(RANDOM.nextInt(30) == 0) {
                    break;
                }
            startTime = System.currentTimeMillis();
        }
        long endVisit = System.currentTimeMillis();
        long timeSpentInThemePark = endVisit - startVisit;
        setTimeSpentInThemePark(timeSpentInThemePark);
    }
}