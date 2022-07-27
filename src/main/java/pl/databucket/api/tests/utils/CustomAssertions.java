package pl.databucket.api.tests.utils;

import io.qameta.allure.Allure;
import io.qameta.allure.Step;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.function.Executable;
import org.opentest4j.MultipleFailuresError;

import java.math.BigDecimal;
import java.util.*;
import java.util.concurrent.Callable;
import java.util.stream.Stream;

public class CustomAssertions {

    /**
     * <em>Assert</em> that the supplied {@code condition} is {@code true}.
     * <p>Fails with the supplied failure {@code message}.
     */
    @Step("{message} is {condition}")
    public static void assertTrue(boolean condition, String message) {
        Allure.getLifecycle().updateStep(stepResult -> stepResult.getParameters().clear());
        System.out.println(String.format("Assert that %s is %s", message, condition));
        Assertions.assertTrue(condition, message);
    }

    /**
     * <em>Assert</em> that the supplied {@code condition} is {@code false}.
     * <p>Fails with the supplied failure {@code message}.
     */
    @Step("{message} is {expected}")
    public static void assertFalse(boolean condition, String message) {
        Allure.getLifecycle().updateStep(stepResult -> stepResult.getParameters().clear());
        System.out.println(String.format("Assert that %s is %s", message, condition));
        Assertions.assertFalse(condition, message);
    }

    /**
     * <em>Assert</em> that {@code actual} is {@code null}.
     * <p>Fails with the supplied failure {@code message}.
     */
    @Step("{message} is {actual}")
    public static void assertNull(Object actual, String message) {
        Allure.getLifecycle().updateStep(stepResult -> stepResult.getParameters().clear());
        System.out.println(String.format("Assert that %s is %s", message, actual));
        Assertions.assertNull(actual, message);
    }

    /**
     * <em>Assert</em> that {@code actual} is not {@code null}.
     * <p>Fails with the supplied failure {@code message}.
     */
    @Step("{message} is {actual}")
    public static void assertNotNull(Object actual, String message) {
        Allure.getLifecycle().updateStep(stepResult -> stepResult.getParameters().clear());
        System.out.println(String.format("Assert that %s is %s", message, actual));
        Assertions.assertNotNull(actual, message);
    }

    /**
     * <em>Assert</em> that {@code expected} and {@code actual} are equal.
     * <p>Fails with the supplied failure {@code message}.
     */
    @Step("{message} is {expected}")
    public static void assertEquals(short expected, short actual, String message) {
        Allure.getLifecycle().updateStep(stepResult -> stepResult.getParameters().clear());
        System.out.println(String.format("Assert that %s is %s", message, actual));
        Assertions.assertEquals(expected, actual, message);
    }

    /**
     * <em>Assert</em> that {@code expected} and {@code actual} are equal.
     * <p>Fails with the supplied failure {@code message}.
     */
    @Step("{message} is {expected}")
    public static void assertEquals(short expected, Short actual, String message) {
        Allure.getLifecycle().updateStep(stepResult -> stepResult.getParameters().clear());
        System.out.println(String.format("Assert that %s is %s", message, expected));
        Assertions.assertEquals((Short) expected, actual, message);
    }

    /**
     * <em>Assert</em> that {@code expected} and {@code actual} are equal.
     * <p>Fails with the supplied failure {@code message}.
     */
    @Step("{message} is {expected}")
    public static void assertEquals(Short expected, short actual, String message) {
        Allure.getLifecycle().updateStep(stepResult -> stepResult.getParameters().clear());
        System.out.println(String.format("Assert that %s is %s", message, expected));
        Assertions.assertEquals(expected, (Short) actual, message);
    }

    /**
     * <em>Assert</em> that {@code expected} and {@code actual} are equal.
     * <p>Fails with the supplied failure {@code message}.
     *
     * @since 5.4
     */
    @Step("{message} is {expected}")
    public static void assertEquals(Short expected, Short actual, String message) {
        Allure.getLifecycle().updateStep(stepResult -> stepResult.getParameters().clear());
        System.out.println(String.format("Assert that %s is %s", message, expected));
        Assertions.assertEquals(expected, actual, message);
    }

    /**
     * <em>Assert</em> that {@code expected} and {@code actual} are equal.
     * <p>Fails with the supplied failure {@code message}.
     */
    @Step("{message} is {expected}")
    public static void assertEquals(byte expected, byte actual, String message) {
        Allure.getLifecycle().updateStep(stepResult -> stepResult.getParameters().clear());
        System.out.println(String.format("Assert that %s is %s", message, expected));
        Assertions.assertEquals(expected, actual, message);
    }

    /**
     * <em>Assert</em> that {@code expected} and {@code actual} are equal.
     * <p>Fails with the supplied failure {@code message}.
     */
    @Step("{message} is {expected}")
    public static void assertEquals(byte expected, Byte actual, String message) {
        Allure.getLifecycle().updateStep(stepResult -> stepResult.getParameters().clear());
        System.out.println(String.format("Assert that %s is %s", message, expected));
        Assertions.assertEquals((Byte) expected, actual, message);
    }

    /**
     * <em>Assert</em> that {@code expected} and {@code actual} are equal.
     * <p>Fails with the supplied failure {@code message}.
     */
    @Step("{message} is {expected}")
    public static void assertEquals(Byte expected, byte actual, String message) {
        Allure.getLifecycle().updateStep(stepResult -> stepResult.getParameters().clear());
        System.out.println(String.format("Assert that %s is %s", message, expected));
        Assertions.assertEquals(expected, (Byte) actual, message);
    }

    /**
     * <em>Assert</em> that {@code expected} and {@code actual} are equal.
     * <p>Fails with the supplied failure {@code message}.
     *
     * @since 5.4
     */
    @Step("{message} is {expected}")
    public static void assertEquals(Byte expected, Byte actual, String message) {
        Allure.getLifecycle().updateStep(stepResult -> stepResult.getParameters().clear());
        System.out.println(String.format("Assert that %s is %s", message, expected));
        Assertions.assertEquals(expected, actual, message);
    }

    /**
     * <em>Assert</em> that {@code expected} and {@code actual} are equal.
     * <p>Fails with the supplied failure {@code message}.
     */
    @Step("{message} is {expected}")
    public static void assertEquals(int expected, int actual, String message) {
        Allure.getLifecycle().updateStep(stepResult -> stepResult.getParameters().clear());
        System.out.println(String.format("Assert that %s is %s", message, expected));
        Assertions.assertEquals(expected, actual, message);
    }

    /**
     * <em>Assert</em> that {@code expected} and {@code actual} are equal.
     * <p>Fails with the supplied failure {@code message}.
     */
    @Step("{message} is {expected}")
    public static void assertEquals(int expected, Integer actual, String message) {
        Allure.getLifecycle().updateStep(stepResult -> stepResult.getParameters().clear());
        System.out.println(String.format("Assert that %s is %s", message, expected));
        Assertions.assertEquals((Integer) expected, actual, message);
    }

