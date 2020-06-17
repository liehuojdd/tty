import org.apache.http.Header;
import org.apache.http.client.methods.CloseableHttpResponse;

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
}
