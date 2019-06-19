package services;

import java.util.*;

import org.apache.http.*;
import org.apache.http.client.*;
import org.apache.http.client.methods.*;
import org.apache.http.impl.client.HttpClientBuilder;

import models.Message;
import persistence.PostgresMessageDaoImpl;

public class ValidateKeyValue {

  public final String PREFIX = "MESSAGE__=";
  private static final PostgresMessageDaoImpl messageDao = new PostgresMessageDaoImpl();
  private boolean isRequiredKeysValue = false;
  private String feedId;
  private String productId;

  public ValidateKeyValue() {}

  public void checkKeyValue(String key, String value, String feedId, String productId, boolean isEndOfItem) {
    this.productId = productId;
    this.feedId = feedId;

    System.out.println(key + "=" + value); // print key/values to console.

    if (value.length() == 0) { // is value empty?
      Message mes = new Message(
        "Empty key found.",
        key + " is empty in product with id " + this.productId + ".",
        this.productId,
        "error",
        this.feedId
      );

      messageDao.saveMessage(mes);
    } else if (value.startsWith("http")) { // is value an URL?

      boolean isSafeUrl = value.matches("^(https)://");
      if(!isSafeUrl) { // is it a safe url?
        Message mes = new Message(
          "Unsafe URL found.",
          key + " is an url that is unsafe, make sure to use HTTPS.",
          this.productId,
          "warning",
          this.feedId
        );
        messageDao.saveMessage(mes);
      } 
      if (!isURLValid(value)) { // is it a valid url?
        Message mes = new Message(
          "Unvalid URL found.",
          value + " is an url that is not valid and return a non success code.",
          this.productId,
          "error",
          this.feedId
        );
        messageDao.saveMessage(mes);
      }

      if(isUrlAnImageUrl(value)) { // is it an image URL?
        if(!isUrlValidImage(value)) { // is the content type really an image?
          Message mes = new Message(
            "Unvalid image found.",
            value + " is an image that is not valid and return a non image header.",
            this.productId,
            "error",
            this.feedId
          );
          messageDao.saveMessage(mes);
        }
      }
    } // else if() {}
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
    // hier moet nog een check met png, jpg, jpeg.  
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

  public void areAllRequiredKeysThere(ArrayList<String> values) {
    ArrayList<String> requiredItems = new ArrayList<String>();
    requiredItems.add("id");
    requiredItems.add("title");
    requiredItems.add("description");
    requiredItems.add("link");
    requiredItems.add("image_link");  
    requiredItems.add("availability");
    requiredItems.add("price");
    requiredItems.add("brand");
    requiredItems.add("gtin");
    requiredItems.add("mpn");

    for(String requiredItem : requiredItems) {
      if(!values.contains(requiredItem)) {
        System.out.println("values heeft required item " + requiredItem);
        Message mes = new Message(
          requiredItem + " is a required field.",
          "Make sure to add "+requiredItem+" to item with id "+this.productId+".",
          this.productId,
          "error",
          this.feedId
      );

      messageDao.saveMessage(mes);
      }
    } 
  }

  public boolean getRequiredKeysValue() {
    return this.isRequiredKeysValue;
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


    // switch(value) {
    //   case "id": id = true;
    //   case "title": id = true;
    //   case "description": id = true;
    //   case "link": id = true;
    //   case "image_link": id = true;
    //   case "availability": id = true;
    //   case "price": id = true;
    //   case "brand": id = true;
    //   case "gtin": id = true;
    //   case "mpn": id = true;
    // }
    
    // System.out.println(value +" is there." + (
    //   id &&
    //   title &&
    //   description &&
    //   link &&
    //   image_link &&
    //   availability  &&
    //   price &&
    //   brand &&
    //   gtin &&
    //   mpn
    // ));

    // this.isRequiredKeysValue = (
    //   id &&
    //   title &&
    //   description &&
    //   link &&
    //   image_link &&
    //   availability  &&
    //   price &&
    //   brand &&
    //   gtin &&
    //   mpn
    // );