    /**
     * <em>Assert</em> that {@code expected} and {@code actual} are equal.
     * <p>Fails with the supplied failure {@code message}.
     */
    @Step("{message} is {expected}")
    public static void assertEquals(Integer expected, int actual, String message) {
        Allure.getLifecycle().updateStep(stepResult -> stepResult.getParameters().clear());
        System.out.println(String.format("Assert that %s is %s", message, expected));
        Assertions.assertEquals(expected, (Integer) actual, message);
    }

    /**
     * <em>Assert</em> that {@code expected} and {@code actual} are equal.
     * <p>Fails with the supplied failure {@code message}.
     *
     * @since 5.4
     */
    @Step("{message} is {expected}")
    public static void assertEquals(Integer expected, Integer actual, String message) {
        Allure.getLifecycle().updateStep(stepResult -> stepResult.getParameters().clear());
        System.out.println(String.format("Assert that %s is %s", message, expected));
        Assertions.assertEquals(expected, actual, message);
    }

    /**
     * <em>Assert</em> that {@code expected} and {@code actual} are equal.
     * <p>Fails with the supplied failure {@code message}.
     */
    @Step("{message} is {expected}")
    public static void assertEquals(long expected, long actual, String message) {
        Allure.getLifecycle().updateStep(stepResult -> stepResult.getParameters().clear());
        System.out.println(String.format("Assert that %s is %s", message, expected));
        Assertions.assertEquals(expected, actual, message);
    }

    /**
     * <em>Assert</em> that {@code expected} and {@code actual} are equal.
     * <p>Fails with the supplied failure {@code message}.
     */
    @Step("{message} is {expected}")
    public static void assertEquals(long expected, Long actual, String message) {
        Allure.getLifecycle().updateStep(stepResult -> stepResult.getParameters().clear());
        System.out.println(String.format("Assert that %s is %s", message, expected));
        Assertions.assertEquals((Long) expected, actual, message);
    }

    /**
     * <em>Assert</em> that {@code expected} and {@code actual} are equal.
     * <p>Fails with the supplied failure {@code message}.
     */
    @Step("{message} is {expected}")
    public static void assertEquals(Long expected, long actual, String message) {
        Allure.getLifecycle().updateStep(stepResult -> stepResult.getParameters().clear());
        System.out.println(String.format("Assert that %s is %s", message, expected));
        Assertions.assertEquals(expected, (Long) actual, message);
    }

    /**
     * <em>Assert</em> that {@code expected} and {@code actual} are equal.
     * <p>Fails with the supplied failure {@code message}.
     *
     * @since 5.4
     */
    @Step("{message} is {expected}")
    public static void assertEquals(Long expected, Long actual, String message) {
        Allure.getLifecycle().updateStep(stepResult -> stepResult.getParameters().clear());
        System.out.println(String.format("Assert that %s is %s", message, expected));
        Assertions.assertEquals(expected, actual, message);
    }

    /**
     * <em>Assert</em> that {@code expected} and {@code actual} are equal.
     * <p>Equality imposed by this method is consistent with {@link Float#equals(Object)} and
     * {@link Float#compare(float, float)}.
     * <p>Fails with the supplied failure {@code message}.
     */
    @Step("{message} is {expected}")
    public static void assertEquals(float expected, float actual, String message) {
        Allure.getLifecycle().updateStep(stepResult -> stepResult.getParameters().clear());
        System.out.println(String.format("Assert that %s is %s", message, expected));
        Assertions.assertEquals(expected, actual, message);
    }

    /**
     * <em>Assert</em> that {@code expected} and {@code actual} are equal.
     * <p>Equality imposed by this method is consistent with {@link Float#equals(Object)} and
     * {@link Float#compare(float, float)}.
     * <p>Fails with the supplied failure {@code message}.
     */
    @Step("{message} is {expected}")
    public static void assertEquals(float expected, Float actual, String message) {
        Allure.getLifecycle().updateStep(stepResult -> stepResult.getParameters().clear());
        System.out.println(String.format("Assert that %s is %s", message, expected));
        Assertions.assertEquals((Float) expected, actual, message);
    }

    /**
     * <em>Assert</em> that {@code expected} and {@code actual} are equal.
     * <p>Equality imposed by this method is consistent with {@link Float#equals(Object)} and
     * {@link Float#compare(float, float)}.
     * <p>Fails with the supplied failure {@code message}.
     */
    @Step("{message} is {expected}")
    public static void assertEquals(Float expected, float actual, String message) {
        Allure.getLifecycle().updateStep(stepResult -> stepResult.getParameters().clear());
        System.out.println(String.format("Assert that %s is %s", message, expected));
        Assertions.assertEquals(expected, (Float) actual, message);
    }

    /**
     * <em>Assert</em> that {@code expected} and {@code actual} are equal.
     * <p>Equality imposed by this method is consistent with {@link Float#equals(Object)} and
     * {@link Float#compare(float, float)}.
     * <p>Fails with the supplied failure {@code message}.
     *
     * @since 5.4
     */
    @Step("{message} is {expected}")
    public static void assertEquals(Float expected, Float actual, String message) {
        Allure.getLifecycle().updateStep(stepResult -> stepResult.getParameters().clear());
        System.out.println(String.format("Assert that %s is %s", message, expected));
        Assertions.assertEquals(expected, actual, message);
    }

    /**
     * <em>Assert</em> that {@code expected} and {@code actual} are equal within the given non-negative {@code delta}.
     * <p>Equality imposed by this method is consistent with {@link Float#equals(Object)} and
     * {@link Float#compare(float, float)}.
     * <p>Fails with the supplied failure {@code message}.
     */
    @Step("{message} is {expected}")
    public static void assertEquals(float expected, float actual, float delta, String message) {
        Allure.getLifecycle().updateStep(stepResult -> stepResult.getParameters().clear());
        System.out.println(String.format("Assert that %s is %s", message, expected));
        Assertions.assertEquals(expected, actual, delta, message);
    }

    /**
     * <em>Assert</em> that {@code expected} and {@code actual} are equal.
     * <p>Equality imposed by this method is consistent with {@link Double#equals(Object)} and
     * {@link Double#compare(double, double)}.
     * <p>Fails with the supplied failure {@code message}.
     */
    @Step("{message} is {expected}")
    public static void assertEquals(double expected, double actual, String message) {
        Allure.getLifecycle().updateStep(stepResult -> stepResult.getParameters().clear());
        System.out.println(String.format("Assert that %s is %s", message, expected));
        Assertions.assertEquals(expected, actual, message);
    }

    /**
     * <em>Assert</em> that {@code expected} and {@code actual} are equal.
     * <p>Equality imposed by this method is consistent with {@link Double#equals(Object)} and
     * {@link Double#compare(double, double)}.
     * <p>Fails with the supplied failure {@code message}.
     */
    @Step("{message} is {expected}")
    public static void assertEquals(double expected, Double actual, String message) {
        Allure.getLifecycle().updateStep(stepResult -> stepResult.getParameters().clear());
        System.out.println(String.format("Assert that %s is %s", message, expected));
        Assertions.assertEquals((Double) expected, actual, message);
    }

