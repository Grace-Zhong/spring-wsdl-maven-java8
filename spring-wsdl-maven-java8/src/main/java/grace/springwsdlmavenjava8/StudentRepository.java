package grace.springwsdlmavenjava8;

import grace.springwsdlmavenjava8.generated.Student;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;

@Component
public class StudentRepository {
    private static final Map<String, Student> students = new HashMap<>();

    @PostConstruct
    public void initData() {

        Student student = new Student();
        student.setName("Sajal");
        student.setStandard(5);
        student.setAddress("Pune");
        students.put(student.getName(), student);

        student = new Student();
        student.setName("Kajal");
        student.setStandard(5);
        student.setAddress("Chicago");
        students.put(student.getName(), student);

        student = new Student();
        student.setName("Lokesh");
        student.setStandard(6);
        student.setAddress("Delhi");
        students.put(student.getName(), student);

        student = new Student();
        student.setName("Sukesh");
        student.setStandard(7);
        student.setAddress("Noida");
        students.put(student.getName(), student);
    }

    public static Student findStudent(String name) {
//        Assert.notNull(name, "The Student's name must not be null");
        return students.get(name);
    }
}
