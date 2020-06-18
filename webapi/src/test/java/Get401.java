import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.testng.annotations.*;

import java.io.IOException;

import static org.testng.Assert.assertEquals;

public class Get401 extends BaseClass {
    //public static final String BASE_ENDPOINT="https://api.github.com";//second
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

    @DataProvider
    private Object[][] endpoints(){
        return new Object[][]{
            {"/user"},
            {"/user/followers"},
            {"/notifications"}
        };
    }

    @Test(dataProvider = "endpoints")
    public void userReturns401(String endpoint) throws IOException {
        HttpGet get =new HttpGet(BASE_ENDPOINT+endpoint);
        response=client.execute(get);
        int actualStatus=response.getStatusLine().getStatusCode();
        assertEquals(actualStatus,401);
    }

    @Ignore
    public void userFollowersReturns401() throws IOException {
        HttpGet get =new HttpGet(BASE_ENDPOINT+"/user/followers");
        response=client.execute(get);
        int actualStatus=response.getStatusLine().getStatusCode();
        assertEquals(actualStatus,401);
    }

    @Ignore
    public void notificationsReturns401() throws IOException {
        HttpGet get =new HttpGet(BASE_ENDPOINT+"/notifications");
        response=client.execute(get);
        int actualStatus=response.getStatusLine().getStatusCode();
        assertEquals(actualStatus,401);
    }
}