    /**
     * <em>Assert</em> that {@code expected} and {@code actual} are equal.
     * <p>Equality imposed by this method is consistent with {@link Double#equals(Object)} and
     * {@link Double#compare(double, double)}.
     * <p>Fails with the supplied failure {@code message}.
     */
    @Step("{message} is {expected}")
    public static void assertEquals(Double expected, double actual, String message) {
        Allure.getLifecycle().updateStep(stepResult -> stepResult.getParameters().clear());
        System.out.println(String.format("Assert that %s is %s", message, expected));
        Assertions.assertEquals(expected, (Double) actual, message);
    }

    /**
     * <em>Assert</em> that {@code expected} and {@code actual} are equal.
     * <p>Equality imposed by this method is consistent with {@link Double#equals(Object)} and
     * {@link Double#compare(double, double)}.
     * <p>Fails with the supplied failure {@code message}.
     *
     * @since 5.4
     */
    @Step("{message} is {expected}")
    public static void assertEquals(Double expected, Double actual, String message) {
        Allure.getLifecycle().updateStep(stepResult -> stepResult.getParameters().clear());
        System.out.println(String.format("Assert that %s is %s", message, expected));
        Assertions.assertEquals(expected, actual, message);
    }

    /**
     * <em>Assert</em> that {@code expected} and {@code actual} are equal within the given non-negative {@code delta}.
     * <p>Equality imposed by this method is consistent with {@link Double#equals(Object)} and
     * {@link Double#compare(double, double)}.
     * <p>Fails with the supplied failure {@code message}.
     */
    @Step("{message} is {expected}")
    public static void assertEquals(double expected, double actual, double delta, String message) {
        Allure.getLifecycle().updateStep(stepResult -> stepResult.getParameters().clear());
        System.out.println(String.format("Assert that %s is %s", message, expected));
        Assertions.assertEquals(expected, actual, delta, message);
    }

    /**
     * <em>Assert</em> that {@code expected} and {@code actual} are equal.
     * <p>Fails with the supplied failure {@code message}.
     */
    @Step("{message} is {expected}")
    public static void assertEquals(char expected, char actual, String message) {
        Allure.getLifecycle().updateStep(stepResult -> stepResult.getParameters().clear());
        System.out.println(String.format("Assert that %s is %s", message, expected));
        Assertions.assertEquals(expected, actual, message);
    }

    /**
     * <em>Assert</em> that {@code expected} and {@code actual} are equal.
     * <p>Fails with the supplied failure {@code message}.
     */
    @Step("{message} is {expected}")
    public static void assertEquals(char expected, Character actual, String message) {
        Allure.getLifecycle().updateStep(stepResult -> stepResult.getParameters().clear());
        System.out.println(String.format("Assert that %s is %s", message, expected));
        Assertions.assertEquals((Character) expected, actual, message);
    }

    /**
     * <em>Assert</em> that {@code expected} and {@code actual} are equal.
     * <p>Fails with the supplied failure {@code message}.
     */
    @Step("{message} is {expected}")
    public static void assertEquals(Character expected, char actual, String message) {
        Allure.getLifecycle().updateStep(stepResult -> stepResult.getParameters().clear());
        System.out.println(String.format("Assert that %s is %s", message, expected));
        Assertions.assertEquals(expected, (Character) actual, message);
    }

    /**
     * <em>Assert</em> that {@code expected} and {@code actual} are equal.
     * <p>Fails with the supplied failure {@code message}.
     *
     * @since 5.4
     */
    @Step("{message} is {expected}")
    public static void assertEquals(Character expected, Character actual, String message) {
        Allure.getLifecycle().updateStep(stepResult -> stepResult.getParameters().clear());
        System.out.println(String.format("Assert that %s is %s", message, expected));
        Assertions.assertEquals(expected, actual, message);
    }

    /**
     * <em>Assert</em> that {@code expected} and {@code actual} are equal.
     * <p>If both are {@code null}, they are considered equal.
     * <p>Fails with the supplied failure {@code message}.
     *
     * @see Object#equals(Object)
     */
    @Step("{message} is {expected}")
    public static void assertEquals(Object expected, Object actual, String message) {
        Allure.getLifecycle().updateStep(stepResult -> stepResult.getParameters().clear());
        System.out.println(String.format("Assert that %s is %s", message, expected));
        Assertions.assertEquals(expected, actual, message);
    }

    /**
     * <em>Assert</em> that {@code expected} and {@code actual} are equal.
     * <p>If both are {@code null}, they are considered equal.
     * <p>Fails with the supplied failure {@code message}.
     *
     * @see Object#equals(Object)
     */
    @Step("{message} is {expected}")
    public static void assertEquals(Double expected, BigDecimal actual, String message) {
        Allure.getLifecycle().updateStep(stepResult -> stepResult.getParameters().clear());
        System.out.println(String.format("Assert that %s is %s", message, expected));
        Assertions.assertEquals(expected, actual.doubleValue(), message);
    }

    /**
     * <em>Assert</em> that {@code expected} and {@code actual} are equal.
     * <p>If both are {@code null}, they are considered equal.
     * <p>Fails with the supplied failure {@code message}.
     *
     * @see Object#equals(Object)
     */
    @Step("{message} is in the list")
    public static void assertIn(Set<?> setOfObjects, Object obj, String message) {
        Allure.getLifecycle().updateStep(stepResult -> stepResult.getParameters().clear());
        System.out.println(String.format("Assert that %s is in the list " + setOfObjects, message));
        if (!setOfObjects.contains(obj))
            throw new AssertionError(message + " ==> expected to be one of " + setOfObjects + ", but was <" + obj + ">");
    }

    /**
     * <em>Assert</em> that {@code expected} and {@code actual} boolean arrays are equal.
     * <p>If both are {@code null}, they are considered equal.
     * <p>Fails with the supplied failure {@code message}.
     */
    @Step("{message} is {expected}")
    public static void assertArrayEquals(boolean[] expected, boolean[] actual, String message) {
        Allure.getLifecycle().updateStep(stepResult -> stepResult.getParameters().clear());
        System.out.println(String.format("Assert that %s is %s", message, Arrays.toString(expected)));
        Assertions.assertArrayEquals(expected, actual, message);
    }

    /**
     * <em>Assert</em> that {@code expected} and {@code actual} char arrays are equal.
     * <p>If both are {@code null}, they are considered equal.
     * <p>Fails with the supplied failure {@code message}.
     */
    @Step("{message} is {expected}")
    public static void assertArrayEquals(char[] expected, char[] actual, String message) {
        Allure.getLifecycle().updateStep(stepResult -> stepResult.getParameters().clear());
        System.out.println(String.format("Assert that %s is %s", message, Arrays.toString(expected)));
        Assertions.assertArrayEquals(expected, actual, message);
    }

    /**
     * <em>Assert</em> that {@code expected} and {@code actual} byte arrays are equal.
     * <p>If both are {@code null}, they are considered equal.
     * <p>Fails with the supplied failure {@code message}.
     */
    @Step("{message} is {expected}")
    public static void assertArrayEquals(byte[] expected, byte[] actual, String message) {
        Allure.getLifecycle().updateStep(stepResult -> stepResult.getParameters().clear());
        System.out.println(String.format("Assert that %s is %s", message, Arrays.toString(expected)));
        Assertions.assertArrayEquals(expected, actual, message);
    }

