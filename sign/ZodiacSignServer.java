// package to create and store files in
package sign;

import java.io.IOException;
import com.sun.jersey.api.container.httpserver.HttpServerFactory;
import com.sun.net.httpserver.HttpServer;

// server of web service
public class ZodiacSignServer{
  // URI to publish the server to
  static final String BASE_URI = "http://localhost:2323/zodiacsign/";

  public static void main(String[] args){
    // create and start server
    try{
        HttpServer server = HttpServerFactory.create(BASE_URI);
        server.start();
        System.out.println("Press Enter twice to stop the server.");
        System.in.read();
        server.stop(0);
    } catch(IllegalArgumentException e){
        e.printStackTrace();
    } catch(IOException e){
        e.printStackTrace();
    }
  }
}
