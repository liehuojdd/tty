import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;

import static org.testng.Assert.assertEquals;

public class Get200 extends BaseClass {
    //public static final String BASE_ENDPOINT="https://api.github.com";//step1
    //HttpClient client= HttpClientBuilder.create().build();
    CloseableHttpClient client; //step 3
    CloseableHttpResponse response;

    @BeforeMethod
    public void setup(){//step 2
        client=HttpClientBuilder.create().build();
    }

    @AfterMethod
    public void closeResources() throws IOException {
        client.close();
        response.close();
    }

    @Test
    public void baseUrlReturns200() throws IOException {
        //HttpGet get =new HttpGet("https://api.github.com");
        //HttpResponse response=client.execute(get);
        HttpGet get =new HttpGet(BASE_ENDPOINT);
        response=client.execute(get);
        int actualStatus=response.getStatusLine().getStatusCode();
        //Assert.assertEquals(actualStatus,200);
        assertEquals(actualStatus,200);
    }

    @Test
    public void rateLimitReturns200() throws IOException {
        HttpGet get =new HttpGet(BASE_ENDPOINT+"/rate_limit");
        response=client.execute(get);
        int actualStatus=response.getStatusLine().getStatusCode();
        assertEquals(actualStatus,200);
    }

    @Test
    public void searchReposReturns200() throws IOException {
        HttpGet get =new HttpGet(BASE_ENDPOINT+"/search/repositories?q=java");
        response=client.execute(get);
        int actualStatus=response.getStatusLine().getStatusCode();
        assertEquals(actualStatus,200);
    }
}