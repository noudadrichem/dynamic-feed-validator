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

  public void checkKeyValue(String key, String value, String feedId, String productId) {

    System.out.println(key + "=" + value);

    if (value.length() == 0) { // is value empty?
      Message mes = new Message(
        "Empty key found.",
        key + " is empty in product with id " + productId + ".",
        productId,
        "error",
        feedId
      );

      dao.saveMessage(mes);
    } else if (value.startsWith("http")) { // is value an URL?

      boolean isSafeUrl = value.matches("^(https)://");
      if(!isSafeUrl) {
        Message mes = new Message(
          "Unsafe URL found.",
          key + " is an url that is unsafe, make sure to use HTTPS.",
          productId,
          "warning",
          feedId
        );
        dao.saveMessage(mes);
      } 
      if (!isURLValid(value)) {
        Message mes = new Message(
          "Unvalid URL found.",
          value + " is an url that is not valid and return a non success code.",
          productId,
          "error",
          feedId
        );
        dao.saveMessage(mes);
      }

      if(isUrlAnImageUrl(value)) {
        if(!isUrlValidImage(value)) {
          Message mes = new Message(
            "Unvalid image found.",
            value + " is an image that is not valid and return a non image header.",
            productId,
            "error",
            feedId
          );
          dao.saveMessage(mes);
        }
      }
    } else { // check if required node is there.

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
      // next line voor image.
    } catch (Exception e) {
      e.printStackTrace();
      return null;
    }
  }

  private boolean areAllRequiredKeysThere(String value) {
    boolean id = false;
    boolean title = false;
    boolean description = false;
    boolean link = false;
    boolean image_link = false;
    boolean availability  = false;
    boolean price = false;
    boolean brand = false;
    boolean gtin = false;
    boolean mpn = false;

    switch(value) {
      case "id": id = true;
      case "title": id = true;
      case "description": id = true;
      case "link": id = true;
      case "image_link": id = true;
      case "availability": id = true;
      case "price": id = true;
      case "brand": id = true;
      case "gtin": id = true;
      case "mpn": id = true;
    }

    return (
      id &&
      title &&
      description &&
      link &&
      image_link &&
      availability  &&
      price &&
      brand &&
      gtin &&
      mpn
    );
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