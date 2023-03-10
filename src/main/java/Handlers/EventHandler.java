package Handlers;

import DataAccess.AuthTokenDao;
import DataAccess.DataAccessException;
import DataAccess.Database;
import Requests.EventRequest;
import Results.EventResult;
import Services.EventService;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.sun.net.httpserver.Headers;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.sql.Connection;

public class EventHandler implements HttpHandler {
  @Override
  public void handle(HttpExchange exchange) throws IOException {
    boolean success = false;
    try {
      EventResult result = null;
      GsonBuilder builder = new GsonBuilder();
      Gson gson = builder.create();
      if (exchange.getRequestMethod().toLowerCase().equals("get")) {
        Headers reqHeaders = exchange.getRequestHeaders();
        if (reqHeaders.containsKey("Authorization")) {
          String authToken = reqHeaders.getFirst("Authorization");
          InputStream reqBody = exchange.getRequestBody();
          String reqData = readString(reqBody);


          System.out.println(reqData);

          EventRequest request = new EventRequest();
          EventService service = new EventService();
          request.setAuthToken(authToken);


          if(exchange.getRequestURI().toString().length() > 6) {
            String eventID = exchange.getRequestURI().toString().substring(7);
            request.setEventID(eventID);
            result = service.findEvent(request);
          }
          else{
            result = service.eventTree(request);
          }


          success = result.isSuccess();
        }
      }
      if (!success) {
        exchange.sendResponseHeaders(HttpURLConnection.HTTP_BAD_REQUEST, 0);
        OutputStream resBody = exchange.getResponseBody();
        String json = gson.toJson(result);
        resBody.write(json.getBytes());
        exchange.getResponseBody().close();
      }
      else{
        exchange.sendResponseHeaders(HttpURLConnection.HTTP_OK, 0);
        OutputStream resBody = exchange.getResponseBody();
        String json = gson.toJson(result);
        resBody.write(json.getBytes());
        exchange.getResponseBody().close();
      }
    }
    catch (IOException e) {
      // Some kind of internal error has occurred inside the server (not the
      // client's fault), so we return an "internal server error" status code
      // to the client.
      exchange.sendResponseHeaders(HttpURLConnection.HTTP_SERVER_ERROR, 0);

      // We are not sending a response body, so close the response body
      // output stream, indicating that the response is complete.
      exchange.getResponseBody().close();

      // Display/log the stack trace
      e.printStackTrace();
    }
  }

  /*
      The readString method shows how to read a String from an InputStream.
  */
  private String readString(InputStream is) throws IOException {
    StringBuilder sb = new StringBuilder();
    InputStreamReader sr = new InputStreamReader(is);
    char[] buf = new char[1024];
    int len;
    while ((len = sr.read(buf)) > 0) {
      sb.append(buf, 0, len);
    }
    return sb.toString();
  }
}
