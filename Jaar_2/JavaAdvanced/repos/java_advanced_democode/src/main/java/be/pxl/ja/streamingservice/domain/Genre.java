package be.pxl.ja.streamingservice.domain;

public enum Genre {

    ACTION("Action"),
    ADVENTURE("Adventure"),
    COMEDY("Comedy"),
    CRIME("Crime & Gangster", "mdi-fingerprint"),
    DRAMA("Drama"),
    DOCUMENTARY("Documentary", "mdi-information-outline"),
    HISTORICAL("Epics / Historical"),
    MUSICAL("Musical / Dance", "mdi-music-box-outline"),
    SF("Science Fiction", "mdi-ufo-outline"),
    WAR("War"),
    WESTERN("Western");

    private static final String DEFAULT_ICON = "mdi-comment-question-outline";

    private final String displayName;
    private final String icon;

    Genre(String displayName, String icon) {
        this.displayName = displayName;
        this.icon = icon;
    }

    Genre(String displayName) {
        this(displayName, DEFAULT_ICON);
    }

    public String getIcon() {
        return icon;
    }

    public String getDisplayName() {
        return displayName;
    }
}