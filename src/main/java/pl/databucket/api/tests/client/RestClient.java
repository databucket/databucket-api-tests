package pl.databucket.api.tests.client;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.filter.LoggingFilter;
import com.sun.jersey.client.urlconnection.URLConnectionClientHandler;
import com.sun.jersey.core.util.MultivaluedMapImpl;
import org.apache.commons.lang3.ArrayUtils;
import pl.databucket.api.tests.utils.SSLFix;

import javax.ws.rs.core.MultivaluedMap;
import java.net.Proxy;
import java.util.List;
import java.util.Map;

public class RestClient {

    private final Client client;
    protected final ObjectMapper jsonMapper = new ObjectMapper();
    protected final XmlMapper xmlMapper = new XmlMapper();
    private final MultivaluedMap<String, String> headers = new MultivaluedMapImpl();

    public RestClient(boolean logs, Proxy proxy) {
        SSLFix.execute(); // disable checking certificate
        jsonMapper.registerModule(new JavaTimeModule());
        xmlMapper.setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);
        xmlMapper.enable(SerializationFeature.INDENT_OUTPUT);
        xmlMapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);

        ConnectionFactory connectionFactory = new ConnectionFactory();
        connectionFactory.initializeProxy(proxy);
        URLConnectionClientHandler clientHandler = new URLConnectionClientHandler(connectionFactory);
        client = new Client(clientHandler);
        if (logs)
            client.addFilter(new LoggingFilter(System.out));
    }

    public MultivaluedMap<String, String> getHeaders() {
        return headers;
    }

    public void putHeader(String key, String value) {
        headers.putSingle(key, value);
    }

    public void putHeader(String key, List<String> value) {
        headers.put(key, value);
    }

    private void setBuilderHeaders(WebResource.Builder builder, MultivaluedMap<String, String> headers) {
        for (Map.Entry<String, List<String>> entry : headers.entrySet()) {
            String value = entry.getValue().toString();
            builder = builder.header(entry.getKey(), value.substring(1, value.length() - 1));
        }
    }

    public RequestResponse get(MultivaluedMap<String, String> requestHeaders, String resourceUrl, int expectedStatus) {
        return get(requestHeaders, resourceUrl, null, expectedStatus);
    }

    public RequestResponse get(MultivaluedMap<String, String> requestHeaders, String resourceUrl, MultivaluedMap<String, String> queryParams, int expectedStatus) {
        WebResource webResource = client.resource(resourceUrl);
        if (queryParams != null)
            webResource = webResource.queryParams(queryParams);
        WebResource.Builder builder = webResource.getRequestBuilder();
        setBuilderHeaders(builder, requestHeaders);

        RequestResponse requestResponse = new RequestResponse();
        requestResponse.setRequestMethod("GET");
        requestResponse.setRequestHeaders(requestHeaders);
        requestResponse.setRequestUrl(webResource.getURI().toString());

        long start = System.currentTimeMillis();
        try {
            ClientResponse response = builder.get(ClientResponse.class);

            requestResponse.setResponseStatus(response.getStatus());
            requestResponse.setResponseCorrect(response.getStatus() == expectedStatus);
            requestResponse.setResponseHeaders(response.getHeaders());
            requestResponse.setResponseBody(response.getEntity(String.class));
        } catch (Exception e) {
            requestResponse.setResponseCorrect(false);
            requestResponse.setException(e);
        } finally {
            requestResponse.setResponseDuration(System.currentTimeMillis() - start);
        }

        return requestResponse;
    }

    public RequestResponse post(MultivaluedMap<String, String> requestHeaders, String resourceUrl, String payload, int expectedStatus) {
        WebResource webResource = client.resource(resourceUrl);
        WebResource.Builder builder = webResource.getRequestBuilder();
        setBuilderHeaders(builder, requestHeaders);

        RequestResponse requestResponse = new RequestResponse();
        requestResponse.setRequestMethod("POST");
        requestResponse.setRequestHeaders(requestHeaders);
        requestResponse.setRequestBody(payload);
        requestResponse.setRequestUrl(webResource.getURI().toString());

        long start = System.currentTimeMillis();
        try {
            ClientResponse response = builder.post(ClientResponse.class, payload);

            requestResponse.setResponseStatus(response.getStatus());
            requestResponse.setResponseCorrect(response.getStatus() == expectedStatus);
            requestResponse.setResponseHeaders(response.getHeaders());
            requestResponse.setResponseBody(response.getEntity(String.class));
        } catch (Exception e) {
            requestResponse.setResponseCorrect(false);
            requestResponse.setException(e);
        } finally {
            requestResponse.setResponseDuration(System.currentTimeMillis() - start);
        }

        return requestResponse;
    }

    public RequestResponse put(MultivaluedMap<String, String> requestHeaders, String resourceUrl, String payload, int acceptedStatus) {
        return put(requestHeaders, resourceUrl, payload, new int[] {acceptedStatus});
    }

    public RequestResponse put(MultivaluedMap<String, String> requestHeaders, String resourceUrl, String payload, int [] acceptedStatuses) {
        WebResource webResource = client.resource(resourceUrl);
        WebResource.Builder builder = webResource.getRequestBuilder();
        setBuilderHeaders(builder, requestHeaders);

        RequestResponse requestResponse = new RequestResponse();
        requestResponse.setRequestMethod("PUT");
        requestResponse.setRequestHeaders(requestHeaders);
        requestResponse.setRequestBody(payload);
        requestResponse.setRequestUrl(webResource.getURI().toString());

        long start = System.currentTimeMillis();
        try {
            ClientResponse response = builder.put(ClientResponse.class, payload);
            requestResponse.setResponseStatus(response.getStatus());
            requestResponse.setResponseCorrect(ArrayUtils.contains(acceptedStatuses, response.getStatus()));
            requestResponse.setResponseHeaders(response.getHeaders());
            requestResponse.setResponseBody(response.getEntity(String.class));
        } catch (Exception e) {
            requestResponse.setResponseCorrect(false);
            requestResponse.setException(e);
        } finally {
            requestResponse.setResponseDuration(System.currentTimeMillis() - start);
        }

        return requestResponse;
    }
}
