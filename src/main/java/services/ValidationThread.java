package services;

import javax.xml.stream.XMLStreamException;

public class ValidationThread extends Thread {

  private String url;
  private String validationId;

  public ValidationThread(String xmlUrlToValidate, String validationId) {
    this.url = xmlUrlToValidate;
    this.validationId = validationId;
  }

  public void run() {
    System.out.println("started thread for url=" + url);
    StreamXMLFile streamXMLFile = new StreamXMLFile(this.url, validationId);

    try {
      streamXMLFile.StreamFile();
    } catch (XMLStreamException e) {
      e.printStackTrace();
    }
  }
}