package br.com.training.school.application.registrate;

import br.com.training.school.domain.student.Student;
import br.com.training.school.domain.student.StudentRepository;

public class RegistrateStudent {
    private final StudentRepository repository;

    public RegistrateStudent(StudentRepository repository) {
        this.repository = repository;
    }

    public void registrateStudent(RegistrateStudentDTO data) {
        Student newStudent = data.createStudent();
        repository.registrateStudent(newStudent);
    }
}
