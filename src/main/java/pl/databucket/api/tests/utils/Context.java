package pl.databucket.api.tests.utils;

import pl.databucket.api.tests.client.Databucket;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.util.Properties;

public class Context {

    static Properties properties;
    static Databucket databucket;
    public static boolean initiated = false;

    public static void setupConfiguration() {
        properties = new Properties();
        final String TEST_PROPERTIES_PATH = "build/test.properties";
        try {
            properties.load(new FileInputStream(TEST_PROPERTIES_PATH));
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Initiate Databucket
        Proxy proxy = Proxy.NO_PROXY;
        if (!isPropertyNull("databucket.proxy.host")) {
            try {
                proxy = new Proxy(Proxy.Type.HTTP, new InetSocketAddress(
                        InetAddress.getByName(getProperty("databucket.proxy.host")),
                        Integer.parseInt(getProperty("databucket.proxy.port"))));
            } catch (java.net.UnknownHostException e) {
                e.printStackTrace();
            }
        }

        databucket = new Databucket(
                getProperty("databucket.url"),
                getProperty("databucket.username"),
                getProperty("databucket.password"),
                Integer.parseInt(getProperty("databucket.projectId")),
                false,
                proxy);
    }

    public static boolean isInitiatingCompleted() {
        return databucket != null;
    }

    public static Boolean getBooleanProperty(String key) {
        String value = getProperty(key);
        return value.equalsIgnoreCase("true");
    }

    public static Integer getIntProperty(String key) {
        String value = getProperty(key);
        return Integer.parseInt(value);
    }

    public static boolean containsKey(String key) {
        return properties.containsKey(key);
    }

    public static String getProperty(String key) {
        if (!properties.containsKey(key))
            throw new RuntimeException("Missing expected context property '" + key + "'. It could be caused by setting up incorrect environment in the config.groovy.");

        return properties.getProperty(key);
    }

    public static boolean isPropertyNull(String key) {
        String value = getProperty(key);
        return value == null || value.equals("null");
    }


    public static void setProperty(String key, String value) {
        properties.setProperty(key, value);
    }

    public static String getEnv() {
        return getProperty("env");
    }

    public static String getUserName() {
        return getProperty("databucket.username");
    }

    public static Databucket getDatabucket() {
        return databucket;
    }

}

