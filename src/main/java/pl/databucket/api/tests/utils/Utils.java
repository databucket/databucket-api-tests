package pl.databucket.api.tests.utils;

import io.qameta.allure.Allure;
import io.qameta.allure.Step;
import org.apache.commons.lang3.RandomStringUtils;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.*;
import java.util.concurrent.TimeUnit;

public class Utils {

    public static void delay(int minSec, int maxSec) {
        Random rn = new Random();
        delay(rn.nextInt(maxSec) + minSec);
    }

    public static void delay(int delaySec) {
        try {
            TimeUnit.SECONDS.sleep(delaySec);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Step("Wait {delaySec} sec. - {description}")
    public static void reportedDelay(int delaySec, String description) {
        Allure.getLifecycle().updateStep(stepResult -> stepResult.getParameters().clear());
        delay(delaySec);
    }

    @Step("Wait for {delaySec} sec")
    public static void reportedDelay(int delaySec) {
        Allure.getLifecycle().updateStep(stepResult -> stepResult.getParameters().clear());
        long current = System.currentTimeMillis();
        long end = System.currentTimeMillis() + delaySec * 1000L;
        String fullDelay = getTimestampDiff(current, end);
        System.out.println("Wait for " + fullDelay);
        try {
            while (current < end) {
                String delay = getTimestampDiff(current, end);
                if (delay.length() > 0) {
                    System.out.print("\rRemaining waiting time " + getTimestampDiff(current, end) + " ");
                    System.out.flush();
                } else
                    System.out.println("\r\t\t\t\t\t\t");
                TimeUnit.SECONDS.sleep(1);
                current = System.currentTimeMillis();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println();
    }

    public static String shorten(String text) {
        int len = text.length();
        return text.substring(0, 3) + "***" + text.substring(len - 3, len);
    }

    public static String getTimestampDiff(long timestamp1, long timestamp2) {
        long diffMs = timestamp2 - timestamp1;
        long diffSeconds = (diffMs / 1000) % 60;
        long diffMinutes = (diffMs / (60 * 1000)) % 60;
        long diffHours = diffMs / (60 * 60 * 1000);

        String result = "";

        if (diffHours > 0)
            result += String.format("%02d", diffHours) + "h ";

        if (diffMinutes > 0 || diffHours > 0)
            result += String.format("%02d", diffMinutes) + "m ";

        if (diffSeconds > 0 || diffMinutes > 0 || diffHours > 0)
            result += String.format("%02d", diffSeconds) + "s";

        return result;
    }

    public static String encodeValue(String value) {
        try {
            return URLEncoder.encode(value, StandardCharsets.UTF_8.toString());
        } catch (Exception e) {
            Log.error(e);
            return value;
        }
    }

    public static String generateRandomProductId() {
        return RandomStringUtils.randomAlphanumeric(36);
    }

    public static String getUtf8(String text) {
        byte[] textBytes = text.getBytes();
        return new String(textBytes, StandardCharsets.UTF_8);
    }

}
