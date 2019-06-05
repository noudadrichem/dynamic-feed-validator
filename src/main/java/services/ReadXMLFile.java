package services;

import nl.nigelvanhattum.util.http.HTTPHandler;

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

public class ReadXMLFile extends Object {

  private final URL feedUrl;

  public ReadXMLFile(String feedUrl) {
    try {
      this.feedUrl = new URL(feedUrl);
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }

  public void StreamXMLFile() throws XMLStreamException {
    // First create a new XMLInputFactory
    XMLInputFactory inputFactory = XMLInputFactory.newInstance();
    // Setup a new eventReader
    InputStream in = read();
    XMLEventReader reader = inputFactory.createXMLEventReader(in);

    while (reader.hasNext()) {
      XMLEvent event = reader.nextEvent();
      System.out.println(event.toString());
    }
    // read the XML document

    // XMLInputFactory f = XMLInputFactory.newInstance();
    // XMLStreamReader r = f.createXMLStreamReader(loadDocument());

    // // First create a new XMLInputFactory
    // XMLInputFactory inputFactory = XMLInputFactory.newInstance();
    // // Setup a new eventReader
    // InputStream in = read();
    // XMLEventReader eventReader = inputFactory.createXMLEventReader(in);
  
    // while (r.hasNext()) {
    //   r.next();
    // }
  }

  private InputStream read() {
    try {
        return this.feedUrl.openStream();
    } catch (IOException e) {
        throw new RuntimeException(e);
    }
  }

  // public Document StreamXMLFile() {
  //   try {
  //     StringBuilder xmlStringBuilder = new StringBuilder();
  //     xmlStringBuilder.append(HTTPHandler.doGet(feedUrl));
  //     DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
  //     DocumentBuilder builder = factory.newDocumentBuilder();
  //     ByteArrayInputStream input = new ByteArrayInputStream(xmlStringBuilder.toString().getBytes("UTF-8"));

  //     return builder.parse(input);
  //   } catch (Exception e) {
  //     e.printStackTrace();
  //     throw new RuntimeException(e);
  //   }
  // }

  // getElementsByTagName("user").item(0).getTextContent();

  public Document loadDocument() {
    // String result = HTTPHandler.doGet(this.feedUrl);
    // return convertStringToXMLDocument(result);
    return null;
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

// source:
// http://www.java2s.com/Tutorials/Java/XML_HTML_How_to/DOM/Read_XML_Document_from_URL.htm
// https://www.mkyong.com/java/how-to-read-xml-file-in-java-dom-parser/
// nigel van hattum maven dep
