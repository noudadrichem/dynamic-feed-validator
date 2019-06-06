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

}