    /**
     * <em>Assert</em> that {@code expected} and {@code actual} short arrays are equal.
     * <p>If both are {@code null}, they are considered equal.
     * <p>Fails with the supplied failure {@code message}.
     */
    @Step("{message} is {expected}")
    public static void assertArrayEquals(short[] expected, short[] actual, String message) {
        Allure.getLifecycle().updateStep(stepResult -> stepResult.getParameters().clear());
        System.out.println(String.format("Assert that %s is %s", message, Arrays.toString(expected)));
        Assertions.assertArrayEquals(expected, actual, message);
    }

    /**
     * <em>Assert</em> that {@code expected} and {@code actual} int arrays are equal.
     * <p>If both are {@code null}, they are considered equal.
     * <p>Fails with the supplied failure {@code message}.
     */
    @Step("{message} is {expected}")
    public static void assertArrayEquals(int[] expected, int[] actual, String message) {
        Allure.getLifecycle().updateStep(stepResult -> stepResult.getParameters().clear());
        System.out.println(String.format("Assert that %s is %s", message, Arrays.toString(expected)));
        Assertions.assertArrayEquals(expected, actual, message);
    }

    /**
     * <em>Assert</em> that {@code expected} and {@code actual} long arrays are equal.
     * <p>If both are {@code null}, they are considered equal.
     * <p>Fails with the supplied failure {@code message}.
     */
    @Step("{message} is {expected}")
    public static void assertArrayEquals(long[] expected, long[] actual, String message) {
        Allure.getLifecycle().updateStep(stepResult -> stepResult.getParameters().clear());
        System.out.println(String.format("Assert that %s is %s", message, Arrays.toString(expected)));
        Assertions.assertArrayEquals(expected, actual, message);
    }

    /**
     * <em>Assert</em> that {@code expected} and {@code actual} float arrays are equal.
     * <p>Equality imposed by this method is consistent with {@link Float#equals(Object)} and
     * {@link Float#compare(float, float)}.
     * <p>Fails with the supplied failure {@code message}.
     */
    @Step("{message} is {expected}")
    public static void assertArrayEquals(float[] expected, float[] actual, String message) {
        Allure.getLifecycle().updateStep(stepResult -> stepResult.getParameters().clear());
        System.out.println(String.format("Assert that %s is %s", message, Arrays.toString(expected)));
        Assertions.assertArrayEquals(expected, actual, message);
    }

    /**
     * <em>Assert</em> that {@code expected} and {@code actual} float arrays are equal within the given non-negative {@code delta}.
     * <p>Equality imposed by this method is consistent with {@link Float#equals(Object)} and
     * {@link Float#compare(float, float)}.
     * <p>Fails with the supplied failure {@code message}.
     */
    @Step("{message} is {expected}")
    public static void assertArrayEquals(float[] expected, float[] actual, float delta, String message) {
        Allure.getLifecycle().updateStep(stepResult -> stepResult.getParameters().clear());
        System.out.println(String.format("Assert that %s is %s", message, Arrays.toString(expected)));
        Assertions.assertArrayEquals(expected, actual, delta, message);
    }

    /**
     * <em>Assert</em> that {@code expected} and {@code actual} double arrays are equal.
     * <p>Equality imposed by this method is consistent with {@link Double#equals(Object)} and
     * {@link Double#compare(double, double)}.
     * <p>Fails with the supplied failure {@code message}.
     */
    @Step("{message} is {expected}")
    public static void assertArrayEquals(double[] expected, double[] actual, String message) {
        Allure.getLifecycle().updateStep(stepResult -> stepResult.getParameters().clear());
        System.out.println(String.format("Assert that %s is %s", message, Arrays.toString(expected)));
        Assertions.assertArrayEquals(expected, actual, message);
    }

    /**
     * <em>Assert</em> that {@code expected} and {@code actual} double arrays are equal within the given non-negative {@code delta}.
     * <p>Equality imposed by this method is consistent with {@link Double#equals(Object)} and
     * {@link Double#compare(double, double)}.
     * <p>Fails with the supplied failure {@code message}.
     */
    @Step("{message} is {expected}")
    public static void assertArrayEquals(double[] expected, double[] actual, double delta, String message) {
        Allure.getLifecycle().updateStep(stepResult -> stepResult.getParameters().clear());
        System.out.println(String.format("Assert that %s is %s", message, Arrays.toString(expected)));
        Assertions.assertArrayEquals(expected, actual, delta, message);
    }

    /**
     * <em>Assert</em> that {@code expected} and {@code actual} object arrays are deeply equal.
     * <p>If both are {@code null}, they are considered equal.
     * <p>Nested float arrays are checked as in {@link #assertEquals(float, float, String)}.
     * <p>Nested double arrays are checked as in {@link #assertEquals(double, double, String)}.
     * <p>Fails with the supplied failure {@code message}.
     *
     * @see Objects#equals(Object, Object)
     * @see Arrays#deepEquals(Object[], Object[])
     */
    @Step("{message} is {expected}")
    public static void assertArrayEquals(Object[] expected, Object[] actual, String message) {
        Allure.getLifecycle().updateStep(stepResult -> stepResult.getParameters().clear());
        System.out.println(String.format("Assert that %s is %s", message, Arrays.toString(expected)));
        Assertions.assertArrayEquals(expected, actual, message);
    }

    /**
     * <em>Assert</em> that {@code expected} and {@code actual} iterables are deeply equal.
     * <p>Similarly to the check for deep equality in
     * {@link #assertArrayEquals(Object[], Object[], String)}, if two iterables are encountered
     * (including {@code expected} and {@code actual}) then their iterators must return equal
     * elements in the same order as each other. <strong>Note:</strong> this means that the iterables
     * <em>do not</em> need to be of the same type. Example: <pre>{@code
     * import static java.util.Arrays.asList;
     *  . . .
     * Iterable<Integer> i0 = new ArrayList<>(asList(1, 2, 3));
     * Iterable<Integer> i1 = new LinkedList<>(asList(1, 2, 3));
     * assertIterableEquals(i0, i1); // Passes
     * }</pre>
     * <p>If both {@code expected} and {@code actual} are {@code null}, they are considered equal.
     * <p>Fails with the supplied failure {@code message}.
     *
     * @see Objects#equals(Object, Object)
     * @see Arrays#deepEquals(Object[], Object[])
     * @see #assertArrayEquals(Object[], Object[], String)
     */
    @Step("{message} is {expected}")
    public static void assertIterableEquals(Iterable<?> expected, Iterable<?> actual, String message) {
        Allure.getLifecycle().updateStep(stepResult -> stepResult.getParameters().clear());
        System.out.println(String.format("Assert that %s is %s", message, expected));
        Assertions.assertIterableEquals(expected, actual, message);
    }

