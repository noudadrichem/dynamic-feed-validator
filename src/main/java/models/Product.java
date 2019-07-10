package models;

import org.apache.commons.codec.digest.DigestUtils;

public class Product {

  private String title;
  private String description;
  private String ageGroup;
  private String availability;
  private String brand;
  private String color;
  private String gender;
  private String googleProductCategory;
  private String gtin;
  private String id;
  private String imageLink;
  private String itemGroupId;
  private String material;
  private String mpn;
  private String price;
  private String productType;
  private String shippingCountry;
  private String shippingWeight;
  private String size;
  private String link;
  private String hash;
  private String productIdFromFeed;

  public Product(
    String title,
    String description,
    String ageGroup,
    String availability,
    String brand,
    String color,
    String gender,
    String googleProductCategory,
    String gtin,
    String id,
    String imageLink,
    String itemGroupId,
    String material,
    String mpn,
    String price,
    String productType,
    String shippingCountry,
    String shippingWeight,
    String size,
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
    this.shippingCountry = shippingCountry;
    this.shippingWeight = shippingWeight;
    this.size = size;
    this.link = link;
  }

  public Product(String hash, String productIdFromFeed) {
    this.hash = hash;
    this.productIdFromFeed = productIdFromFeed;
  }

  public Product() {}

  public String getProductHashCode() {
    String md5productHash = DigestUtils.md5Hex(
      this.toString().trim().replace(" ", "")
    ).toUpperCase();

    // assertThat(md5productHash.equals(hash)).isTrue();
    this.hash = md5productHash;
    return md5productHash;
  }

  public boolean equals(String hash) {
    return hash.equals(this.getProductHashCode());
  }

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

  public String getGtin() {
    return gtin;
  }

  public void setGtin(String gtin) {
    this.gtin = gtin;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
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

  public String getMpn() {
    return mpn;
  }

  public void setMpn(String mpn) {
    this.mpn = mpn;
  }

  public String getPrice() {
    return price;
  }

  public void setPrice(String price) {
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

  public String getSize() {
    return size;
  }

  public void setSize(String size) {
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

  public void setTitle(String title) {
    this.title = title;
  }

  public String getShippingCountry() {
    return shippingCountry;
  }

  public void setShippingCountry(String shippingCountry) {
    this.shippingCountry = shippingCountry;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public void SetProductIdFromFeed(String description) {
    this.productIdFromFeed = productIdFromFeed;
  }

  public String getProductIdFromFeed() {
    return productIdFromFeed;
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
