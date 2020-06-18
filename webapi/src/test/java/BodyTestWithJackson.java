import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import entities.NotFound;
import entities.RateLimit;
import entities.User;
import org.apache.http.Header;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import static org.testng.Assert.assertEquals;

public class BodyTestWithJackson extends BaseClass {

    @Test
    public void returnsCorrectUser() throws IOException {
        HttpGet get =new HttpGet(BASE_ENDPOINT+"/users/andrejss88");
        response=client.execute(get);
        User user=ResponseUtils.unmarshall(response, User.class);
        Assert.assertEquals(user.getLogin(),"andrejss88");

    }

    @Test
    public void returnCorrectId() throws IOException {
        HttpGet get =new HttpGet(BASE_ENDPOINT+"/users/andrejss88");
        response=client.execute(get);
        User user=ResponseUtils.unmarshall(response, User.class);
        Assert.assertEquals(user.getId(),11834443);

    }

    @Test
    public void notFoundMessageIsCorrect() throws IOException {
        HttpGet get =new HttpGet(BASE_ENDPOINT+"/nonexistingendpoint");
        response=client.execute(get);
        NotFound notFoundMessage=ResponseUtils.unmarshallGeneric(response,NotFound.class);

    }

    @Test
    public void correctRateLimitsAreSet() throws IOException {
        HttpGet get =new HttpGet(BASE_ENDPOINT+"/rate_limit");
        response=client.execute(get);
        RateLimit rateLimits=ResponseUtils.unmarshallGeneric(response,RateLimit.class);
        assertEquals(rateLimits.getCoreLimit(),60);

    }



}
