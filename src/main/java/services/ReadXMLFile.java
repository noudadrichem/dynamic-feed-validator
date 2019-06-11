package services;

import org.w3c.dom.*;
import org.xml.sax.InputSource;

import javax.xml.parsers.*;
import java.io.*;
import java.util.*;
import java.net.URL;

import javax.xml.stream.*;
import javax.xml.stream.events.*;

import models.Feed;
import models.Product;
import persistence.PostgresFeedDaoImpl;

public class ReadXMLFile {

  final URL feedUrl;
  private XMLInputFactory inputFactory;
  private XMLEventReader reader;
  
  private static final PostgresFeedDaoImpl dao = new PostgresFeedDaoImpl();

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
      boolean isFeedHeader = true;
      // feed headers
      String feedLink = "";
      String publicationDate = "";

      // feed item:
      String title = "";
      String description = "";
      String country = "";
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
      String shipping = "";
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

          switch (key) {
          case "item":
            if (isFeedHeader) {
              isFeedHeader = false;
              feed = new Feed(title, description, feedLink);

              try {
                dao.saveFeed(feed);
              } catch (ClassNotFoundException e) {
                e.printStackTrace();
              }
            }
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
            shipping = getValuebyKey(line, eventReader);
            break;
          case "country":
            country = getValuebyKey(line, eventReader);
            break;
          case "shipping_weight":
            shippingWeight = getValuebyKey(line, eventReader);
            break;
          case "size":
            size = getValuebyKey(line, eventReader);
            break;
          default:
            System.out.println("___DEFAULT___");
          }
        } else if (line.isEndElement()) {
          if (line.asEndElement().getName().getLocalPart() == "item") {
            System.out.println("ITEM END");

            Product product = new Product();
            product.setTitle(title);
            product.setDescription(description);
            product.setAgeGroup(ageGroup);
            product.setAvailability(availability);
            product.setBrand(brand);
            product.setColor(color);
            product.setGender(gender);
            product.setGoogleProductCategory(googleProductCategory);
            // product.setGtin(Integer.parseInt(gtin));
            // product.setId(Integer.parseInt(itemId));
            product.setImageLink(imageLink);
            product.setItemGroupId(itemGroupId);
            product.setMaterial(material);
            // product.setMpn(Integer.parseInt (mpn));
            // product.setPrice(Integer.parseInt(price));
            product.setProductType(productType);
            product.setShippingWeight(shippingWeight);
            // product.setSize(Integer.parseInt(size));
            product.setLink(link);

            System.out.println("NEW product: " + product.toString());

            // FIX DATE PARSING LocalDateTime dateTime = f.parseLocalDateTime("2012-01-10
            // 23:13:26");

            if (feed.addProduct(product)) {
              System.out.println("Added product to feed");
            } else {
              System.out.println("Failed to add product to feed.");
            }

            line = eventReader.nextEvent();
            continue;
          }
        }

      }
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public void validateLine(XMLEvent line) throws XMLStreamException {}

  private InputStream read() {
    try {
      return this.feedUrl.openStream();
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }

  private String getValuebyKey(XMLEvent event, XMLEventReader eventReader) throws XMLStreamException {
    String result = "";
    event = eventReader.nextEvent();
    if (event instanceof Characters) {
      result = event.asCharacters().getData();
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
