package br.com.training.school.application.indication;

import br.com.training.school.domain.student.Student;

public interface SendEmailIntication {
    void sendTo(Student indicated);
}
