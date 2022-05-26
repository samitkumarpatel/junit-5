package net.samitkumar;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.*;

public class ConditionalTest {
    @Test
    @EnabledOnJre(JRE.JAVA_8)
    void onlyOnJava8() {
        // ...
    }

    @Test
    @EnabledOnJre({ JRE.JAVA_9, JRE.JAVA_10 })
    void onJava9Or10() {
        // ...
    }

    @Test
    @EnabledForJreRange(min = JRE.JAVA_9, max = JRE.JAVA_11)
    void fromJava9to11() {
        // ...
    }

    @Test
    @EnabledForJreRange(min = JRE.JAVA_9)
    void fromJava9toCurrentJavaFeatureNumber() {
        // ...
    }

    @Test
    @EnabledForJreRange(max = JRE.JAVA_11)
    void fromJava8To11() {
        // ...
    }

    @Test
    @DisabledOnJre(JRE.JAVA_9)
    void notOnJava9() {
        // ...
    }

    @Test
    @DisabledForJreRange(min = JRE.JAVA_9, max = JRE.JAVA_11)
    void notFromJava9to11() {
        // ...
    }

    @Test
    @DisabledForJreRange(min = JRE.JAVA_9)
    void notFromJava9toCurrentJavaFeatureNumber() {
        // ...
    }

    @Test
    @DisabledForJreRange(max = JRE.JAVA_11)
    void notFromJava8to11() {
        // ...
    }

    @Test
    @EnabledIfEnvironmentVariable(named = "ENV", matches = "staging-server")
    void onlyOnStagingServer() {
        // ...
    }

    @Test
    @DisabledIfEnvironmentVariable(named = "ENV", matches = ".*development.*")
    void notOnDeveloperWorkstation() {
        // ...
    }

    @Test
    @EnabledIf("customCondition")
    void enabled() {
        // ...
    }

    @Test
    @DisabledIf("customCondition")
    void disabled() {
        // ...
    }

    boolean customCondition() {
        return true;
    }
}
