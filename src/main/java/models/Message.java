package models;

public class Message {

  private String title;
  private String description;
  private String productId;
  private String feedId;
  private String type;

  public Message(
    String title,
    String description,
    String productId,
    String type,
    String feedId
  ) {
    this.title = title;
    this.description = description;
    this.productId = productId;
    this.type = type;
    this.feedId = feedId;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public void setProductId(String productId) {
    this.productId = productId;
  }

  public String getProductId() {
    return productId;
  }

  public void setfeedId(String feedId) {
    this.feedId = feedId;
  }

  public String getfeedId() {
    return feedId;
  }

  public void setType(String type) {
    this.type = type;
  }

  public String getType() {
    return type;
  }

}