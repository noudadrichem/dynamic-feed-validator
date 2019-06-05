package services;

import java.io.InputStream;
import java.io.StringReader;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import javax.xml.stream.XMLEventReader;

import org.w3c.dom.Document;

import nl.nigelvanhattum.util.http.HTTPHandler;

import java.util.*;



public class ReadXMLFile {

  private String xmlFileUrl;

  public ReadXMLFile(String xmlFileUrl) {
    this.xmlFileUrl = xmlFileUrl;
  }


  public void StreamXMLFile() {
    try {
      // First, create a new XMLInputFactory
      XMLInputFactory inputFactory = XMLInputFactory.newInstance();
      // Setup a new eventReader
      InputStream in = new FileInputStream(configFile);
      XMLEventReader eventReader = inputFactory.createXMLEventReader(in);
      // read the XML document
      Item item = null;
    } catch(Exception e) {
      e.printStackTrace();
    }
  }

  // public Document loadDocument() {
  //   String result = HTTPHandler.doGet(this.xmlFileUrl);
  //   return convertStringToXMLDocument(result);
  // }

  // public Document convertStringToXMLDocument(String xmlString) {
  //   DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

  //   try {
  //     DocumentBuilder builder = factory.newDocumentBuilder();
  //     Document doc = builder.parse(new InputSource(new StringReader(xmlString)));

  //     return doc;
  //   } catch (Exception e) {
  //     e.printStackTrace();

  //     return null;
  //   }
  // }



}

// source:
// http://www.java2s.com/Tutorials/Java/XML_HTML_How_to/DOM/Read_XML_Document_from_URL.htm
// https://www.mkyong.com/java/how-to-read-xml-file-in-java-dom-parser/
// nigel van hattum maven dep
