import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;

//Write Basic Get tests for response Headers
//More status code
public class Get404 {
    public static final String BASE_ENDPOINT="https://api.github.com";//second
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

    @Test
    public void noExitsingUrlReturn404() throws IOException {
        HttpGet get =new HttpGet(BASE_ENDPOINT+"/nonexistingurl");
        response=client.execute(get);
        int actualStatus=response.getStatusLine().getStatusCode();
        Assert.assertEquals(actualStatus,404);
    }

}
