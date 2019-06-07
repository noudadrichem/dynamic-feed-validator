package services;

import javax.xml.stream.XMLStreamException;

public class ValidationThread extends Thread {

  private String url;

  public ValidationThread(String xmlUrlToValidate) {
    this.url = xmlUrlToValidate;
  }

  public void run() {
    ReadXMLFile readXMLFile = new ReadXMLFile(this.url);

    try {
      readXMLFile.StreamXMLFile();
    } catch (XMLStreamException e) {
      e.printStackTrace();
    }
  }
}