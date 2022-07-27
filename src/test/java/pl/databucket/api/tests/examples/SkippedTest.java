package pl.databucket.api.tests.examples;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.fail;
import static org.junit.jupiter.api.Assumptions.assumeTrue;

@Tag("example")
@DisplayName("Skipped scenarios")
public class SkippedTest {

    @Test
    @DisplayName("Do not execute! - skipped test")
    @Disabled("for demonstration purposes")
    void skippedTest() {
        // not executed
    }

    @Test
    @Disabled
    @DisplayName("Do not execute! - aborted test")
    void abortedTest() {
        assumeTrue("abc".contains("Z"));
        fail("test should have been aborted");
    }

}
