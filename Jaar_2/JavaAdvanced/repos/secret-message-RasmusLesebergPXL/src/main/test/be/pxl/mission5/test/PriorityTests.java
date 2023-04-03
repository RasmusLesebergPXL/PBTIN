package be.pxl.mission5.test;

import be.pxl.mission5.PriorityQueue;
import be.pxl.mission5.Student;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class PriorityTests {

    private ArrayList<Student> students;
    @BeforeEach
    void  SetUp() {
        ArrayList<Student> students = new ArrayList<>();

        Student student1 = new Student("John", 3.75, 50);
        Student student2 = new Student("Mark", 3.8, 24);
        Student student3 = new Student("Shafaet", 3.7, 35);

        students.add(student1);
        students.add(student2);
        students.add(student3);

        this.students = students;
    }
    @Test
    void should_sort_according_to_score() {
        List<Student> sorted = PriorityQueue.determinePriority(students);
        Assertions.assertEquals(sorted.get(0), students.get(1));
        Assertions.assertEquals(sorted.get(1), students.get(0));
        Assertions.assertEquals(sorted.get(2), students.get(2));
    }

    @Test
    void should_sort_according_to_name_after_score() {
        Student student4 = new Student("Ashley", 3.95, 42);
        Student student5 = new Student("Anik", 3.95, 50);
        students.add(student4);
        students.add(student5);

        List<Student> sorted = PriorityQueue.determinePriority(students);
        Assertions.assertEquals(sorted.get(0), students.get(4));
        Assertions.assertEquals(sorted.get(1), students.get(3));
        Assertions.assertEquals(sorted.get(2), students.get(1));
        Assertions.assertEquals(sorted.get(3), students.get(0));
        Assertions.assertEquals(sorted.get(4), students.get(2));

    }

    @Test
    void should_sort_on_token_after_score_and_name() {
        Student student4 = new Student("John", 3.75, 49);
        Student student5 = new Student("John", 3.75, 1);
        students.add(student4);
        students.add(student5);

        List<Student> sorted = PriorityQueue.determinePriority(students);
        Assertions.assertEquals(sorted.get(0), students.get(1));
        Assertions.assertEquals(sorted.get(1), students.get(4));
        Assertions.assertEquals(sorted.get(2), students.get(3));
        Assertions.assertEquals(sorted.get(3), students.get(0));
        Assertions.assertEquals(sorted.get(4), students.get(2));
    }
}
