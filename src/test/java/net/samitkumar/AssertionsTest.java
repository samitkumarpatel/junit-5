package net.samitkumar;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;

public class AssertionsTest {

    @Test
    void differentAssertionInJunitTest() {
        assertEquals(2, (1 + 1));
        assertEquals(4, (2 * 2),"The optional failure message is now the last parameter");
        assertTrue('a' < 'b', () -> "Assertion messages can be lazily evaluated -- "
                + "to avoid constructing complex messages unnecessarily.");

        assertAll("person",
                () -> assertEquals("Jane", "Jane"),
                () -> assertEquals("Doe", "Doe")
        );

        assertAll("properties",
                () -> {
                    String firstName = "Jone";
                    assertNotNull(firstName);

                    // Executed only if the previous assertion is valid.
                    assertAll("first name",
                            () -> assertTrue(firstName.startsWith("J")),
                            () -> assertTrue(firstName.endsWith("e"))
                    );
                },
                () -> {
                    // Grouped assertion, so processed independently
                    // of results of first name assertions.
                    String lastName = "Doe";
                    assertNotNull(lastName);

                    // Executed only if the previous assertion is valid.
                    assertAll("last name",
                            () -> assertTrue(lastName.startsWith("D")),
                            () -> assertTrue(lastName.endsWith("e"))
                    );
                }
        );
    }
    @Test
    void exceptionTesting() {
        Exception exception = assertThrows(ArithmeticException.class, () -> { throw new ArithmeticException("/ by zero");});
        assertEquals("/ by zero", exception.getMessage());
    }

    @Test
    @Disabled
    void timeoutNotExceeded() {
        // The following assertion succeeds.
        assertTimeout(Duration.ofMinutes(1), () -> {
            // Perform task that takes less than 2 minutes.
        });
    }
}
