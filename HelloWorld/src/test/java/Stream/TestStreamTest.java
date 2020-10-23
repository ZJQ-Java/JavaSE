package Stream;

import org.junit.Test;

import java.util.Comparator;
import java.util.List;

public class TestStreamTest {

    @Test
    public void testComparable() {
        List<Student> students = TestStream.students;
        students.forEach(System.out::println);
        System.out.println("-----------------");
        students.sort((o1, o2) -> {
            return o1.getGrade() - o2.getGrade();
        });
        students.forEach(System.out::println);
        System.out.println("-----------------");
        students.sort(Comparator.comparing(Student::getGrade).reversed().thenComparing(Student::getAge).reversed());

        students.forEach(System.out::println);


    }
}