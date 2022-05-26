package net.samitkumar;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.condition.DisabledOnOs;
import org.junit.jupiter.api.condition.EnabledOnOs;
import org.junit.jupiter.api.condition.OS;
import org.junit.jupiter.api.io.TempDir;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.DynamicTest.*;

public class Junit5AnnotationsExample {

    @BeforeAll
    static void initAll() {
    }

    @BeforeEach
    void init() {
    }

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

    @ParameterizedTest(name = "{0} + {1} = {2}")
    @CsvSource({
            "0,  1,  1",
            "1,  2,  3",
            "49, 51, 100",
            "1,  100, 101"
    })
    void add(int first, int second, int expectedResult) {
        //instead of (first + second), you could call a method
        assertEquals(expectedResult, (first + second),
                () -> first + " + " + second + " should equal " + expectedResult);
    }

    @RepeatedTest(3)
    @DisplayName("Repeated Test")
    void repeatedTest() {
        assertTrue(true);
    }

    // This will be well suits for a stream related test- more details can be found here - https://junit.org/junit5/docs/current/user-guide/#writing-tests-dynamic-tests
    @TestFactory
    Stream<DynamicTest> dynamicTestsFromIntStream() {
        // Generates tests for the first 10 even integers.
        return IntStream.iterate(0, n -> n + 2).limit(10)
                .mapToObj(n -> dynamicTest("test" + n, () -> assertTrue(n % 2 == 0)));
    }

    @Tag("smoketest")
    @Tag("Integration")
    @Test
    void testTag() {
    }

    @Disabled("Disabled until bug #42 has been resolved")
    @Test
    void testWillBeSkipped() {
    }

    /*
    @Test
    @ExtendWith(WebServerExtension.class)
    void getProductList(@WebServerUrl String serverUrl) {
        WebClient webClient = new WebClient();
        // Use WebClient to connect to web server using serverUrl and verify response
        assertEquals(200, webClient.get(serverUrl + "/products").getResponseStatus());
    }*/

    @Test
    @EnabledOnOs(OS.MAC)
    void onlyOnMacOs() {
        // ...
    }

    @TestOnMac
    void testOnMac() {
        // ...
    }

    @Test
    @EnabledOnOs({ OS.LINUX, OS.MAC })
    void onLinuxOrMac() {
        // ...
    }

    @Test
    @DisabledOnOs(OS.WINDOWS)
    void notOnWindows() {
        // ...
    }

    @Test
    void writeItemsToFile(@TempDir Path tempDir) throws IOException {
        Path file = tempDir.resolve("test.txt");

        Files.write(file, "a,b,c".getBytes());
        Charset charset = Charset.forName("ISO-8859-1");
        assertEquals(Arrays.asList("a,b,c"), Files.readAllLines(file, charset));
    }

    @AfterEach
    void tearDown() {
    }

    @AfterAll
    static void tearDownAll() {
    }

}
