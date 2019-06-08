package services;

import org.w3c.dom.*;
import org.xml.sax.InputSource;

import javax.xml.parsers.*;
import java.io.*;
import java.util.*;
import java.net.URL;

import javax.xml.stream.*;
import javax.xml.stream.events.*;

import models.Product;

public class ReadXMLFile {

  private final URL feedUrl;
  private XMLInputFactory inputFactory;
  private XMLEventReader reader;

  public ReadXMLFile(String feedUrl) {
    try {
      this.feedUrl = new URL(feedUrl);
      this.inputFactory = XMLInputFactory.newInstance();
      this.reader = inputFactory.createXMLEventReader(read());
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }

  public void StreamXMLFile() throws XMLStreamException {
    while (reader.hasNext()) {
      XMLEvent line = reader.nextEvent();
      validateLine(line);
    }
  }
  
  public void validateLine(XMLEvent line) throws XMLStreamException {
    
    boolean isFeedHeader = true;
    // feed headers
    String feedTitle = "";
    String feedDescription = "";
    String feedLink = "";
    Date publicationDate = null;

    // feed item: 
    String itemTitle;
    String itemDescription;
    String country;
    String ageGroup;
    String availability;
    String brand;
    String color;
    String gender;
    String googleProductCategory;
    int gtin;
    int itemId;
    String imageLink;
    String itemGroupId;
    String material;
    int mpn;
    double price;
    String productType;
    String shipping;
    String shippingWeight;
    int size;
    String link;

    if (line.isStartElement()) {
      String key = line.asStartElement().getName().getLocalPart();
      System.out.println("key=" + key);
      switch(key) {
        case "item":
          // IF FEED NOT NIET IS GEmAAAKT DOE DAT HIER
          System.out.println(key + ":" + getValuebyKey(line));
          break;
        case "description":
          System.out.println(key + ":" + getValuebyKey(line));
          itemDescription = getValuebyKey(line);
          break;
        case "age_group":
          System.out.println(key + ":" + getValuebyKey(line));
          ageGroup = getValuebyKey(line);
          break;
        case "availability":
          System.out.println(key + ":" + getValuebyKey(line));
          availability = getValuebyKey(line);
          break;
        case "brand":
          System.out.println(key + ":" + getValuebyKey(line));
          brand = getValuebyKey(line);
          break;
        case "color":
          System.out.println(key + ":" + getValuebyKey(line));
          color = getValuebyKey(line);
          break;
        case "gender":
          System.out.println(key + ":" + getValuebyKey(line));
          gender = getValuebyKey(line);
          break;
        case "google_product_category":
          System.out.println(key + ":" + getValuebyKey(line));
          googleProductCategory = getValuebyKey(line);
          break;
        case "gtin":
          System.out.println(key + ":" + getValuebyKey(line));
          gtin = Integer.parseInt(getValuebyKey(line));
          break;
        case "id":
          System.out.println(key + ":" + getValuebyKey(line));
          itemId = Integer.parseInt(getValuebyKey(line));
          break;
        case "image_link":
          System.out.println(key + ":" + getValuebyKey(line));
          imageLink = getValuebyKey(line);;
          break;
        case "item_group_id":
          System.out.println(key + ":" + getValuebyKey(line));
          itemGroupId = getValuebyKey(line);
          break;
        case "material":
          System.out.println(key + ":" + getValuebyKey(line));
          material = getValuebyKey(line);
          break;
        case "mpn":
          System.out.println(key + ":" + getValuebyKey(line));
          try {
            mpn = Integer.parseInt(getValuebyKey(line));
          } catch(NumberFormatException e) {
              e.printStackTrace();
          }
          break;
        case "price":
          System.out.println(key + ":" + getValuebyKey(line));
          price = Integer.parseInt(getValuebyKey(line));
          break;
        case "product_type":
          System.out.println(key + ":" + getValuebyKey(line));
          productType = getValuebyKey(line);
          break;
        case "shipping":
          System.out.println(key + ":" + getValuebyKey(line));
          shipping = getValuebyKey(line);
          break;
        case "country":
          System.out.println(key + ":" + getValuebyKey(line));
          country = getValuebyKey(line);
          break;
        case "shipping_weight":
          System.out.println(key + ":" + getValuebyKey(line));
          shippingWeight = getValuebyKey(line);
          break;
        case "size":
          System.out.println(key + ":" + getValuebyKey(line));
          size = Integer.parseInt(getValuebyKey(line));
          break;
        case "link":
          System.out.println(key + ":" + getValuebyKey(line));
          link = getValuebyKey(line);
          break;
        case "title":
          System.out.println(key + ":" + getValuebyKey(line));
          itemTitle = getValuebyKey(line);
          break;
        default: 
          System.out.println("___DEFAULT___");
      }
    } else if (line.isEndElement()) {
        if (line.asEndElement().getName().getLocalPart() == "item") {
          System.out.println("ITEM END");

          // VOEG HIER PRODUCT TOE
          Product product = new Product();
          // product.setTitle(itemTitle);
          // product.setDescription(itemDescription);
          // product.setAgeGroup(ageGroup);
          // product.setAvailability(availability);
          // product.setBrand(brand);
          // product.setColor(color);
          // product.setGender(gender);
          // product.setGoogleProductCategory(googleProductCategory);
          // product.setGtin(gtin);
          // product.setId(itemId);
          // product.setImageLink(imageLink);
          // product.setItemGroupId(itemGroupId);
          // product.setMaterial(material);
          // product.setMpn(mpn);
          // product.setPrice(price);
          // product.setProductType(productType);
          // product.setShippingWeight(shippingWeight);
          // product.setSize(size);
          // product.setLink(link);
        }
      }
  }

  private InputStream read() {
    try {
      return this.feedUrl.openStream();
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }
  
  private String getValuebyKey(XMLEvent line) throws XMLStreamException {
    String result = "-";
    line = this.reader.nextEvent();
    if (line instanceof Characters) {
      result = line.asCharacters().getData();
    }

    return result;
  }

  public Document convertXMLStringToDocument(String xmlString) {
    DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

    try {
      DocumentBuilder builder = factory.newDocumentBuilder();
      Document doc = builder.parse(new InputSource(new StringReader(xmlString)));

      return doc;
    } catch (Exception e) {
      e.printStackTrace();

      return null;
    }
  }

}

// source: https://www.vogella.com/tutorials/RSSFeed/article.html
