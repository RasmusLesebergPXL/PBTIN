package be.pxl.h2.oef3;

import java.util.ArrayList;
import java.util.Arrays;

public class Character {
    private static int count;
    private final static int MAX_TITLES = 3;
    private String firstName;
    private String lastName;
    private String nickName;
    private String house;
    private int firstSeason;
    private int lastSeason;
    private int episodes;
    private String portrayedBy;
    private int numberOfTitles;
    private String[] titles = new String[MAX_TITLES];

    public Character(String firstName, String lastName, String house, String portrayedBy) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.house = house;
        this.portrayedBy = portrayedBy;
        count++;
    }

    public Character(String firstName, String lastName, String nickName, String house, String portrayedBy) {
        this(firstName, lastName, house, portrayedBy);
        this.nickName = nickName;
    }

    public Character(String firstName, String lastName, String nickName, String house, int firstSeason, int lastSeason, int episodes, String portrayedBy) {
        this(firstName, lastName, nickName, house, portrayedBy);
        this.firstSeason = firstSeason;
        this.lastSeason = lastSeason;
        this.episodes = episodes;
    }

    public static int getCount() {
        return count;
    }

    public void setData(int firstSeason, int lastSeason, int episodes) {
        this.firstSeason = firstSeason;
        this.lastSeason = lastSeason;
        this.episodes = episodes;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public void addTitle(String title) {
        ArrayList<String> titleList = new ArrayList<>(Arrays.asList(titles));
        int indexPositie = 0;
        for (String element : titleList) {
            if (element == null) {
                indexPositie = titleList.indexOf(element);
            }
        }
        titles[indexPositie] = title;
    }

    public String toString() {
        StringBuilder builder = new StringBuilder();
        if (nickName != null) {
            builder.append(String.format("%s %s %s of house %s", firstName, nickName, lastName, house));
        } else {
            builder.append(String.format("%s %s of house %s", firstName, lastName, house));
        }
        for (String elementen : titles) {
            builder.append("*** ").append(elementen);
            builder.append(System.lineSeparator());
        }
        if (firstSeason != 0 && lastSeason != 0) {
            builder.append(String.format("Played by: %s in season %d - %d (%d episodes)%n", portrayedBy, firstSeason, lastSeason, episodes));
        } else {
            builder.append(String.format("Portrayed by: %s", portrayedBy));
        }
        return builder.toString();
    }

//    Niet blij met de null check bij toString, maar het werkt voor deze aangemaakte Chars.
//    Ook waarom bestaat de setData method en de setNickname method, als ik die informatie met de derde of tweede Char class kan toevoegen?
}
