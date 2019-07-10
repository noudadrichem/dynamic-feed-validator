package services;

import javax.xml.stream.XMLStreamException;

public class ValidationThread extends Thread {

  private String url;
  private String validationId;
  private String sessionId;

  public ValidationThread(String xmlUrlToValidate, String validationId, String sessionId) {
    this.url = xmlUrlToValidate;
    this.validationId = validationId;
    this.sessionId = sessionId;
  }

  public void run() {
    System.out.println("started thread for url=" + url);
    StreamXMLFile streamXMLFile = new StreamXMLFile(this.url, validationId, sessionId);

    try {
      streamXMLFile.StreamFile();
    } catch (XMLStreamException e) {
      e.printStackTrace();
    }
  }
}