package be.pxl.h6.opdracht;

public enum Dag {
    MAANDAG("weekdag"),
    DINSDAG("weekdag"),
    WOENSDAG("weekdag"),
    DONDERDAG("weekdag"),
    VRIJDAG("weekdag"),
    ZATERDAG("weekend"),
    ZONDAG("weekend");

    private String dagvanWeek;

    private Dag(String dagvanWeek) {
        this.dagvanWeek = dagvanWeek;
    }

    public String getType() {
        return dagvanWeek;
    }


}
