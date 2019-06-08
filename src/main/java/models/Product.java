package models;

public class Product {

  private String title;
  private String description;
  private String ageGroup;
  private String availability;
  private String brand;
  private String color;
  private String gender;
  private String googleProductCategory;
  private int gtin;
  private int id;
  private String imageLink;
  private String itemGroupId;
  private String material;
  private int mpn;
  private double price;
  private String productType;
  // private String shipping;
  //   private String countrynl;
  private String shippingWeight;
  private int size;
  private String link;

  public Product(
    String title,
    String description,
    String ageGroup,
    String availability,
    String brand,
    String color,
    String gender,
    String googleProductCategory,
    int gtin,
    int id,
    String imageLink,
    String itemGroupId,
    String material,
    int mpn,
    double price,
    String productType,
    String shippingWeight,
    int size,
    String link
  ) {
    this.title = title;
    this.description = description;
    this.ageGroup = ageGroup;
    this.availability = availability;
    this.brand = brand;
    this.color = color;
    this.gender = gender;
    this.googleProductCategory = googleProductCategory;
    this.gtin = gtin;
    this.id = id;
    this.imageLink = imageLink;
    this.itemGroupId = itemGroupId;
    this.material = material;
    this.mpn = mpn;
    this.price = price;
    this.productType = productType;
    this.shippingWeight = shippingWeight;
    this.size = size;
    this.link = link;
  }

  public Product() {}

  @Override
  public String toString() {
    return "[product] :: " + title
    + " " + description
    + " " + ageGroup
    + " " + availability
    + " " + brand
    + " " + color
    + " " + gender
    + " " + googleProductCategory 
    + " " + gtin
    + " " + id
    + " " + imageLink
    + " " + itemGroupId
    + " " + material
    + " " + mpn
    + " " +  price
    + " " + productType
    + " " + shippingWeight
    + " " + size
    + " " + link;
  }
}
