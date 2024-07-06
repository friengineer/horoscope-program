// package to create and store files in
package sign.client;

import javax.ws.rs.core.MediaType;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;

// client to test web service
public class ZodiacSignClient{
  // specify where web service and method are
  static final String REST_URI = "http://localhost:2323/zodiacsign/";
  static final String SIGN_PATH = "sign";

  public static void main(String[] args){
    String day = "1";
    String month = "1";

    // configure client using the web service and method URIs
    ClientConfig config = new DefaultClientConfig();
    Client client = Client.create(config);
    WebResource service = client.resource(REST_URI);

    WebResource signService = service.path(SIGN_PATH).path(day + "/" + month);
    System.out.println("Response: " + getResponse(signService));
    System.out.println("Date: " + day + "/" + month);

    // invoke web service and time how long it takes to execute
    long startTime = System.currentTimeMillis();
    System.out.println("Sign: " + getOutputAsText(signService));
    long endTime = System.currentTimeMillis();
    long executionTime = endTime - startTime;

    System.out.println("Execution time: " + executionTime + " milliseconds");
  }

  // test if the client can get a response from the server
  private static String getResponse(WebResource service){
    return service.accept(MediaType.TEXT_PLAIN).get(ClientResponse.class).toString();
  }

  // invoke the web service and ask for the response to be in plain text
  private static String getOutputAsText(WebResource service){
    return service.accept(MediaType.TEXT_PLAIN).get(String.class);
  }
}
