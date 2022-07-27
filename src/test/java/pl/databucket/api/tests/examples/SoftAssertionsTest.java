package pl.databucket.api.tests.examples;

import io.qameta.allure.Description;
import org.junit.jupiter.api.*;
import pl.databucket.api.tests.BaseTest;
import pl.databucket.api.tests.utils.CustomAssertions;

@Tag("example")
@DisplayName("Custom assertions")
public class SoftAssertionsTest extends BaseTest {

    boolean aBoolean = true;
    int anInt = 1;
    float aFloat = 1.1f;
    String aString = "some text";

    @Test
    @DisplayName("Soft assertions - native")
    @Description("Example of JUnit5 native soft assertions. We don't see positive checks.")
    void nativeSoftAssertionsTest() {
        Then("check native assertions", () -> {
            Assertions.assertAll(
                    () -> Assertions.assertEquals("some text", aString, "String"),
                    () -> Assertions.assertEquals(2, anInt, "Int"),
                    () -> Assertions.assertEquals(1.1f, aFloat, "Float"),
                    () -> Assertions.assertTrue(aBoolean, "Boolean")
            );
        });
    }

    @Test
    @DisplayName("Soft assertions - custom")
    @Description("Example of JUnit5 custom soft assertions. We see also positive verifications.")
    void customSoftAssertionsTest() {
        Then("check custom assertions", () -> {
            CustomAssertions.assertAll(
                    () -> CustomAssertions.assertEquals("some text", aString, "String"),
                    () -> CustomAssertions.assertEquals(2, anInt, "Int"),
                    () -> CustomAssertions.assertEquals(1.1f, aFloat, "Float"),
                    () -> CustomAssertions.assertTrue(aBoolean, "Boolean")
            );
        });
    }

    @Test
    @DisplayName("Soft assertions - custom (as nested step)")
    @Description("Example of JUnit5 custom soft assertions. We see also positive verifications.")
    void customSoftAssertionsStepTest() {
        Then("check custom assertions", () -> {
            CustomAssertions.assertAll("custom title",
                    () -> CustomAssertions.assertEquals("some text", aString, "String"),
                    () -> CustomAssertions.assertEquals(2, anInt, "Int"),
                    () -> CustomAssertions.assertEquals(1.1f, aFloat, "Float"),
                    () -> CustomAssertions.assertTrue(aBoolean, "Boolean")
            );
        });
    }

}
