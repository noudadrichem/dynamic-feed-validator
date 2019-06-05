package services;

import java.io.FileInputStream;
import java.io.InputStream;

import nl.nigelvanhattum.util.http.HTTPHandler;

import org.w3c.dom.*;
import javax.xml.parsers.*;
import java.io.*;


public class ReadXMLFile {

  private String xmlFileUrl;

  public ReadXMLFile(String xmlFileUrl) {
    this.xmlFileUrl = xmlFileUrl;
  }


  public void StreamXMLFile() {
    try {
      String xmlResponse = HTTPHandler.doGet(xmlFileUrl);
      DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
      DocumentBuilder builder = factory.newDocumentBuilder();

      ByteArrayInputStream input = new ByteArrayInputStream(xmlResponse.getBytes("UTF-8"));
      Document doc = builder.parse(input);
      System.out.println(doc);

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
