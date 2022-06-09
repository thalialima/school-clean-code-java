package br.com.training.school.domain.student;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

//entity
public class Student {
    private CPF cpf;
    private String name;
    private Email email;
    private Set<Phone> phones;

    public Student(CPF cpf, String name, Email email) {
        this.cpf = cpf;
        this.name = name;
        this.email = email;
        this.phones = new HashSet<>();
    }

    public String getCpf() {
        return this.cpf.getCpf();
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return this.email.getAddress();
    }

    public Set<Phone> getPhones() {
        return Collections.unmodifiableSet(phones);
    }

    public boolean addPhone(String ddd, String number) {
        return this.phones.add(new Phone(ddd, number));
    }

    @Override
    public String toString() {
        return "Student { " +
                "CPF = " + cpf +
                ", Name = '" + name + '\'' +
                ", Email = " + email + '\'' +
                " Phones = " + phones + '\'' +
                '}';
    }
}
