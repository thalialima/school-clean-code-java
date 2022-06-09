package br.com.training.school.infra.student;

import br.com.training.school.domain.student.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;

public class DefaultStudentRepository implements StudentRepository {

    private final Connection connection;

    public DefaultStudentRepository(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void registrateStudent(Student student) {
        String sql = "INSERT INTO STUDENT VALUES(?, ?, ?)";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, student.getCpf());
            preparedStatement.setString(2, student.getName());
            preparedStatement.setString(3, student.getEmail());
            preparedStatement.execute();//dispara o insert no bd

            sql = "INSERT INTO PHONE VALUES(?,?)";
            preparedStatement = connection.prepareStatement(sql);
            for (Phone phone : student.getPhones()) {
                preparedStatement.setString(1, phone.getDdd());
                preparedStatement.setString(2, phone.getNumber());
                preparedStatement.execute();
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }

    }

    @Override
    public Student searchStudent(String cpf) {
        String sql = "SELECT * FROM STUDENT s WHERE cpf = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, cpf);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (!resultSet.next()) {
                throw new StudentNotFoundException("Student not found!");
            }

            String name = resultSet.getString("name");
            String cpfNumber = resultSet.getString("cpf");
            String email = resultSet.getString("email");
            Student found = new Student(new CPF(cpfNumber), name, new Email(email));

            return found;
//            long id = resultSet.getLong("id");
//            sql = "SELECT ddd, number FROM PHONE WHERE student_id = ?";
//            preparedStatement = connection.prepareStatement(sql);
//            preparedStatement.setLong(1, id);
//
//            resultSet = preparedStatement.executeQuery();
//            if (!resultSet.next()) {
//                return found;
//            }
//
//            while (resultSet.next()) {
//                String ddd = resultSet.getString("ddd");
//                String number = resultSet.getString("number");
//                found.addPhone(ddd, number);
//            }
//
//            return found;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }


    @Override
    public Set<Student> getAllStudents() {
        String sql = "SELECT * FROM STUDENT";
        Set<Student> students = new HashSet<>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String name = resultSet.getString("name");
                String cpfNumber = resultSet.getString("cpf");
                String email = resultSet.getString("email");
                Student found = new Student(new CPF(cpfNumber), name, new Email(email));
                students.add(found);


                long id = resultSet.getLong("id");
                sql = "SELECT ddd, number FROM PHONE WHERE student_id = ?";
                preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setLong(1, id);

                resultSet = preparedStatement.executeQuery();
                if (!resultSet.next()) {
                    return students;
                }

                while (resultSet.next()) {
                    String ddd = resultSet.getString("ddd");
                    String number = resultSet.getString("number");
                    found.addPhone(ddd, number);
                }
                students.add(found);
            }
            return students;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
