package br.com.training.school.infra.indication;

import br.com.training.school.application.indication.SendEmailIntication;
import br.com.training.school.domain.student.Student;

public class DefaultSendEmailIntication implements SendEmailIntication {
    @Override
    public void sendTo(Student indicated) {
        //lib Java Mail

    }
}
