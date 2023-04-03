package be.pxl.rct.rollercoaster;

public interface QueueArea<Q> {
    /**
     * Number of items of type Q that are allowed at the same time in the area.
     * @return the number of items allowed at the same time
     */
    int getAllowed();

    /**
     * The time that the items are allowed in the area.
     * @return the time in milliseconds
     */
    int getTime();

    /**
     * Item Q can enter the area it was in waiting for.
     */
    void enter(Q item);
}
