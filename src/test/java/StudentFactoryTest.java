import org.junit.jupiter.api.Test;

import school.CPF;
import school.Email;
import school.Student;
import school.StudentFactory;

import static org.junit.jupiter.api.Assertions.*;

public class StudentFactoryTest {

    @Test
    void shouldThrowNullPointerException() {
        StudentFactory studentFactory = new StudentFactory();
        assertThrows(NullPointerException.class, () -> studentFactory.addPhone("90", "90909090"));

    }

    void shoulReturnAStudentObject() {
        StudentFactory studentFactory = new StudentFactory();
        Student student = new Student(new CPF("358.694.020-34"), "Thalia", new Email("thaliairene20@gmail.com"));
        studentFactory.setAttributes("Thalia", "358.694.020-34", "thaliairene20@gmail.com");
        assertEquals(student.getCpf(), studentFactory.create().getCpf());

    }
}
