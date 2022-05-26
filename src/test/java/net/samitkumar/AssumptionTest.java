package net.samitkumar;

import org.junit.jupiter.api.Assumptions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junitpioneer.jupiter.SetEnvironmentVariable;

import static org.junit.jupiter.api.Assumptions.assumeTrue;

public class AssumptionTest {
    @BeforeEach
    void init() {
    }

    @Test
    @SetEnvironmentVariable(key = "ENV",value = "CI") // This annotation comes from https://mvnrepository.com/artifact/org.junit-pioneer/junit-pioneer/1.7.1
    void testOnlyOnCiServer() {
        assumeTrue("CI".equals(System.getenv("ENV")));
        // remainder of test
    }

    @Test
    @SetEnvironmentVariable(key = "ENV",value = "DEV")
    void testOnlyOnDeveloperWorkstation() {
        assumeTrue("DEV".equals(System.getenv("ENV")),
                () -> "Aborting test: not on developer workstation");
        // remainder of test
    }
}
