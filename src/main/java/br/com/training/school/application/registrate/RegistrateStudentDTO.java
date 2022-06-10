package br.com.training.school.application.registrate;

import br.com.training.school.domain.student.CPF;
import br.com.training.school.domain.student.Email;
import br.com.training.school.domain.student.Student;

public class RegistrateStudentDTO {
    private String name;
    private String cpf;
    private String email;

    public RegistrateStudentDTO(String name, String cpf, String email) {
        this.name = name;
        this.cpf = cpf;
        this.email = email;
    }

    public Student createStudent() {
        return new Student(new CPF(cpf), name, new Email(email));
    }
}
