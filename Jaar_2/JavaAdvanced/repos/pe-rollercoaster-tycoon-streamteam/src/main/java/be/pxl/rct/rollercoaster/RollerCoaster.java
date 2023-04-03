package be.pxl.rct.rollercoaster;

import be.pxl.rct.engine.WaitingLine;
import be.pxl.rct.themepark.ThemePark;
import be.pxl.rct.visitor.Visitor;
import java.io.Serializable;

public class RollerCoaster implements QueueArea<Visitor>, Serializable {

    private final String name;
    private final RollerCoasterType attractionType;
    private WaitingLine<Visitor> waitingLine;

    public RollerCoaster(int id, String name) {
        this.name = name;
        this.attractionType = ThemePark.mapToType(id);
    }

    public String getName() {
        return name;
    }

    public RollerCoasterType getAttractionType() {
        return attractionType;
    }

    public void setWaitingLine(WaitingLine<Visitor> waitingLine) {
        this.waitingLine = waitingLine;
    }

    public WaitingLine<Visitor> getWaitingLine() {
        return waitingLine;
    }

    @Override
    public int getAllowed() {
        return this.attractionType.getPassengers();
    }

    @Override
    public int getTime() {
        return this.attractionType.getRunningTime();
    }

    @Override
    public synchronized void enter(Visitor visitor) {
        if (visitor != null) {
            visitor.setHappinessLevel(visitor.getHappinessLevel() + 15);
            visitor.setNumberOfRides(visitor.getNumberOfRides() + 1);
            visitor.setInWaitingLine(false);
        }
    }

    @Override
    public String toString() {
        return "* " +
                getName() + " [" +
                attractionType.getType() + ", " + attractionType.getGenre() + "]";
    }
}
