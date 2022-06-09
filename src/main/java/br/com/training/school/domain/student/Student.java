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

    public CPF getCpf() {
        return cpf;
    }

    public String getName() {
        return name;
    }

    public Email getEmail() {
        return email;
    }

    public Set<Phone> getPhones() {
        return Collections.unmodifiableSet(phones);
    }

    public boolean addPhone(String ddd, String number) {
        return this.phones.add(new Phone(ddd, number));
    }


}
