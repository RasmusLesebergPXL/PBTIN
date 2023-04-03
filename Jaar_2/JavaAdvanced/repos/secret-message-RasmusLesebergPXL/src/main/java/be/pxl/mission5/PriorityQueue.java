package be.pxl.mission5;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class PriorityQueue {
    public static List<Student> determinePriority(ArrayList<Student> studentList) {

        Comparator<Student> comparator = Comparator.comparing(Student::getScore).reversed();
        comparator = comparator.thenComparing(Student::getName);
        comparator = comparator.thenComparing(Student::getToken);

        return studentList
                .stream()
                .sorted(comparator)
                .collect(Collectors.toList());
    }
}
