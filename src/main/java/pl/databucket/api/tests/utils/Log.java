package pl.databucket.api.tests.utils;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.google.gson.*;
import io.qameta.allure.Allure;
import io.qameta.allure.Step;
import org.w3c.dom.Document;
import org.xml.sax.InputSource;
import pl.databucket.api.tests.client.RequestResponse;

import javax.ws.rs.core.MultivaluedMap;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.StringReader;
import java.io.StringWriter;
import java.io.Writer;
import java.util.Arrays;
import java.util.Locale;
import java.util.Map;

public class Log {

    private static Gson gson = new GsonBuilder().serializeNulls().disableHtmlEscaping().setPrettyPrinting().create();
    private static ObjectMapper jsonMapper = new ObjectMapper().registerModule(new JavaTimeModule()).setSerializationInclusion(JsonInclude.Include.NON_NULL);

    public static void error(Exception e) {
        Allure.addAttachment("Exception", e.getMessage());
        e.printStackTrace();
    }

    public static void error(String message) {
        Allure.addAttachment("Exception", message);
        System.err.println(message);
    }

    public static void textInfo(String name, String content) {
        Allure.addAttachment(name, content);
        System.out.println(content);
    }

    public static void jsonInfo(String name, String content) {
        Allure.addAttachment(name, "application/json", content);
        System.out.println(content);
    }

    public static void jsonInfo(String name, Map<String, Object> content) {
        Allure.addAttachment(name, "application/json", gson.toJson(content));
        System.out.println(gson.toJson(content));
    }

    @Step("{name}")
    public static void jsonInfoStep(String name, Object content) {
        Allure.getLifecycle().updateStep(stepResult -> stepResult.getParameters().clear());
        String contentStr;
        try {
            contentStr = jsonMapper.writerWithDefaultPrettyPrinter().writeValueAsString(content);
        } catch (Exception e) {
            contentStr = e.getMessage();
        }
        Allure.addAttachment(name, "application/json", contentStr);
        System.out.println(contentStr);
    }

    public static void xmlInfo(String name, String content) {
        Allure.addAttachment(name, "application/xml", content);
        System.out.println(content);
    }

    @Step("Incorrect response for an unreported request!")
    public static void incorrectRequestResponse(RequestResponse rr) {
        Allure.getLifecycle().updateStep(stepResult -> stepResult.getParameters().clear());
        requestResponse(rr);
    }

    @Step("{title}")
    public static void requestResponseStep(RequestResponse rr, String title) {
        Allure.getLifecycle().updateStep(stepResult -> stepResult.getParameters().clear());
        requestResponse(rr);
    }

    public static void requestResponse(RequestResponse rr) {
        String logCustomConfigName = null;
        boolean enabledLogInAllure = true;
        boolean enabledLogHeadersInAllure = true;
        boolean enabledLogInCIConsole = true;
        boolean enabledLogHeadersInCIConsole = true;
        boolean enabledLogInIDEConsole = true;
        boolean enabledLogHeadersInIDEConsole = true;

        try {
            String requestType = rr.getRequestHeaders().getFirst("Content-Type");
            if (requestType.toLowerCase(Locale.ROOT).contains("application")
                    && !requestType.toLowerCase(Locale.ROOT).contains("xml")
                    && !requestType.toLowerCase(Locale.ROOT).contains("json"))
                requestType = "text/plain";
            String requestName = rr.getRequestMethod() + " " + rr.getRequestUrl();
            String responseType = "text/plain";
            if (rr.getResponseHeaders() != null && rr.getResponseHeaders().containsKey("Content-Type")) {
                responseType = rr.getResponseHeaders().getFirst("Content-Type");
                if (responseType.contains(";"))
                    responseType = requestType.split(";")[0];
            }

            String responseName = "Exception!";
            if (rr.getResponseStatus() != null)
                responseName = "Response received in " + prettyDuration(rr.getResponseDuration()) + " with status: " + rr.getResponseStatus();

            logAllureRequestResponse(rr, enabledLogInAllure, enabledLogHeadersInAllure, requestName, requestType, responseName, responseType);
            printRequestResponse(rr, enabledLogInIDEConsole, enabledLogHeadersInIDEConsole, requestName, requestType, responseName, responseType);

        } catch (Exception e) {
            error(e);
        }
    }

