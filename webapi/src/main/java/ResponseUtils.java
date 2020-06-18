import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import entities.User;
import org.apache.http.Header;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class ResponseUtils {
    public static String getHeader(CloseableHttpResponse response, String headerName){
        Header[] headers=response.getAllHeaders();
        List<Header> httpHeader= Arrays.asList(headers);
        String returnHeader="";

        for(Header header:httpHeader){
            if(headerName.equalsIgnoreCase(header.getName())){
                returnHeader=header.getValue();
            }
        }

        if(returnHeader.isEmpty()){
            throw new RuntimeException("Didn't find");
        }
        return  returnHeader;
    }

    public static boolean headerIsPresent(CloseableHttpResponse response, final String headerName){
        List<Header> httpHeaders= Arrays.asList(response.getAllHeaders());
        return httpHeaders.stream()
                .anyMatch(header->header.getName().equalsIgnoreCase(headerName));
    }

    public static User unmarshall(CloseableHttpResponse response, Class<User> clazz) throws IOException {
        String jsonBody= EntityUtils.toString(response.getEntity());
        return new ObjectMapper()
                .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES,false)
                .readValue(jsonBody,clazz);
    }

    public static <T> T unmarshallGeneric(CloseableHttpResponse response, Class<T> clazz) throws IOException {
        String jsonBody= EntityUtils.toString(response.getEntity());
        return new ObjectMapper()
                .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES,false)
                .readValue(jsonBody,clazz);
    }
}
