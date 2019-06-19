package services;

import java.util.Optional;

import org.apache.http.*;
import org.apache.http.client.*;
import org.apache.http.client.methods.*;
import org.apache.http.impl.client.HttpClientBuilder;

import models.Message;
import persistence.PostgresMessageDaoImpl;

public class ValidateKeyValue {

  public final String PREFIX = "MESSAGE__=";
  private static final PostgresMessageDaoImpl dao = new PostgresMessageDaoImpl();

  public ValidateKeyValue() {}

  public void checkKeyValue(String key, String value, String feedId, String activeProductId) {
    // System.out.println(key + "=" + value);

    if (value.length() == 0) {
      // System.out.println(PREFIX + key + " is empty");
      Message mes = new Message(
        "title",
        key + " is empty",
        activeProductId,
        "warning",
        feedId
      );

      dao.saveMessage(mes);

    } else if (value.startsWith("https")) {
      // System.out.println(PREFIX + key + " is an safe URL");
      // if (isURLValid(value)) {
        System.out.println(key + " is a valid URL");
      // }

      if(isUrlAnImageUrl(value)) {
        // System.out.println(PREFIX + "this url is an image") ;
      } else {
        // System.out.println(PREFIX + "this url is NOT an image");
      }
    }
  }

  private boolean isUrlAnImageUrl(String url) {
    String extension = Optional.ofNullable(url)
      .filter(v -> v.contains("."))
      .map(v -> v.substring(url.lastIndexOf(".") + 1)).get();

      return (
        extension.equals("png") || 
        extension.equals("jpg") || 
        extension.equals("jpeg"));
  }

  private boolean isUrlValidImage(String url) {
    HttpResponse response = doGetRequet(url);
    String contentType = response.getFirstHeader("Content-Type").getValue();
    // System.out.println(PREFIX + url + " __ has contentType=" + contentType);
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

/*

REQUIRED KEYS:
id
title
description
link
image_link
availability 
price
brand
gtin
mpn
*/