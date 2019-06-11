package models;

import java.util.ArrayList;
import java.util.Date;

public class Feed {

  private String title;
  private String description;
  private String feedLink;
  private Date publicationDate;
  final private ArrayList<Product> products = new ArrayList<Product>();

  public Feed(String title, String description, String feedLink/*, Date publicationDate*/) {
    this.title = title;
    this.description = description;
    this.feedLink = feedLink;
    // this.publicationDate = publicationDate;
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

  public void setPublicationDate(Date publicationDate) {
    this.publicationDate = publicationDate;
  } 

  public Date getPublicationDate() {
    return publicationDate;
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
    return "feed=[title=" + this.title + " productCount="+ this.products.size() +"]";
  }

}