    /**
     * <em>Assert</em> that {@code expected} list of {@linkplain String}s matches {@code actual}
     * list.
     *
     * <p>Fails with the supplied failure {@code message} and the generated message.
     *
     * @see #assertLinesMatch(List, List, String)
     */
    @Step("{message} is {expected}")
    public static void assertLinesMatch(List<String> expectedLines, List<String> actualLines, String message) {
        Allure.getLifecycle().updateStep(stepResult -> stepResult.getParameters().clear());
        System.out.println(String.format("Assert that %s is %s", message, expectedLines));
        Assertions.assertLinesMatch(expectedLines, actualLines, message);
    }

    /**
     * <em>Assert</em> that {@code expected} stream of {@linkplain String}s matches {@code actual}
     * stream.
     *
     * <p>Find a detailed description of the matching algorithm in {@link #assertLinesMatch(List, List, String)}.
     *
     * <p>Fails with the supplied failure {@code message} and the generated message.
     *
     * <p>Note: An implementation of this method may consume all lines of both streams eagerly and
     * delegate the evaluation to {@link #assertLinesMatch(List, List, String)}.
     *
     * @since 5.7
     * @see #assertLinesMatch(List, List, String)
     */
    @Step("{message} is {expected}")
    public static void assertLinesMatch(Stream<String> expectedLines, Stream<String> actualLines, String message) {
        Allure.getLifecycle().updateStep(stepResult -> stepResult.getParameters().clear());
        System.out.println(String.format("Assert that %s is %s", message, expectedLines));
        Assertions.assertLinesMatch(expectedLines, actualLines, message);
    }

    /**
     * <em>Assert</em> that {@code expected} and {@code actual} are not equal.
     *
     * <p>Fails with the supplied failure {@code message}.
     *
     * @since 5.4
     */
    @Step("{message} is {expected}")
    public static void assertNotEquals(byte unexpected, byte actual, String message) {
        Allure.getLifecycle().updateStep(stepResult -> stepResult.getParameters().clear());
        System.out.println(String.format("Assert that %s is not %s", message, unexpected));
        Assertions.assertNotEquals(unexpected, actual, message);
    }

    /**
     * <em>Assert</em> that {@code expected} and {@code actual} are not equal.
     *
     * <p>Fails with the supplied failure {@code message}.
     *
     * @since 5.4
     */
    @Step("{message} is {expected}")
    public static void assertNotEquals(byte unexpected, Byte actual, String message) {
        Allure.getLifecycle().updateStep(stepResult -> stepResult.getParameters().clear());
        System.out.println(String.format("Assert that %s is not %s", message, unexpected));
        Assertions.assertNotEquals((Byte) unexpected, actual, message);
    }

    /**
     * <em>Assert</em> that {@code expected} and {@code actual} are not equal.
     *
     * <p>Fails with the supplied failure {@code message}.
     *
     * @since 5.4
     */
    @Step("{message} is {expected}")
    public static void assertNotEquals(Byte unexpected, byte actual, String message) {
        Allure.getLifecycle().updateStep(stepResult -> stepResult.getParameters().clear());
        System.out.println(String.format("Assert that %s is not %s", message, unexpected));
        Assertions.assertNotEquals(unexpected, (Byte) actual, message);
    }

    /**
     * <em>Assert</em> that {@code expected} and {@code actual} are not equal.
     *
     * <p>Fails with the supplied failure {@code message}.
     *
     * @since 5.4
     */
    @Step("{message} is {expected}")
    public static void assertNotEquals(Byte unexpected, Byte actual, String message) {
        Allure.getLifecycle().updateStep(stepResult -> stepResult.getParameters().clear());
        System.out.println(String.format("Assert that %s is not %s", message, unexpected));
        Assertions.assertNotEquals(unexpected, actual, message);
    }

    /**
     * <em>Assert</em> that {@code expected} and {@code actual} are not equal.
     *
     * <p>Fails with the supplied failure {@code message}.
     *
     * @since 5.4
     */
    @Step("{message} is {expected}")
    public static void assertNotEquals(short unexpected, short actual, String message) {
        Allure.getLifecycle().updateStep(stepResult -> stepResult.getParameters().clear());
        System.out.println(String.format("Assert that %s is not %s", message, unexpected));
        Assertions.assertNotEquals(unexpected, actual, message);
    }

    /**
     * <em>Assert</em> that {@code expected} and {@code actual} are not equal.
     *
     * <p>Fails with the supplied failure {@code message}.
     *
     * @since 5.4
     */
    @Step("{message} is {expected}")
    public static void assertNotEquals(short unexpected, Short actual, String message) {
        Allure.getLifecycle().updateStep(stepResult -> stepResult.getParameters().clear());
        System.out.println(String.format("Assert that %s is not %s", message, unexpected));
        Assertions.assertNotEquals((Short) unexpected, actual, message);
    }

    /**
     * <em>Assert</em> that {@code expected} and {@code actual} are not equal.
     *
     * <p>Fails with the supplied failure {@code message}.
     *
     * @since 5.4
     */
    @Step("{message} is {expected}")
    public static void assertNotEquals(Short unexpected, short actual, String message) {
        Allure.getLifecycle().updateStep(stepResult -> stepResult.getParameters().clear());
        System.out.println(String.format("Assert that %s is not %s", message, unexpected));
        Assertions.assertNotEquals(unexpected, (Short) actual, message);
    }

    /**
     * <em>Assert</em> that {@code expected} and {@code actual} are not equal.
     *
     * <p>Fails with the supplied failure {@code message}.
     *
     * @since 5.4
     */
    @Step("{message} is {expected}")
    public static void assertNotEquals(Short unexpected, Short actual, String message) {
        Allure.getLifecycle().updateStep(stepResult -> stepResult.getParameters().clear());
        System.out.println(String.format("Assert that %s is not %s", message, unexpected));
        Assertions.assertNotEquals(unexpected, actual, message);
    }

    /**
     * <em>Assert</em> that {@code expected} and {@code actual} are not equal.
     *
     * <p>Fails with the supplied failure {@code message}.
     *
     * @since 5.4
     */
    @Step("{message} is {expected}")
    public static void assertNotEquals(int unexpected, int actual, String message) {
        Allure.getLifecycle().updateStep(stepResult -> stepResult.getParameters().clear());
        System.out.println(String.format("Assert that %s is not %s", message, unexpected));
        Assertions.assertNotEquals(unexpected, actual, message);
    }

    /**
     * <em>Assert</em> that {@code expected} and {@code actual} are not equal.
     *
     * <p>Fails with the supplied failure {@code message}.
     *
     * @since 5.4
     */
    @Step("{message} is {expected}")
    public static void assertNotEquals(int unexpected, Integer actual, String message) {
        Allure.getLifecycle().updateStep(stepResult -> stepResult.getParameters().clear());
        System.out.println(String.format("Assert that %s is not %s", message, unexpected));
        Assertions.assertNotEquals((Integer) unexpected, actual, message);
    }

    /**
     * <em>Assert</em> that {@code expected} and {@code actual} are not equal.
     *
     * <p>Fails with the supplied failure {@code message}.
     *
     * @since 5.4
     */
    @Step("{message} is {expected}")
    public static void assertNotEquals(Integer unexpected, int actual, String message) {
        Allure.getLifecycle().updateStep(stepResult -> stepResult.getParameters().clear());
        System.out.println(String.format("Assert that %s is not %s", message, unexpected));
        Assertions.assertNotEquals(unexpected, (Integer) actual, message);
    }

