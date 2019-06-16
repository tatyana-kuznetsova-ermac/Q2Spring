import model.Course;
import model.Student;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Course qa = new Course();
        qa.setName("QA1");
        qa.setHourCount(20);


        List<Student> students = new ArrayList<Student>();
        Student student = new Student();
        student.setId("111111-11111");
        student.setAge(25);

        students.add(student);

        //mozhno sozdatj esho studentov
        qa.setStudents(students);

        System.out.println(qa.getStudents().get(0).getName());
    }
}
