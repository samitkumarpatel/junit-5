package net.samitkumar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class Junit5AnnotationsExample {
    @Test
    @DisplayName("Basic Test")
    void basicTest() {
        assertTrue(true, "should be true");
        assertEquals(1,1, "should be equal");
    }

    @ParameterizedTest
    @DisplayName("Parameterized Test")
    @ValueSource(strings = { "racecar", "radar", "able was I ere I saw elba" })
    void parameterizedTest(String candidate) {
        assertTrue(candidate.split("").length > 2);
    }

    @RepeatedTest(3)
    @DisplayName("Repeated Test")
    void repeatedTest() {
        assertTrue(true);
    }
}
