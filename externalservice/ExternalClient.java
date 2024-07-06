package externalservice;

import javax.ws.rs.core.MediaType;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;

// client to test external web service
public class ExternalClient{
  // URI of external web service
  static final String REST_URI = "http://ohmanda.com/api/horoscope/";

  public static void main(String[] args){
    String sign = "taurus";

    ClientConfig config = new DefaultClientConfig();
    // config.getFeatures().put(JSONConfiguration.FEATURE_POJO_MAPPING, Boolean.TRUE);
    Client client = Client.create(config);
    WebResource service = client.resource(REST_URI);

    WebResource sunService = service.path(sign);
    System.out.println("Response: " + getResponse(sunService));
    System.out.println("Sign: " + sign);

    // invoke web service and time how long it takes to execute
    long startTime = System.currentTimeMillis();
    System.out.println("Info about sign: " + getOutputAsText(sunService));
    long endTime = System.currentTimeMillis();
    long executionTime = endTime - startTime;

    System.out.println("Execution time: " + executionTime + " milliseconds");
  }

  // test if the client can get a response from the server
  private static String getResponse(WebResource service){
    return service.accept(MediaType.APPLICATION_JSON).get(ClientResponse.class).toString();
  }

  // invoke the web service and ask for the response to be in JSON
  private static String getOutputAsText(WebResource service){
    return service.accept(MediaType.APPLICATION_JSON).get(String.class);
  }
}
