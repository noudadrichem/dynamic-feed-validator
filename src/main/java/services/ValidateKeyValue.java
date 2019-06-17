package services;

import org.apache.http.*;
import org.apache.http.client.*;
import org.apache.http.client.methods.*;
import org.apache.http.impl.client.HttpClientBuilder;

public class ValidateKeyValue {

  public final String PREFIX = "MESSAGE__=";

  public ValidateKeyValue() {
  }

  public void checkKeyValue(String key, String value) {
    System.out.println(key + "=" + value);

    if (value.length() == 0) {
      System.out.println(PREFIX + key + " is empty");
    } else if (value.startsWith("https")) {
      System.out.println(PREFIX + key + " is an safe URL");
      isURLValid(value);
    } else if(value.startsWith("http")) {
      System.out.println(PREFIX + key + " is an UN safe URL");
    }
  }

  private boolean isURLValid(String url) {
    HttpClient client = HttpClientBuilder.create().build();
    HttpGet request = new HttpGet(url);
    HttpResponse response;
    try {
      response = client.execute(request);
      Header contentType = response.getFirstHeader("Content-Type");
      int statusCode = response.getStatusLine().getStatusCode();

      System.out.println("Response Code : " + response.getStatusLine().getStatusCode());
      System.out.println(url + " __ has contentType=" + contentType + " and status code: " + statusCode);

      return statusCode == 200;
    } catch (Exception e) {
      e.printStackTrace();
      return false;
    }
  }
}