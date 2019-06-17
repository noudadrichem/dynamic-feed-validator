package services;

import java.io.IOException;
import java.util.Optional;

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
      // if (isURLValid(value)) {
      //   System.out.println(key + " is a valid URL");
      // }

      if(isUrlAnImageUrl(value)) {
        System.out.println("___ this url is an image");
      } else {
        System.out.println("___ this url is NOT an image");

      }
    } else if (value.startsWith("http")) {
      System.out.println(PREFIX + key + " is an UN safe URL");
      // if (isURLValid(value)) {
      //   System.out.println(key + " is a valid URL");
      // }
    }
  }

  private boolean isUrlAnImageUrl(String url) {
    String extension = Optional.ofNullable(url)
      .filter(f -> f.contains("."))
      .map(f -> f.substring(url.lastIndexOf(".") + 1)).get();

      return (
        extension.equals("png") || 
        extension.equals("jpg") || 
        extension.equals("jpeg"));
  }

  private boolean isUrlValidImage(String url) {
    HttpResponse response = doGetRequet(url);
    String contentType = response.getFirstHeader("Content-Type").getValue();
    System.out.println(url + " __ has contentType=" + contentType);
    return true;
  }

  private boolean isURLValid(String url) {
    HttpResponse response = doGetRequet(url);
    int statusCode = response.getStatusLine().getStatusCode();
    return statusCode == 200;
  }

  private HttpResponse doGetRequet(String url) {
    HttpClient client = HttpClientBuilder.create().build();
    HttpGet request = new HttpGet(url);
    try {
      return client.execute(request);
    } catch (Exception e) {
      e.printStackTrace();
      return null;
    }
  }
}