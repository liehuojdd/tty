import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.io.IOException;

public class BaseClass {//step 4
    protected static final String BASE_ENDPOINT="https://api.github.com";

    CloseableHttpClient client; //step 3
    CloseableHttpResponse response;


    @BeforeMethod
    public void setup(){//step 2
        client= HttpClientBuilder.create().build();
    }

    @AfterMethod
    public void closeResources() throws IOException {
        client.close();
        response.close();
    }
}
