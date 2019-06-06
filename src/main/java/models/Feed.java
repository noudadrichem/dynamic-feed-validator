package models;

import java.util.Date;

public class Feed {

  private String title;
  private String description;
  private String feedLink;
  private Date publicationDate;

  public Feed(String title, String description, String feedLink, Date publicationDate) {
    this.title = title;
    this.description = description;
    this.feedLink = feedLink;
    this.publicationDate = publicationDate;
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

}