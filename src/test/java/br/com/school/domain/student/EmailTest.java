package br.com.school.domain.student;

import org.junit.jupiter.api.Test;
import br.com.training.school.domain.student.Email;

import static org.junit.jupiter.api.Assertions.*;

public class EmailTest {

    @Test
    void shouldThrowIllegalArgumentException() {
        assertThrows(IllegalArgumentException.class, () -> new Email(null));
        assertThrows(IllegalArgumentException.class, () -> new Email("thaliairene20gmail.com"));
        assertThrows(IllegalArgumentException.class, () -> new Email(""));

    }
}
