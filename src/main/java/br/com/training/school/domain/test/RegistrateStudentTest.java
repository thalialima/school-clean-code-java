package br.com.training.school.domain.test;

import br.com.training.school.application.registrate.RegistrateStudent;
import br.com.training.school.application.registrate.RegistrateStudentDTO;
import br.com.training.school.domain.student.ConnectionFactory;
import br.com.training.school.infra.student.DefaultStudentRepository;

import java.sql.Connection;

public class RegistrateStudentTest {
    public static void main(String[] args) {
        String name = "Thalia";
        String cpf = "208.444.330-04";
        String email = "thaliairene20@gmail.com";

        ConnectionFactory connectionFactory = new ConnectionFactory();
        Connection conn = connectionFactory.getConn();

        RegistrateStudent registrateStudent = new RegistrateStudent(new DefaultStudentRepository(conn));
        registrateStudent.registrateStudent(new RegistrateStudentDTO(name, cpf, email));

    }
}