    /**
     * <em>Assert</em> that {@code expected} and {@code actual} are not equal.
     *
     * <p>Fails with the supplied failure {@code message}.
     *
     * @since 5.4
     */
    @Step("{message} is {expected}")
    public static void assertNotEquals(Integer unexpected, Integer actual, String message) {
        Allure.getLifecycle().updateStep(stepResult -> stepResult.getParameters().clear());
        System.out.println(String.format("Assert that %s is not %s", message, unexpected));
        Assertions.assertNotEquals(unexpected, actual, message);
    }

    /**
     * <em>Assert</em> that {@code expected} and {@code actual} are not equal.
     *
     * <p>Fails with the supplied failure {@code message}.
     *
     * @since 5.4
     */
    @Step("{message} is {expected}")
    public static void assertNotEquals(long unexpected, long actual, String message) {
        Allure.getLifecycle().updateStep(stepResult -> stepResult.getParameters().clear());
        System.out.println(String.format("Assert that %s is not %s", message, unexpected));
        Assertions.assertNotEquals(unexpected, actual, message);
    }

    /**
     * <em>Assert</em> that {@code expected} and {@code actual} are not equal.
     *
     * <p>Fails with the supplied failure {@code message}.
     *
     * @since 5.4
     */
    @Step("{message} is {expected}")
    public static void assertNotEquals(long unexpected, Long actual, String message) {
        Allure.getLifecycle().updateStep(stepResult -> stepResult.getParameters().clear());
        System.out.println(String.format("Assert that %s is not %s", message, unexpected));
        Assertions.assertNotEquals((Long) unexpected, actual, message);
    }

    /**
     * <em>Assert</em> that {@code expected} and {@code actual} are not equal.
     *
     * <p>Fails with the supplied failure {@code message}.
     *
     * @since 5.4
     */
    @Step("{message} is {expected}")
    public static void assertNotEquals(Long unexpected, long actual, String message) {
        Allure.getLifecycle().updateStep(stepResult -> stepResult.getParameters().clear());
        System.out.println(String.format("Assert that %s is not %s", message, unexpected));
        Assertions.assertNotEquals(unexpected, (Long) actual, message);
    }

    /**
     * <em>Assert</em> that {@code expected} and {@code actual} are not equal.
     *
     * <p>Fails with the supplied failure {@code message}.
     *
     * @since 5.4
     */
    @Step("{message} is {expected}")
    public static void assertNotEquals(Long unexpected, Long actual, String message) {
        Allure.getLifecycle().updateStep(stepResult -> stepResult.getParameters().clear());
        System.out.println(String.format("Assert that %s is not %s", message, unexpected));
        Assertions.assertNotEquals(unexpected, actual, message);
    }

    /**
     * <em>Assert</em> that {@code expected} and {@code actual} are not equal.
     *
     * <p>Inequality imposed by this method is consistent with
     * {@link Float#equals(Object)} and {@link Float#compare(float, float)}.
     *
     * <p>Fails with the supplied failure {@code message}.
     *
     * @since 5.4
     */
    @Step("{message} is {expected}")
    public static void assertNotEquals(float unexpected, float actual, String message) {
        Allure.getLifecycle().updateStep(stepResult -> stepResult.getParameters().clear());
        System.out.println(String.format("Assert that %s is not %s", message, unexpected));
        Assertions.assertNotEquals(unexpected, actual, message);
    }

    /**
     * <em>Assert</em> that {@code expected} and {@code actual} are not equal.
     *
     * <p>Inequality imposed by this method is consistent with
     * {@link Float#equals(Object)} and {@link Float#compare(float, float)}.
     *
     * <p>Fails with the supplied failure {@code message}.
     *
     * @since 5.4
     */
    @Step("{message} is {expected}")
    public static void assertNotEquals(float unexpected, Float actual, String message) {
        Allure.getLifecycle().updateStep(stepResult -> stepResult.getParameters().clear());
        System.out.println(String.format("Assert that %s is not %s", message, unexpected));
        Assertions.assertNotEquals((Float) unexpected, actual, message);
    }

    /**
     * <em>Assert</em> that {@code expected} and {@code actual} are not equal.
     *
     * <p>Inequality imposed by this method is consistent with
     * {@link Float#equals(Object)} and {@link Float#compare(float, float)}.
     *
     * <p>Fails with the supplied failure {@code message}.
     *
     * @since 5.4
     */
    @Step("{message} is {expected}")
    public static void assertNotEquals(Float unexpected, float actual, String message) {
        Allure.getLifecycle().updateStep(stepResult -> stepResult.getParameters().clear());
        System.out.println(String.format("Assert that %s is not %s", message, unexpected));
        Assertions.assertNotEquals(unexpected, (Float) actual, message);
    }

    /**
     * <em>Assert</em> that {@code expected} and {@code actual} are not equal.
     *
     * <p>Inequality imposed by this method is consistent with
     * {@link Float#equals(Object)} and {@link Float#compare(float, float)}.
     *
     * <p>Fails with the supplied failure {@code message}.
     *
     * @since 5.4
     */
    @Step("{message} is {expected}")
    public static void assertNotEquals(Float unexpected, Float actual, String message) {
        Allure.getLifecycle().updateStep(stepResult -> stepResult.getParameters().clear());
        System.out.println(String.format("Assert that %s is not %s", message, unexpected));
        Assertions.assertNotEquals(unexpected, actual, message);
    }

    /**
     * <em>Assert</em> that {@code expected} and {@code actual} are not equal
     * within the given {@code delta}.
     *
     * <p>Inequality imposed by this method is consistent with
     * {@link Float#equals(Object)} and {@link Float#compare(float, float)}.
     *
     * <p>Fails with the supplied failure {@code message}.
     *
     * @since 5.4
     */
    @Step("{message} is {expected}")
    public static void assertNotEquals(float unexpected, float actual, float delta, String message) {
        Allure.getLifecycle().updateStep(stepResult -> stepResult.getParameters().clear());
        System.out.println(String.format("Assert that %s is not %s", message, unexpected));
        Assertions.assertNotEquals(unexpected, actual, delta, message);
    }

    /**
     * <em>Assert</em> that {@code expected} and {@code actual} are not equal.
     *
     * <p>Inequality imposed by this method is consistent with
     * {@link Double#equals(Object)} and {@link Double#compare(double, double)}.
     *
     * <p>Fails with the supplied failure {@code message}.
     *
     * @since 5.4
     */
    @Step("{message} is {expected}")
    public static void assertNotEquals(double unexpected, double actual, String message) {
        Allure.getLifecycle().updateStep(stepResult -> stepResult.getParameters().clear());
        System.out.println(String.format("Assert that %s is not %s", message, unexpected));
        Assertions.assertNotEquals(unexpected, actual, message);
    }

