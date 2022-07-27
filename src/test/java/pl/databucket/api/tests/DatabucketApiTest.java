package pl.databucket.api.tests;

import pl.databucket.api.tests.client.Bucket;
import pl.databucket.api.tests.client.Databucket;
import pl.databucket.api.tests.client.RequestResponse;
import pl.databucket.api.tests.model.Data;
import pl.databucket.api.tests.utils.Context;

public class DatabucketApiTest extends BaseTest {

    protected Databucket databucket= Context.getDatabucket();
    protected Bucket usersBucket = new Bucket(databucket, Context.getEnv() + "-users");
    protected Data data;
    protected RequestResponse requestResponse;

}
