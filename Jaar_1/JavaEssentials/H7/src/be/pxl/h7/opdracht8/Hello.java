package be.pxl.h7.opdracht8;

public class Hello {
    public static void main(String[] args) {
        String[][] words = {{"How ", "What’s ", "Let "},
                            {"are ", "your ", "me "},
                            {"you?", "name?", "try."}};


        for (int i = 0; i < words[0].length; i++) {
            for (String[] string : words) {
                System.out.print(string[i]);
            }
            System.out.println();
        }
    }
}

