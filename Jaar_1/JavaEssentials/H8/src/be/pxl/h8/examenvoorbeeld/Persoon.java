package be.pxl.h8.examenvoorbeeld;
/* naam: Rasmus */

import java.util.ArrayList;
import java.util.Objects;

public abstract class Persoon {
    private String id;
    private String naam;

    public Persoon(String id, String naam) {
        ArrayList<Character> chars = new ArrayList<>();
        for (Character objecten : id.toCharArray()) {
            chars.add(objecten);
        }
        for (Character object : chars) {
            if (!(Character.isLetter(object) || Character.isDigit(object))) {
                chars.remove(object);
            }
        }
        StringBuilder builder = new StringBuilder();
        for (Character object : chars) {
            builder.append(object);
        }
        if (builder.length() > 3) {
            this.id = builder.toString().toUpperCase().substring(0, 3);
        } else {
            this.id = builder.toString().toUpperCase();
        }
        this.naam = naam;
    }

    public String getId() {
        return id;
    }

    public String getNaam() {
        return naam;
    }

    public int hashcode() {
        return id.hashCode();
    }

    @Override
    public String toString() {
        return String.format("[%s] %s", getId(), getNaam());
    }

    public boolean equals(Object object) {
        return (object instanceof Persoon && !Objects.equals(((Persoon) object).getId(), this.id));
    }
}