    /**
     * <em>Assert</em> that {@code expected} and {@code actual} are not equal.
     *
     * <p>Inequality imposed by this method is consistent with
     * {@link Double#equals(Object)} and {@link Double#compare(double, double)}.
     *
     * <p>Fails with the supplied failure {@code message}.
     *
     * @since 5.4
     */
    @Step("{message} is {expected}")
    public static void assertNotEquals(double unexpected, Double actual, String message) {
        Allure.getLifecycle().updateStep(stepResult -> stepResult.getParameters().clear());
        System.out.println(String.format("Assert that %s is not %s", message, unexpected));
        Assertions.assertNotEquals((Double) unexpected, actual, message);
    }

    /**
     * <em>Assert</em> that {@code expected} and {@code actual} are not equal.
     *
     * <p>Inequality imposed by this method is consistent with
     * {@link Double#equals(Object)} and {@link Double#compare(double, double)}.
     *
     * <p>Fails with the supplied failure {@code message}.
     *
     * @since 5.4
     */
    @Step("{message} is {expected}")
    public static void assertNotEquals(Double unexpected, double actual, String message) {
        Allure.getLifecycle().updateStep(stepResult -> stepResult.getParameters().clear());
        System.out.println(String.format("Assert that %s is not %s", message, unexpected));
        Assertions.assertNotEquals(unexpected, (Double) actual, message);
    }

    /**
     * <em>Assert</em> that {@code expected} and {@code actual} are not equal.
     *
     * <p>Inequality imposed by this method is consistent with
     * {@link Double#equals(Object)} and {@link Double#compare(double, double)}.
     *
     * <p>Fails with the supplied failure {@code message}.
     *
     * @since 5.4
     */
    @Step("{message} is {expected}")
    public static void assertNotEquals(Double unexpected, Double actual, String message) {
        Allure.getLifecycle().updateStep(stepResult -> stepResult.getParameters().clear());
        System.out.println(String.format("Assert that %s is not %s", message, unexpected));
        Assertions.assertNotEquals(unexpected, actual, message);
    }

    /**
     * <em>Assert</em> that {@code expected} and {@code actual} are not equal
     * within the given {@code delta}.
     *
     * <p>Inequality imposed by this method is consistent with
     * {@link Double#equals(Object)} and {@link Double#compare(double, double)}.
     *
     * <p>Fails with the supplied failure {@code message}.
     *
     * @since 5.4
     */
    @Step("{message} is {expected}")
    public static void assertNotEquals(double unexpected, double actual, double delta, String message) {
        Allure.getLifecycle().updateStep(stepResult -> stepResult.getParameters().clear());
        System.out.println(String.format("Assert that %s is not %s", message, unexpected));
        Assertions.assertNotEquals(unexpected, actual, delta, message);
    }

    /**
     * <em>Assert</em> that {@code expected} and {@code actual} are not equal.
     *
     * <p>Fails with the supplied failure {@code message}.
     *
     * @since 5.4
     */
    @Step("{message} is {expected}")
    public static void assertNotEquals(char unexpected, char actual, String message) {
        Allure.getLifecycle().updateStep(stepResult -> stepResult.getParameters().clear());
        System.out.println(String.format("Assert that %s is not %s", message, unexpected));
        Assertions.assertNotEquals(unexpected, actual, message);
    }

    /**
     * <em>Assert</em> that {@code expected} and {@code actual} are not equal.
     *
     * <p>Fails with the supplied failure {@code message}.
     *
     * @since 5.4
     */
    @Step("{message} is {expected}")
    public static void assertNotEquals(char unexpected, Character actual, String message) {
        Allure.getLifecycle().updateStep(stepResult -> stepResult.getParameters().clear());
        System.out.println(String.format("Assert that %s is not %s", message, unexpected));
        Assertions.assertNotEquals((Character) unexpected, actual, message);
    }

    /**
     * <em>Assert</em> that {@code expected} and {@code actual} are not equal.
     *
     * <p>Fails with the supplied failure {@code message}.
     *
     * @since 5.4
     */
    @Step("{message} is {expected}")
    public static void assertNotEquals(Character unexpected, char actual, String message) {
        Allure.getLifecycle().updateStep(stepResult -> stepResult.getParameters().clear());
        System.out.println(String.format("Assert that %s is not %s", message, unexpected));
        Assertions.assertNotEquals(unexpected, (Character) actual, message);
    }

    /**
     * <em>Assert</em> that {@code expected} and {@code actual} are not equal.
     *
     * <p>Fails with the supplied failure {@code message}.
     *
     * @since 5.4
     */
    @Step("{message} is {expected}")
    public static void assertNotEquals(Character unexpected, Character actual, String message) {
        Allure.getLifecycle().updateStep(stepResult -> stepResult.getParameters().clear());
        System.out.println(String.format("Assert that %s is not %s", message, unexpected));
        Assertions.assertNotEquals(unexpected, actual, message);
    }

    /**
     * <em>Assert</em> that {@code expected} and {@code actual} are not equal.
     *
     * <p>Fails if both are {@code null}.
     *
     * <p>Fails with the supplied failure {@code message}.
     *
     * @see Object#equals(Object)
     */
    @Step("{message} is {expected}")
    public static void assertNotEquals(Object unexpected, Object actual, String message) {
        Allure.getLifecycle().updateStep(stepResult -> stepResult.getParameters().clear());
        System.out.println(String.format("Assert that %s is not %s", message, unexpected));
        Assertions.assertNotEquals(unexpected, actual, message);
    }

    /**
     * <em>Assert</em> that {@code expected} and {@code actual} refer to the same object.
     * <p>Fails with the supplied failure {@code message}.
     */
    @Step("{message} is {expected}")
    public static void assertSame(Object expected, Object actual, String message) {
        Allure.getLifecycle().updateStep(stepResult -> stepResult.getParameters().clear());
        System.out.println(String.format("Assert that %s is %s", message, expected));
        Assertions.assertSame(expected, actual, message);
    }

    /**
     * <em>Assert</em> that {@code expected} and {@code actual} do not refer to the same object.
     * <p>Fails with the supplied failure {@code message}.
     */
    @Step("{message} is {expected}")
    public static void assertNotSame(Object unexpected, Object actual, String message) {
        Allure.getLifecycle().updateStep(stepResult -> stepResult.getParameters().clear());
        System.out.println(String.format("Assert that %s is not %s", message, unexpected));
        Assertions.assertNotSame(unexpected, actual, message);
    }


    // --- assertAll -----------------------------------------------------------

    /**
     * <em>Assert</em> that <em>all</em> supplied {@code executables} do not throw
     * exceptions.
     *
     * <p>See Javadoc for {@link #assertAll(String, Stream)} for an explanation of this
     * method's exception handling semantics.
     *
     * @see #assertAll(String, Executable...)
     * @see #assertAll(Collection)
     * @see #assertAll(String, Collection)
     * @see #assertAll(Stream)
     * @see #assertAll(String, Stream)
     */
    public static void assertAll(Executable... executables) throws MultipleFailuresError {
        Assertions.assertAll(executables);
    }

