import java.util.ArrayList;
import java.util.List;

public class Student {

    String name;
    List<Course> coursesList;

    public Student(String name, List<Course> coursesList) {
        this.name = name;
        this.coursesList = coursesList;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Course> getAllCourses() {
        return coursesList;
    }

    public void setCoursesList(List<Course> coursesList) {
        this.coursesList = coursesList;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", coursesList=" + coursesList +
                '}';
    }
}
