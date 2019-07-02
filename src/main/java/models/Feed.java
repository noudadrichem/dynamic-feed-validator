package models;

import java.util.ArrayList;
import org.apache.commons.codec.digest.DigestUtils;

public class Feed {

  private String title;
  private String description;
  private String feedLink;
  private String id;
  final private ArrayList<Product> products = new ArrayList<Product>();

  public Feed(String id, String title, String description, String feedLink) {
    this.id = id;
    this.title = title;
    this.description = description;
    this.feedLink = feedLink;
  }

  // emptry consstructor required for REST pojo mapping.
  public Feed() {}

  public String getProductHashCode() {
    String md5productHash = DigestUtils.md5Hex(
      this.toString().trim().replace(" ", "")
    ).toUpperCase();

    return md5productHash;
  }

  public boolean equals(String hash) {
    return hash.equals(this.getProductHashCode());
  }

  public void setId(String id) {
    this.id = id;
  } 

  public String getId() {
    return id;
  }

  public void setTitle(String title) {
    this.title = title;
  } 

  public String getTitle() {
    return title;
  }

  public void setDescription(String description) {
    this.description = description;
  } 

  public String getDescription() {
    return description;
  }

  public void setFeedLink(String feedLink) {
    this.feedLink = feedLink;
  } 

  public String getFeedLink() {
    return feedLink;
  }

  public boolean addProduct(Product product) {
    if(!products.contains(product)) {
      products.add(product);
      return true;
    } else {
      return false;
    }
  }

  public ArrayList<Product> getProducts() {
    return products;
  }

  @Override
  public String toString() {
    return "feed=[id=" + this.id 
    + " description=" + this.description 
    + " title=" + this.title 
    + " productCount="+ this.products.size() 
    +"]";
  }

}