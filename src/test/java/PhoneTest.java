import org.junit.jupiter.api.Test;
import school.Phone;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class PhoneTest {
    @Test
    void shouldThrowIllegalArgumentException() {
        assertThrows(IllegalArgumentException.class, () -> new Phone("098", "8989898989898"));
        assertThrows(IllegalArgumentException.class, () -> new Phone("0000", "98989"));
        assertThrows(IllegalArgumentException.class, () -> new Phone("0", "9"));
        assertThrows(IllegalArgumentException.class, () -> new Phone(null, "9"));
        assertThrows(IllegalArgumentException.class, () -> new Phone("0", null));

    }
}
