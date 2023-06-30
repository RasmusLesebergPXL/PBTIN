package be.pxl.rct.engine;


import be.pxl.rct.rollercoaster.RollerCoaster;
import be.pxl.rct.visitor.Visitor;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


public class WaitingLine<T extends Visitor> extends Thread implements Serializable {

    private long waitingTime;
    private RollerCoaster rollerCoaster;
    private final List<T> visitors;
    private boolean waitingLineIsFull;


    public WaitingLine(long waitingTime, RollerCoaster rollerCoaster) {
        this.waitingTime = waitingTime;
        this.rollerCoaster = rollerCoaster;
        this.visitors = new ArrayList<>();
        waitingLineIsFull = false;
    }

    public void addVisitor(T visitor) {
        try {
            setWaitingLineIsFull(visitors.size() >= rollerCoaster.getAllowed());
            visitors.add(visitor);
        }
        catch (IndexOutOfBoundsException e) {
            e.getStackTrace();
        }
    }

    public boolean getWaitingLineIsFull() {
        return waitingLineIsFull;
    }

    public void setWaitingLineIsFull(boolean waitingLineIsFull) {
        this.waitingLineIsFull = waitingLineIsFull;
    }

    public List<T> getVisitors() {
        return visitors;
    }


    @Override
    public synchronized void run() {
        long startTime = System.currentTimeMillis(); //fetch starting time
        long endTime = startTime + waitingTime;

        while (startTime < endTime) {
            //Wanneer een wachtrij wordt gestart kunnen objecten van het type T (straks Visitors) zich in de wachtrij plaatsen.
            //Vervolgens worden het toegelaten aantal items (getAllowed) uit de wachtrij genomen, deze items mogen de
            //QueueArea binnengaan (enter).

            for (int i = 0; i <= rollerCoaster.getAllowed(); i++) {
                while (visitors.size() != 0) {
                    rollerCoaster.enter(getVisitors().get(0));
                    visitors.remove(0);
                }
            }

            //Als het toegelaten aantal items in de QueueArea is binnengegaan, zal de waitingline-thread een poos slapen (getTime)
            try {
                Thread.sleep(rollerCoaster.getTime());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            startTime = System.currentTimeMillis();
            //Daarna worden er weer het toegelaten aantal items uit de wachtrij genomen. Dit proces
            //blijft zich herhalen tot de eindtijd van de WaitingLine is aangebroken.
        }
    }
}
