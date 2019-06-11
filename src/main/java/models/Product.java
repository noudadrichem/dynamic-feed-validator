package models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
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

  public String getAgeGroup() {
    return ageGroup;
  }

  public void setAgeGroup(String ageGroup) {
    this.ageGroup = ageGroup;
  }

  public String getAvailability() {
    return availability;
  }

  public void setAvailability(String availability) {
    this.availability = availability;
  }

  public String getBrand() {
    return brand;
  }

  public void setBrand(String brand) {
    this.brand = brand;
  }

  public String getColor() {
    return color;
  }

  public void setColor(String color) {
    this.color = color;
  }

  public String getGender() {
    return gender;
  }

  public void setGender(String gender) {
    this.gender = gender;
  }

  public String getGoogleProductCategory() {
    return googleProductCategory;
  }

  public void setGoogleProductCategory(String googleProductCategory) {
    this.googleProductCategory = googleProductCategory;
  }

  public int getGtin() {
    return gtin;
  }

  public void setGtin(int gtin) {
    this.gtin = gtin;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getImageLink() {
    return imageLink;
  }

  public void setImageLink(String imageLink) {
    this.imageLink = imageLink;
  }

  public String getItemGroupId() {
    return itemGroupId;
  }

  public void setItemGroupId(String itemGroupId) {
    this.itemGroupId = itemGroupId;
  }

  public String getMaterial() {
    return material;
  }

  public void setMaterial(String material) {
    this.material = material;
  }

  public int getMpn() {
    return mpn;
  }

  public void setMpn(int mpn) {
    this.mpn = mpn;
  }

  public double getPrice() {
    return price;
  }

  public void setPrice(double price) {
    this.price = price;
  }

  public String getProductType() {
    return productType;
  }

  public void setProductType(String productType) {
    this.productType = productType;
  }

  public String getShippingWeight() {
    return shippingWeight;
  }

  public void setShippingWeight(String shippingWeight) {
    this.shippingWeight = shippingWeight;
  }

  public int getSize() {
    return size;
  }

  public void setSize(int size) {
    this.size = size;
  }

  public String getLink() {
    return link;
  }

  public void setLink(String link) {
    this.link = link;
  }

  public String getTitle() {
    return title;
  }

  public String getDescription() {
    return description;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  @Override
  public String toString() {
    return "[product] :: " + title
    + " description= " + description
    + " ageGroup= " + ageGroup
    + " availability= " + availability
    + " brand= " + brand
    + " color= " + color
    + " gender= " + gender
    + " googleProductCategory= " + googleProductCategory 
    + " gtin= " + gtin
    + " id= " + id
    + " imageLink= " + imageLink
    + " itemGroupId= " + itemGroupId
    + " material= " + material
    + " mpn= " + mpn
    + " price= " +  price
    + " productType= " + productType
    + " shippingWeight= " + shippingWeight
    + " size= " + size
    + " link= " + link;
  }
}
