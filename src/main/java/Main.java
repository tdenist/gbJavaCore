import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {

        List<Student> studentList = new ArrayList<>();

        studentList.add(new Student("Uasya", Arrays.asList(
                new Course("Java"))));
        studentList.add(new Student("Alexander", Arrays.asList(
                new Course("Java"),
                new Course("HTML"))));
        studentList.add(new Student("Marina", Arrays.asList(
                new Course("C++"),
                new Course("HTML"))));
        studentList.add(new Student("Svetlana", Arrays.asList(
                new Course("C++"),
                new Course("Java"))));
        studentList.add(new Student("Petr", Arrays.asList(
                new Course("C++"),
                new Course("PostgreSQL"))));

        System.out.println(
                studentList.stream()
                        .map(s -> s.getAllCourses())
                        .flatMap(c -> c.stream())
                        .map(c -> c.getCourseName())
                        .collect(Collectors.toSet())
        );

        System.out.println(
                studentList.stream()
                        .sorted((c1, c2) -> c2.getAllCourses().size()-c1.getAllCourses().size())
                        .limit(3)
                        .collect(Collectors.toSet())
        );

        Course course = new Course("Java");
        System.out.print("Курс " + course.getCourseName() + " посещают: ");
        studentList.stream()
                        .filter(s -> s.getAllCourses().contains(course))
                        .map(s -> s.getName())
                        .collect(Collectors.toList())
                        .forEach(n -> System.out.print(n + " "));

    }
}