    private static void logAllureRequestResponse(
            RequestResponse rr,
            boolean enabledLog,
            boolean enabledLogHeader,
            String requestName,
            String requestType,
            String responseName,
            String responseType) {

        if (enabledLogHeader)
            Allure.addAttachment("Request headers", prettyHeaders(rr.getRequestHeaders()));

        if (enabledLog)
            if (rr.getRequestBody() != null)
                Allure.addAttachment(requestName, requestType, prettyHeaders(requestType, rr.getRequestBody()));
            else
                Allure.addAttachment(requestName, requestType, "");

        if (enabledLogHeader && rr.getResponseHeaders() != null)
            Allure.addAttachment("Response headers", prettyHeaders(rr.getResponseHeaders()));

        if (enabledLog && rr.getResponseBody() != null)
            Allure.addAttachment(responseName, responseType, prettyHeaders(responseType, rr.getResponseBody()));

        if (enabledLog && !rr.isResponseCorrect() && rr.getException() != null)
            Allure.addAttachment("Exception", rr.getException().getMessage());
    }

    private static void printRequestResponse(
            RequestResponse rr,
            boolean enabledLog,
            boolean enabledLogHeader,
            String requestName,
            String requestType,
            String responseName,
            String responseType) {

        // Divider
        if (enabledLog || enabledLogHeader)
            System.out.println("\n" + getDivider());

        // Request
        if (enabledLogHeader)
            System.out.println(prettyHeaders(rr.getRequestHeaders()));

        if (enabledLog)
            if (rr.getRequestBody() != null)
                System.out.println(requestName + "\n" + prettyHeaders(requestType, rr.getRequestBody()));
            else
                System.out.println(requestName);

        // Response
        if (enabledLogHeader && rr.getResponseHeaders() != null)
            System.out.println("\n" + prettyHeaders(rr.getResponseHeaders()));
        if (enabledLog)
            if (rr.getResponseBody() != null)
                System.out.println(responseName + "\n" + prettyHeaders(responseType, rr.getResponseBody()));
            else
                System.out.println(responseName);

        // Print Exception
        if (enabledLog && !rr.isResponseCorrect() && rr.getException() != null)
            rr.getException().printStackTrace();
    }

    private static String getDivider() {
        return "--------------------------------------------------------------------------------------------------------------------------------------";
    }

    private static String prettyHeaders(String type, String content) {
        if (type.contains("json")) {
            try {
                JsonElement je = JsonParser.parseString(content);
                return gson.toJson(je);
            } catch (JsonSyntaxException e) {
                return content;
            }
        } else if (type.contains("xml")) {
            try {
                InputSource src = new InputSource(new StringReader(content));
                Document document = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(src);

                TransformerFactory transformerFactory = TransformerFactory.newInstance();
                transformerFactory.setAttribute("indent-number", 2);
                Transformer transformer = transformerFactory.newTransformer();
                transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
                transformer.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "yes");
                transformer.setOutputProperty(OutputKeys.INDENT, "yes");

                Writer out = new StringWriter();
                transformer.transform(new DOMSource(document), new StreamResult(out));
                return out.toString().replaceAll("(?m)^[ \t]*\r?\n", "");
            } catch (Exception e) {
                throw new RuntimeException("Error occurs when pretty-printing xml:\n" + content, e);
            }
        }
        return content;
    }

    private static String prettyHeaders(MultivaluedMap<String, String> headers) {
        StringBuilder sb = new StringBuilder();
        headers.forEach((key, value) -> {
            String v = protectSensitiveData(key, value.toString());
            sb.append(key).append(": ").append(v, 1, v.length() - 1).append("\n");
        });
        return sb.toString();
    }

    private static String protectSensitiveData(String key, String value) {
        String [] sensitive = {"AUTHORIZATION", "APIKEY"};
        if (Arrays.asList(sensitive).contains(key.toUpperCase(Locale.ROOT)))
            return Utils.shorten(value);
        else
            return value;
    }

    private static String prettyDuration(long duration) {
        long min = (duration / 1000) / 60;
        long sec = (duration / 1000) % 60;
        long ms = duration % 1000;

        String result = "";
        if (min > 0)
            result += min + " min ";
        if (sec > 0)
            result += sec + " sec ";
        if (ms > 0)
            result += ms + " ms";

        return result;
    }

    public static String getDatabucketErrorMessage(RequestResponse rr) {
        return "Response status: " + rr.getResponseStatus() + "\n\n" + rr.getResponseBody();
    }

}
