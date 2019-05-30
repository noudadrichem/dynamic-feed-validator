package services;

import java.net.URL;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;

public class UploadXMLFile {

  private String xmlFileUrl;

  public UploadXMLFile(String xmlFileUrl) {
    this.xmlFileUrl = xmlFileUrl;
  }

  public Document loadDocument() throws Exception {
    DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
    factory.setNamespaceAware(true);

    return factory.newDocumentBuilder().parse(new URL(this.xmlFileUrl).openStream());
  }
}

// source: http://www.java2s.com/Tutorials/Java/XML_HTML_How_to/DOM/Read_XML_Document_from_URL.htm