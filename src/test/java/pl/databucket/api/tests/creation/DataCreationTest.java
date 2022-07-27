package pl.databucket.api.tests.creation;

import io.qameta.allure.Description;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pl.databucket.api.tests.DatabucketApiTest;
import pl.databucket.api.tests.client.Bucket;
import pl.databucket.api.tests.model.Data;
import pl.databucket.api.tests.utils.Context;
import pl.databucket.api.tests.utils.CustomAssertions;

import static pl.databucket.api.tests.utils.CustomAssertions.*;

@Tag("data")
@Tag("regression")
@DisplayName("Data creation")
public class DataCreationTest extends DatabucketApiTest {

    @Test
    @DisplayName("Insert empty data")
    @Description("We expect to have as a result a data with some nulls and some values set up during insertion.")
    void insertEmptyDataTest() {

        Given("the empty data", () -> {
            data = new Data();
        });

        When("insert data into the bucket", () -> {
            requestResponse = usersBucket.insertData(data);
        });

        Then("the response is correct", () -> {
            CustomAssertions.assertAll("Response",
                    () -> assertEquals(201, requestResponse.getResponseStatus(), "Response status"),
                    () -> assertEquals("application/json", requestResponse.getResponseHeaders().getFirst("Content-Type"), "Response content type")
            );

            data = Bucket.strToData(requestResponse.getResponseBody());
            CustomAssertions.assertAll("Response body",
                    () -> assertTrue(data.getId() > 0, "id"),
                    () -> assertNull(data.getTagId(), "tagId"),
                    () -> assertFalse(data.getReserved(), "reserved"),
                    () -> assertNull(data.getOwner(), "owner"),
                    () -> assertNull(data.getProperties(), "properties"),
                    () -> assertEquals(Context.getUserName(), data.getCreatedBy(), "createdBy"),
                    () -> assertNotNull(data.getCreatedAt(), "createdAt"),
                    () -> assertEquals(Context.getUserName(), data.getModifiedBy(), "modifiedBy"),
                    () -> assertNotNull(data.getModifiedAt(), "modifiedAt")
            );
        });
    }

    @Test
    @DisplayName("Insert full data")
    @Description("We expect to have as a result a data with all fields filled up.")
    void insertFullDataTest() {

        Given("the full data", () -> {
            data = new Data();
            data.setTagId(1);
            data.setReserved(true);
            data.setProperty("$.booleanItem", true);
            data.setProperty("$.stringItem", "Some text");
            data.setProperty("$.intItem", 15);
            data.setProperty("$.floatItem", 10.01);
            data.setProperty("$.nullItem", null);
        });

        When("insert data into the bucket", () -> {
            requestResponse = usersBucket.insertData(data);
        });

        Then("the response is correct", () -> {
            CustomAssertions.assertAll("Response",
                    () -> assertEquals(201, requestResponse.getResponseStatus(), "Response status"),
                    () -> assertEquals("application/json", requestResponse.getResponseHeaders().getFirst("Content-Type"), "Response content type")
            );

            data = Bucket.strToData(requestResponse.getResponseBody());
            CustomAssertions.assertAll("Response body",
                    () -> assertTrue(data.getId() > 0, "id"),
                    () -> assertEquals(1, data.getTagId(), "tagId"),
                    () -> assertTrue(data.getReserved(), "reserved"),
                    () -> assertEquals(Context.getUserName(), data.getOwner(), "owner"),
                    () -> assertNotNull(data.getProperties(), "properties"),
                    () -> assertEquals(Context.getUserName(), data.getCreatedBy(), "createdBy"),
                    () -> assertNotNull(data.getCreatedAt(), "createdAt"),
                    () -> assertEquals(Context.getUserName(), data.getModifiedBy(), "modifiedBy"),
                    () -> assertNotNull(data.getModifiedAt(), "modifiedAt")
            );

            data.setProperty("$.booleanItem", true);
            data.setProperty("$.stringItem", "Some text");
            data.setProperty("$.intItem", 15);
            data.setProperty("$.floatItem", 10.01);
            data.setProperty("$.nullItem", null);

            CustomAssertions.assertAll("Response body properties",
                    () -> assertEquals(true, data.getProperty("$.booleanItem"), "$.booleanItem"),
                    () -> assertEquals("Some text", data.getProperty("$.stringItem"), "$.stringItem"),
                    () -> assertEquals(15, data.getProperty("$.intItem"), "$.intItem"),
                    () -> assertEquals(10.01, data.getProperty("$.floatItem"), "$.floatItem"),
                    () -> assertEquals(null, data.getProperty("$.nullItem"), "$.nullItem")
            );
        });
    }

}
