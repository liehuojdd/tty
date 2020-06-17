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

public class BodyTestWithSimpleMap extends BaseClass {
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
    public void returnsCorrectLogin() throws IOException {
        HttpGet get =new HttpGet(BASE_ENDPOINT+"/users/andrejss88");
        response=client.execute(get);
        String jsonBody= EntityUtils.toString(response.getEntity());
        JSONObject jsonObject=new JSONObject(jsonBody);
        String loginValue=(String)getValueFor(jsonObject,LOGIN);
        Assert.assertEquals(loginValue,"andrejss88");

    }

    @Test
    public void returnsCorrectId() throws IOException {
        HttpGet get =new HttpGet(BASE_ENDPOINT+"/users/andrejss88");
        response=client.execute(get);
        String jsonBody= EntityUtils.toString(response.getEntity());
        JSONObject jsonObject=new JSONObject(jsonBody);
        Integer idValue=(Integer)getValueFor(jsonObject,ID);
        Assert.assertEquals(idValue,Integer.valueOf(11834443));

    }

    private Object getValueFor(JSONObject jsonObject,String key){
        return jsonObject.get(key);
    }
}
