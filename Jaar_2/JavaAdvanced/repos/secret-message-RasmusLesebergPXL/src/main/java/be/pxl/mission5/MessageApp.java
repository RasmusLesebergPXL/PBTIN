package be.pxl.mission5;

import com.diogonunes.jcolor.Ansi;
import com.diogonunes.jcolor.Attribute;
import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

public class MessageApp {

    public static void main(String[] args) {
        Map<String, Integer> colourMap = colourReader();
        HashSet<Point> points = pointReader();
        if (points != null) {
            System.out.println("Size of HashSet: " + points.size());
            generateMatrix(colourMap, points);
        }
        priorityReader();
    }

    public static Map<String, Integer> colourReader() {
        Path colourPath = Path.of("src", "main", "resources", "color.txt");
        Map<String, Integer> colourMap = new HashMap<>();
        colourMap.put("R", 0);
        colourMap.put("G", 0);
        colourMap.put("B", 0);
        try {
            BufferedReader reader = Files.newBufferedReader(colourPath);

            String line = reader.readLine();
            while (line != null) {
                String[] colourProperties = line.split(" ");
                String key = colourProperties[0];
                int value = Integer.parseInt(colourProperties[1]);

                colourMap.put(key, colourMap.get(key) + value);
                line = reader.readLine();
            }
            reader.close();
            return colourMap;
        } catch (IOException e) {
            e.getStackTrace();
            System.err.println(e.getMessage());
            return null;
        }
    }
    public static HashSet<Point> pointReader() {
        Path pointPath = Path.of("src", "main", "resources", "points.txt");
        HashSet<Point> pointSet = new HashSet<>();
        try {
            BufferedReader reader = Files.newBufferedReader(pointPath);

            String line = reader.readLine();
            while (line != null) {
                ArrayList<String> coordinates = new ArrayList<>(List.of(line.split(",")));
                int x = Integer.parseInt(coordinates.get(0).substring(1));
                int y = Integer.parseInt(coordinates.get(1).substring(0, coordinates.get(1).length() -1 ));
                Point point = new Point(x, y);

                pointSet.add(point);
                line = reader.readLine();
            }
            reader.close();
            return pointSet;
        } catch (IOException e) {
            e.getStackTrace();
            System.err.println(e.getMessage());
            return null;
        }
    }
    public static void priorityReader() {
        Path priority = Path.of("src", "main", "resources", "priority.txt");
        try {
            BufferedReader reader = Files.newBufferedReader(priority);
            String line = reader.readLine();

            ArrayList<Student> students = new ArrayList<>();
            while (line != null) {
                String[] readLine = line.split(" ");
                if (readLine[0].equals("ENTER")) {
                    Student newSTudent = new Student(readLine[1], Double.parseDouble(readLine[2]), Integer.parseInt(readLine[3]));
                    students.add(newSTudent);
                }
                else if (readLine[0].equals("SERVE")) {
                    System.out.println("SERVING:");
                    List<Student> sortedList = PriorityQueue.determinePriority(students);
                    System.out.println(sortedList.get(0).toString());
                    students.remove(sortedList.get(0));
                    sortedList.remove(0);
                }
                line = reader.readLine();
            }
            reader.close();
        } catch (IOException e) {
            e.getStackTrace();
            System.err.println(e.getMessage());
        }

    }
    public static void generateMatrix(Map<String, Integer> colour, HashSet<Point> pointSet) {
        //MAX X
        int maxXCoord = pointSet
                .stream()
                .mapToInt(Point::getX)
                .max()
                .orElse(0);
        //MAX Y
        int maxYCoord = pointSet
                .stream()
                .mapToInt(Point::getY)
                .max()
                .orElse(0);
        //MIN X
        int minXCoord = pointSet
                .stream()
                .mapToInt(Point::getX)
                .min()
                .orElse(0);
        //MIN Y
        int minYCoord = pointSet
                .stream()
                .mapToInt(Point::getY)
                .min()
                .orElse(0);

        for (int i = 0; i <= maxYCoord; i++) {
            for (int j = 0; j <= maxXCoord; j++) {
                Point point = new Point(j, i);
                if (pointSetContainsPoint(pointSet, point)) {
                    Attribute bkgColor = Attribute.BACK_COLOR(colour.get("R"), colour.get("G"), colour.get("B"));
                    System.out.print(Ansi.colorize("   ", bkgColor) + "|");
                }
                else {
                    Attribute white = Attribute.BACK_COLOR(255, 255, 255);
                    System.out.print(Ansi.colorize("   ", white) + "|");
                }
            }
            System.out.println();
        }
    }
    public static boolean pointSetContainsPoint(HashSet<Point> points, Point point) {
        for (Point pointInSet : points) {
            if (pointInSet.equals(point)) {
                return true;
            }
        }
        return false;
    }
}
