package br.com.training.school.domain.student;

import java.util.Set;

public interface StudentRepository {
    void registrateStudent(Student student);
    Student searchStudent(String cpf);
    Set<Student> getAllStudents();
}
