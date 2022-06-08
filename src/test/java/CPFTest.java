import org.junit.jupiter.api.Test;
import school.CPF;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class CPFTest {
    @Test
    void shouldThrowIllegalArgumentException() {
        assertThrows(IllegalArgumentException.class, () -> new CPF(null));
        assertThrows(IllegalArgumentException.class, () -> new CPF("thaliairene20gmail.com"));
        assertThrows(IllegalArgumentException.class, () -> new CPF(""));

    }
}
