import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import entities.User;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;

import static entities.User.ID;
import static entities.User.LOGIN;

public class BodyTestWithJackson extends BaseClass {

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

    @Test
    public void returnsUser() throws IOException {
        HttpGet get =new HttpGet(BASE_ENDPOINT+"/users/andrejss88");
        response=client.execute(get);
        User user=unmarshall(response,User.class);
        Assert.assertEquals(user.getLogin(),"andrejss88");

    }

    private User unmarshall(CloseableHttpResponse response,Class<User> clazz) throws IOException {
        String jsonBody=EntityUtils.toString(response.getEntity());
        return new ObjectMapper()
                .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES,false)
                .readValue(jsonBody,clazz);
    }

}
