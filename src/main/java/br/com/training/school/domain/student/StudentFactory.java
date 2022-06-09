package br.com.training.school.domain.student;

public class StudentFactory {
    private Student student = null;
    private String name;
    private CPF cpf;
    private Email email;

    public void setAttributes(String name, String cpf, String address) {
        this.name = name;
        this.cpf = new CPF(cpf);
        this.email = new Email(address);
        this.student = new Student(this.cpf, this.name, this.email);
    }

//    public StudentFactory populateStudentNameCPFEmail(String name, String cpf, String address) {
//        this.student = new Student(new CPF(cpf), name, new Email(address));
//        return this;
//    }

    public StudentFactory addPhone(String ddd, String number) {
        if (this.student == null) {
            throw new NullPointerException("Student is not created yet!");
        }
        this.student.addPhone(ddd, number);
        return this;
    }

    public Student create() {
        return this.student;
    }
}
