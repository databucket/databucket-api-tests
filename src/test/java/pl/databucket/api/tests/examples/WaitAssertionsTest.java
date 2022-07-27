package pl.databucket.api.tests.examples;

import io.qameta.allure.Description;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pl.databucket.api.tests.BaseTest;
import pl.databucket.api.tests.utils.CustomAssertions;

import java.time.Instant;
import java.time.temporal.ChronoUnit;

@Tag("example")
@DisplayName("Wait assertions")
public class WaitAssertionsTest extends BaseTest {

    @Test
    @DisplayName("Wait assertion")
    @Description("")
    void waitAssertionTest() {
        int plusTime = 65; // for plusTime > 60, the assertion will fail
        Instant timeLimit = Instant.now().plus(plusTime, ChronoUnit.SECONDS);
        CustomAssertions.waitAssertEquals(
                "time",
                20,
                2,
                60,
                true,
                () -> {
                    return Instant.now().isAfter(timeLimit);
                });
    }

    @Test
    @DisplayName("Wait assertion optional")
    @Description("")
    void waitAssertionOptionalTest() {
        // Assertion will be passed, when one of the plusTime will be less than 60
        int plusTimeA = 80;
        int plusTimeB = 40;
        Instant timeLimitA = Instant.now().plus(plusTimeA, ChronoUnit.SECONDS);
        Instant timeLimitB = Instant.now().plus(plusTimeB, ChronoUnit.SECONDS);
        CustomAssertions.waitAssertEquals(
                "time",
                20,
                2,
                60,
                true,
                () -> {
                    return Instant.now().isAfter(timeLimitA);
                },
                () -> {
                    return Instant.now().isAfter(timeLimitB);
                });
    }


}
