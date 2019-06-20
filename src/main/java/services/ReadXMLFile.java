package services;

import java.io.*;
import java.util.*;
import java.net.URL;

import javax.xml.stream.*;
import javax.xml.stream.events.*;

import models.Feed;
import models.Product;
import persistence.feed.PostgresFeedDao;
import persistence.product.PostgresProductDao;

public class ReadXMLFile {

  final URL feedUrl;
  private String feedId;
  private String activeProductId;
  private static ValidateKeyValue validateUtil = new ValidateKeyValue();
  private static final PostgresFeedDao feedDao = new PostgresFeedDao();
  private static final PostgresProductDao productDao = new PostgresProductDao();
  private final BluePrint blueprint = new BluePrint();
  private ArrayList<String> keysInItem = new ArrayList<String>();
  private Feed feed;

  private boolean isFeedHeader = true;
  private boolean isEndOfItem = false;

  public ReadXMLFile(String feedUrl) {
    try {
      this.feedUrl = new URL(feedUrl);
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }

  public void StreamXMLFile() throws XMLStreamException {
    try {
      // feed headers:
      String feedLink = "";
      String publicationDate = "";

      // feed item:
      String title = "";
      String description = "";
      String ageGroup = "";
      String availability = "";
      String brand = "";
      String color = "";
      String gender = "";
      String googleProductCategory = "";
      String gtin = "";
      String itemId = "";
      String imageLink = "";
      String itemGroupId = "";
      String material = "";
      String mpn = "";
      String price = "";
      String productType = "";
      String shippingCountry = "";
      String shippingWeight = "";
      String size = "";
      String link = "";

      XMLInputFactory inputFactory = XMLInputFactory.newInstance();
      InputStream in = read();
      XMLEventReader eventReader = inputFactory.createXMLEventReader(in);

      while (eventReader.hasNext()) {
        XMLEvent line = eventReader.nextEvent();

        if (line.isStartElement()) {
          String key = line.asStartElement().getName().getLocalPart();

          blueprint.add(key);

          if(key.equals("item")) {
            this.keysInItem = new ArrayList<String>();
          } else {
            this.keysInItem.add(key);
          }

          switch (key) {
            case "item":
              if (isFeedHeader) {
                isFeedHeader = false;
                
                if(feedDao.doesFeedExsist(feedLink)) {
                  this.feed = new Feed(getRandomString(), title, description, feedLink);
                  this.feedId = this.feed.getId();
                  feedDao.saveFeed(this.feed);
                } else {
                  String feedId = feedDao.getFeedIdByLink(feedLink);
                  this.feed = new Feed(feedId, title, description, feedLink);
                  this.feedId = this.feed.getId();
                }
              }

              this.isEndOfItem = false;

              line = eventReader.nextEvent();
              break;
            case "title":
              title = getValuebyKey(line, eventReader);
              break;
            case "description":
              description = getValuebyKey(line, eventReader);
              break;
            case "pubDate":
              publicationDate = getValuebyKey(line, eventReader);
              break;
            case "link":
              feedLink = getValuebyKey(line, eventReader);
              break;
            case "age_group":
              ageGroup = getValuebyKey(line, eventReader);
              break;
            case "availability":
              availability = getValuebyKey(line, eventReader);
              break;
            case "brand":
              brand = getValuebyKey(line, eventReader);
              break;
            case "color":
              color = getValuebyKey(line, eventReader);
              break;
            case "gender":
              gender = getValuebyKey(line, eventReader);
              break;
            case "google_product_category":
              googleProductCategory = getValuebyKey(line, eventReader);
              break;
            case "gtin":
              gtin = getValuebyKey(line, eventReader);
              break;
            case "id":
              itemId = getValuebyKey(line, eventReader);
              activeProductId = itemId;
              break;
            case "image_link":
              imageLink = getValuebyKey(line, eventReader).trim();
              break;
            case "item_group_id":
              itemGroupId = getValuebyKey(line, eventReader);
              break;
            case "material":
              material = getValuebyKey(line, eventReader);
              break;
            case "mpn":
              mpn = getValuebyKey(line, eventReader);
              break;
            case "price":
              price = getValuebyKey(line, eventReader);
              break;
            case "product_type":
              productType = getValuebyKey(line, eventReader);
              break;
            case "shipping":
              shippingCountry = getValuebyKey(line, eventReader);
              break;
            case "shipping_weight":
              shippingWeight = getValuebyKey(line, eventReader);
              break;
            case "size":
              size = getValuebyKey(line, eventReader);
              break;
            default:
              // System.out.println("___no case specified for key: "+ key +"___");
          }
        } else if (line.isEndElement()) {
          if (line.asEndElement().getName().getLocalPart() == "item") {
            this.isEndOfItem = true;

            validateUtil.areAllRequiredKeysThere(this.keysInItem);

            Product product = new Product();
            product.setTitle(title);
            product.setDescription(description);
            product.setAgeGroup(ageGroup);
            product.setAvailability(availability);
            product.setBrand(brand);
            product.setColor(color);
            product.setGender(gender);
            product.setGoogleProductCategory(googleProductCategory);
            product.setGtin(gtin);
            product.setId(itemId);
            product.setImageLink(imageLink);
            product.setItemGroupId(itemGroupId);
            product.setMaterial(material);
            product.setMpn(mpn);
            product.setPrice(price);
            product.setProductType(productType);
            product.setShippingCountry(shippingCountry);
            product.setShippingWeight(shippingWeight);
            product.setSize(size);
            product.setLink(link);
            
            feed.addProduct(product);
            
            String currentProductHash = product.getProductHashCode();
            System.out.println("hash=" + currentProductHash);
            
            ArrayList<String> allProductHashesForThisFeed = productDao.getAllStringHashes(this.feedId);
            if(!allProductHashesForThisFeed.contains(currentProductHash)) {
              productDao.saveProduct(product, this.feedId);
            }
            
            line = eventReader.nextEvent();
            System.out.println("_________END_ITEM______"); // is end of item.
            continue;
          }
        }
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  private InputStream read() {
    try {
      return this.feedUrl.openStream();
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }

  private String getValuebyKey(XMLEvent line, XMLEventReader eventReader) throws XMLStreamException {
    String value = "";
    String key = line.asStartElement().getName().getLocalPart();
    line = eventReader.nextEvent();
    
    if (line instanceof Characters) {
      value = line.asCharacters().getData().trim();
      
      if(!this.isFeedHeader) {
        boolean isValidationSucces = validateUtil.checkKeyValue(key, value, this.feedId, this.activeProductId, this.isEndOfItem);
        if(isValidationSucces) {
          return value;
        } else {
          System.out.println("validation went wrong and stopped streaming");
        }
      } else {
        return value;
      }
    }

    return null;
  }

  public String getRandomString() {
    return UUID.randomUUID().toString().replace("-", "");
  }
  
}
