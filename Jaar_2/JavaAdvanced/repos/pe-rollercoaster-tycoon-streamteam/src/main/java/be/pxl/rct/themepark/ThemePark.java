package be.pxl.rct.themepark;

import be.pxl.rct.exceptions.ThemeParkException;
import be.pxl.rct.rollercoaster.RollerCoaster;
import be.pxl.rct.rollercoaster.RollerCoasterType;
import be.pxl.rct.shop.Shop;
import be.pxl.rct.visitor.Visitor;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class ThemePark implements Serializable {

    private String name;
    private double cash;
    private int daysOpen;
    private double dayTimeDuration;
    private double entranceFee;
    private List<RollerCoaster> rollerCoasters;
    private static ArrayList<RollerCoasterType> rollerCoasterTypes;
    private List<Shop> shops;
    private List<Visitor> dailyVisitors;
    private List<Visitor> totalVisitors;


    public ThemePark(String name, ArrayList<RollerCoasterType> rollerCoasterTypes) {
        this.name = name;
        ThemePark.rollerCoasterTypes = rollerCoasterTypes;
        this.daysOpen = 0;
        this.rollerCoasters = new ArrayList<>();
        this.shops =  new ArrayList<>();
        this.dailyVisitors = new ArrayList<>();
        this.totalVisitors = new ArrayList<>();
    }

    public int getDaysOpen() {
        return daysOpen;
    }

    public void setDaysOpen(int daysOpen) {
        this.daysOpen = daysOpen;
    }

    public List<RollerCoaster> getRollerCoasters() {
        return rollerCoasters;
    }

    public static void setRollerCoasterTypes(ArrayList<RollerCoasterType> rollerCoasterTypes) {
        ThemePark.rollerCoasterTypes = rollerCoasterTypes;
    }

    public List<Shop> getShops() {
        return shops;
    }

    public void setDailyVisitors(List<Visitor> dailyVisitors) {
        this.dailyVisitors = dailyVisitors;
    }

    public List<Visitor> getDailyVisitors() {
        return dailyVisitors;
    }

    public List<Visitor> getTotalVisitors() {
        return totalVisitors;
    }

    public void setName(String name) {
        this.name = name;
    }

    public synchronized double getEntranceFee() {
        return entranceFee;
    }

    public void setEntranceFee(double entranceFee) {
        this.entranceFee = entranceFee;
    }

    public String getName() {
        return name;
    }

    public double getCash() {
        return cash;
    }

    public void setCash(double amount) {
        this.cash = amount;
    }

    public double getDayTimeDuration() {
        return dayTimeDuration;
    }

    public void setDayTimeDuration(double amount) {
        this.dayTimeDuration = amount;
    }


    public void addRollercoaster(RollerCoaster newRollerCoaster){
        try {
            for (RollerCoaster rollerCoaster : rollerCoasters) {
                if (rollerCoaster.getName().equalsIgnoreCase(newRollerCoaster.getName())) {
                    throw new ThemeParkException("That rollercoaster name already exists");
                }
            }
            if (subtractCash(newRollerCoaster.getAttractionType().getCost())) {
                rollerCoasters.add(newRollerCoaster);
                setCash(cash - newRollerCoaster.getAttractionType().getCost());
            }
        }
        catch (ThemeParkException e) {
            e.getStackTrace();
            System.out.println(e.getMessage());
        }
    }


    public void addShop(Shop newShop){
        try {
            for (Shop shop : shops) {
                if (shop.getShopName().equalsIgnoreCase(newShop.getShopName())) {
                    throw new ThemeParkException("That shop name already exists");
                }
            }
            if (subtractCash(newShop.getShopType().getCost())) {
                shops.add(newShop);
                setCash(cash - newShop.getShopType().getCost());
            }
        }
        catch (ThemeParkException e) {
            e.getStackTrace();
            System.out.println(e.getMessage());
        }
    }


    public void addVisitor(Visitor visitor) {
        dailyVisitors.add(visitor);
        totalVisitors.add(visitor);
    }


    public boolean subtractCash(double amount) {
        try {
            if (cash - amount < 0) {
                throw new ThemeParkException("You cannot buy this rollercoaster, you don't have enough cash");
            } else return true;
        }
        catch (ThemeParkException e) {
            e.getStackTrace();
            System.out.println(e.getMessage());
        }
        return false;
    }


    public static RollerCoasterType mapToType(int id) {
        try {
            for (RollerCoasterType type : rollerCoasterTypes) {
                if (type.getId() == id) {
                    return type;
                }
            }
        }
        catch (NullPointerException e) {
            e.getStackTrace();
        }
        return null;
    }


    public void addCash(double amount) {
        cash += amount;
    }
}
