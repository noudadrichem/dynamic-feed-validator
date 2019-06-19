package services;

import java.io.*;
import java.util.*;
import java.net.URL;

import javax.xml.stream.*;
import javax.xml.stream.events.*;

import models.Feed;
import models.Message;
import models.Product;
import persistence.PostgresFeedDaoImpl;
import persistence.PostgresMessageDaoImpl;

public class ReadXMLFile {

  final URL feedUrl;
  private String feedId;
  private String activeProductId;
  private boolean isFeedHeader = true;
  private static ValidateKeyValue validateUtil = new ValidateKeyValue();
  private static final PostgresFeedDaoImpl feedDao = new PostgresFeedDaoImpl();
  private static final PostgresMessageDaoImpl messageDao = new PostgresMessageDaoImpl();
  private boolean isEndOfItem = false;
  private ArrayList<String> keysInItem = new ArrayList<String>();

  public ReadXMLFile(String feedUrl) {
    try {
      this.feedUrl = new URL(feedUrl);
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }

  public void StreamXMLFile() throws XMLStreamException {
    Feed feed = null;
    try {
      // feed headers
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

          if(key.equals("item")) {
            this.keysInItem = new ArrayList<String>();
          } else {
            this.keysInItem.add(key);
          }

          switch (key) {
            case "item":
              if (isFeedHeader) {
                isFeedHeader = false;
                this.feedId = getRandomString();
                feed = new Feed(this.feedId, title, description, feedLink, publicationDate);
                feedDao.saveFeed(feed); // save to database.
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
              // hier moet een image queue komen
              imageLink = getValuebyKey(line, eventReader).trim();
              // imageLink = "https://www.envirochem.co.nz/wp-content/uploads/2018/07/Mower-Plus_001.jpg"; // grote afbeelding
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

            System.out.println("are all keys there?:");
            validateUtil.areAllRequiredKeysThere(this.keysInItem);

            // is end of item.
            System.out.println("___________________END_ITEM_______________");

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
            
            System.out.println("hash=" + product.getProductHashCode());

            // hier check of productID en hash hetzelfde zijn if ja dan update if no dan nieuwe product.
            if (feed.addProduct(product)) {
              feedDao.saveProduct(product, this.feedId);
            }

            line = eventReader.nextEvent();
            continue;
            // break;
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

  // validate here
  private String getValuebyKey(XMLEvent line, XMLEventReader eventReader) throws XMLStreamException {
    String value = "";
    String key = line.asStartElement().getName().getLocalPart();
    line = eventReader.nextEvent();
    if (line instanceof Characters) {
      value = line.asCharacters().getData().trim();

      if(!this.isFeedHeader) {
        validateUtil.checkKeyValue(key, value, this.feedId, this.activeProductId, this.isEndOfItem);
      }
    }

    return value;
  }

  public String getRandomString() {
    return UUID.randomUUID().toString().replace("-", "");
  }
  
}

// source: https://www.vogella.com/tutorials/RSSFeed/article.html
