package be.pxl.mission5;

public class Student {
    private String  name;
    private double score;
    private int token;

    public Student(String name, double score, int token) {
        this.name = name;
        this.score = score;
        this.token = token;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    public int getToken() {
        return token;
    }

    public void setToken(int token) {
        this.token = token;
    }

    @Override
    public String toString() {
        return "Name: " + name + " Score: " + score + " Token: " + token;
    }
}
