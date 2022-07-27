package pl.databucket.api.tests;

import pl.databucket.api.tests.utils.Context;
import pl.databucket.api.tests.utils.Utils;
import io.qameta.allure.Allure;
import io.qameta.allure.Step;
import org.apache.commons.lang3.StringUtils;
import org.junit.jupiter.api.*;

public class BaseTest {

    @BeforeAll
    static void beforeAll() {
        if (!Context.initiated) {
            Context.initiated = true;
            Context.setupConfiguration();
        } else {
            while (!Context.isInitiatingCompleted()) {
                Utils.delay(2);
            }
            Utils.delay(0, 5); // randomize start time of the current thread to avoid overloading
        }
    }

//    @BeforeEach
//    public void beforeScenario(TestInfo testInfo) {
//        Assumptions.assumeTrue(!testInfo.getDisplayName().contains("Do not execute!"), "Condition not met");
//    }

//    @AfterEach
//    public void afterScenario() {
//    }

    @Step("Given {title}")
    protected void Given(String title, Runnable code) {
        step("Given " + title, code, true);
    }

    @Step("When {title}")
    protected void When(String title, Runnable code) {
        step("When " + title, code, true);
    }

    @Step("Then {title}")
    protected void Then(String title, Runnable code) {
        step("Then " + title, code, true);
    }

    @Step("And {title}")
    protected void And(String title, Runnable code) {
        step("And " + title, code, true);
    }

    @Step("But {title}")
    protected void But(String title, Runnable code) {
        step("But " + title, code, true);
    }

    private void step(String title, Runnable code, boolean clearAllureProperties) {
        if (clearAllureProperties)
            Allure.getLifecycle().updateStep(stepResult -> stepResult.getParameters().clear());

        int prefixSize = 45;
        int maxChars = 140;

        String beginTitle = String.format(StringUtils.leftPad(" ", prefixSize, '=') + "Begin: %s ", title);
        System.err.println("\n" + StringUtils.rightPad(beginTitle, maxChars, '='));

        code.run();

        String endTitle = String.format(StringUtils.leftPad(" ", prefixSize, '=') + "End: %s ", title);
        System.err.println(StringUtils.rightPad(endTitle, maxChars, '='));
    }
}
