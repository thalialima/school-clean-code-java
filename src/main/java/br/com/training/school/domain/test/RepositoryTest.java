package br.com.training.school.domain.test;

import br.com.training.school.infra.db.CreateTables;
import br.com.training.school.domain.student.ConnectionFactory;
import br.com.training.school.domain.student.Student;
import br.com.training.school.domain.student.StudentFactory;
import br.com.training.school.domain.student.StudentRepository;
import br.com.training.school.infra.student.DefaultStudentRepository;

public class RepositoryTest {
    public static void main(String[] args) {
        StudentFactory factory = new StudentFactory();

        factory.setAttributes("Thalia", "208.444.330-04", "thaliairene20@gmail.com");
        Student student = factory.create();
        factory.addPhone("22", "978645312")
               .addPhone("77", "98986565");

        //System.out.println(student);

        ConnectionFactory connectionFactory = new ConnectionFactory();

        CreateTables createTables = new CreateTables(connectionFactory.getConn());
       // createTables.creatStudent();
        //createTables.creatPhone();

        StudentRepository repository = new DefaultStudentRepository(connectionFactory.getConn());

        //repository.registrateStudent(student);

        Student student1 = repository.searchStudent("208.444.330-04");
        System.out.println(student1);

        //Set<Student> allStudents = repository.getAllStudents();

        //allStudents.forEach(System.out::println);


    }

}
