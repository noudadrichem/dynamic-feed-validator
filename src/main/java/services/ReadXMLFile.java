package services;

import java.io.StringReader;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.xml.sax.InputSource;
import nl.nigelvanhattum.util.http.HTTPHandler;

public class ReadXMLFile {

  private String xmlFileUrl;

  public ReadXMLFile(String xmlFileUrl) {
    this.xmlFileUrl = xmlFileUrl;
  }

  public Document loadDocument() {
    String result = HTTPHandler.doGet(this.xmlFileUrl);
    return convertStringToXMLDocument(result);
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
// source: https://www.mkyong.com/java/how-to-read-xml-file-in-java-dom-parser/
// source: nigel van hattum maven dep
