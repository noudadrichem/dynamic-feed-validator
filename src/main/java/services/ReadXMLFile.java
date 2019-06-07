package services;

import org.w3c.dom.*;
import org.xml.sax.InputSource;

import javax.xml.parsers.*;
import java.io.*;
import java.net.URL;

import javax.xml.stream.*;
import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.Characters;
import javax.xml.stream.events.XMLEvent;

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
    if (line.isStartElement()) {
      String key = line.asStartElement().getName().getLocalPart();
      System.out.println("xml key: " + key + "  __ " + getValuebyKey(line));
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

  public Document convertStringToXMLDocument(String xmlString) {
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