    /**
     * <em>Assert</em> that <em>all</em> supplied {@code executables} do not throw
     * exceptions.
     *
     * <p>See Javadoc for {@link #assertAll(String, Stream)} for an explanation of this
     * method's exception handling semantics.
     *
     * @see #assertAll(String, Executable...)
     * @see #assertAll(Collection)
     * @see #assertAll(String, Collection)
     * @see #assertAll(Stream)
     * @see #assertAll(String, Stream)
     */
    @Step("{stepTitle} - verification")
    public static void assertAll(String stepTitle, Executable... executables) throws MultipleFailuresError {
        Allure.getLifecycle().updateStep(stepResult -> stepResult.getParameters().clear());
        Assertions.assertAll(executables);
    }

    /**
     * <em>Assert</em> that <em>all</em> supplied {@code executables} do not throw
     * exceptions.
     *
     * <p>See Javadoc for {@link #assertAll(String, Stream)} for an explanation of this
     * method's exception handling semantics.
     *
     * @see #assertAll(Executable...)
     * @see #assertAll(String, Executable...)
     * @see #assertAll(String, Collection)
     * @see #assertAll(Stream)
     * @see #assertAll(String, Stream)
     */
    public static void assertAll(Collection<Executable> executables) throws MultipleFailuresError {
        Assertions.assertAll(executables);
    }

    /**
     * <em>Assert</em> that <em>all</em> supplied {@code executables} do not throw
     * exceptions.
     *
     * <p>See Javadoc for {@link #assertAll(String, Stream)} for an explanation of this
     * method's exception handling semantics.
     *
     * @see #assertAll(Executable...)
     * @see #assertAll(String, Executable...)
     * @see #assertAll(Collection)
     * @see #assertAll(Stream)
     * @see #assertAll(String, Stream)
     */
    public static void assertAll(String heading, Collection<Executable> executables) throws MultipleFailuresError {
        Assertions.assertAll(heading, executables);
    }

    /**
     * <em>Assert</em> that <em>all</em> supplied {@code executables} do not throw
     * exceptions.
     *
     * <p>See Javadoc for {@link #assertAll(String, Stream)} for an explanation of this
     * method's exception handling semantics.
     *
     * @see #assertAll(Executable...)
     * @see #assertAll(String, Executable...)
     * @see #assertAll(Collection)
     * @see #assertAll(String, Collection)
     * @see #assertAll(String, Stream)
     */
    public static void assertAll(Stream<Executable> executables) throws MultipleFailuresError {
        Assertions.assertAll(executables);
    }

    /**
     * <em>Assert</em> that <em>all</em> supplied {@code executables} do not throw
     * exceptions.
     *
     * <p>If any supplied {@link Executable} throws an exception (i.e., a {@link Throwable}
     * or any subclass thereof), all remaining {@code executables} will still be executed,
     * and all exceptions will be aggregated and reported in a {@link MultipleFailuresError}.
     * In addition, all aggregated exceptions will be added as {@linkplain
     * Throwable#addSuppressed(Throwable) suppressed exceptions} to the
     * {@code MultipleFailuresError}. However, if an {@code executable} throws an
     * <em>unrecoverable</em> exception &mdash; for example, an {@link OutOfMemoryError}
     * &mdash; execution will halt immediately, and the unrecoverable exception will be
     * rethrown <em>as is</em> but <em>masked</em> as an unchecked exception.
     *
     * <p>The supplied {@code heading} will be included in the message string for the
     * {@code MultipleFailuresError}.
     *
     * @see #assertAll(Executable...)
     * @see #assertAll(String, Executable...)
     * @see #assertAll(Collection)
     * @see #assertAll(String, Collection)
     * @see #assertAll(Stream)
     */
    public static void assertAll(String heading, Stream<Executable> executables) throws MultipleFailuresError {
        Assertions.assertAll(heading, executables);
    }

    public static void waitAssertEquals(String message, int timeoutSec, Object expected, Callable<?> action) {
        waitAssertEquals(message, 1, timeoutSec, expected, action);
    }

    public static void waitAssertEquals(String message, int intervalSec, int timeoutSec, Object expected, Callable<?> action) {
        waitAssertEquals(message, 0, intervalSec, timeoutSec, expected, action);
    }

    public static void waitAssertEquals(String message, int initialDelaySec, int intervalSec, int timeoutSec, Object expected, Callable<?> action) {
        Object current = null;
        boolean status = false;
        long end = System.currentTimeMillis() + timeoutSec * 1000L;
        Utils.delay(initialDelaySec);
        while (!status && System.currentTimeMillis() < end) {
            try {
                current = action.call();
                status = expected.equals(current);
                if (!status)
                    Utils.delay(intervalSec);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if (!status)
            assertEquals(expected, current, "[Timeout: " + timeoutSec + " sec] " + message);
    }

    public static void waitAssertEquals(String message, int initialDelay, int intervalSec, int timeoutSec, Object expected, Callable<?> action, Executable finalAction) {
        Object current = null;
        boolean status = false;
        long end = System.currentTimeMillis() + timeoutSec * 1000L;
        Utils.delay(initialDelay);
        while (!status && System.currentTimeMillis() < end) {
            try {
                current = action.call();
                status = expected.equals(current);
                if (!status)
                    Utils.delay(intervalSec);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if (!status) {
            try {
                finalAction.execute();
            } catch (Throwable e) {
                e.printStackTrace();
            }
            assertEquals(expected, current, "[Timeout: " + timeoutSec + " sec] " + message);
        }
    }

    public static int waitAssertEqualsStep(String message, int intervalSec, int timeoutSec, Object expected, Callable<?> action1, Callable<?> action2) {
        return waitAssertEquals(message, 0, intervalSec, timeoutSec, expected, action1, action2);
    }

    @Step("{message}")
    public static int waitAssertEqualsStep(String message, int initialDelay, int intervalSec, int timeoutSec, Object expected, Callable<?> action1, Callable<?> action2) {
        return waitAssertEquals(message, initialDelay, intervalSec, timeoutSec, expected, action1, action2);
    }

    public static int waitAssertEquals(String message, int initialDelay, int intervalSec, int timeoutSec, Object expected, Callable<?> action1, Callable<?> action2) {
        Object current = null;
        boolean status = false;
        long end = System.currentTimeMillis() + timeoutSec * 1000L;
        Utils.delay(initialDelay);
        while (!status && System.currentTimeMillis() < end) {
            try {
                current = action1.call();
                status = expected.equals(current);
                if (!status) {
                    current = action2.call();
                    status = expected.equals(current);
                    if (!status)
                        Utils.delay(intervalSec);
                    else
                        return 2;
                } else
                    return 1;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if (!status)
            assertEquals(expected, current, "[Timeout: " + timeoutSec + " sec] " + message);
        return 0;
    }

    public static void waitAssertIn(String message, int timeoutSec, Set<?> expected, Callable<?> action) {
        waitAssertIn(message, 1, timeoutSec, expected, action);
    }

    public static void waitAssertIn(String message, int intervalSec, int timeoutSec, Set<?> expected, Callable<?> action) {
        Object current = null;
        boolean status = false;
        long end = System.currentTimeMillis() + timeoutSec * 1000L;
        while (!status && System.currentTimeMillis() < end) {
            try {
                current = action.call();
                status = expected.contains(current);
                if (!status)
                    Utils.delay(intervalSec);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if (!status)
            assertIn(expected, current, "[Timeout: " + timeoutSec + " sec] " + message);
    }

}
