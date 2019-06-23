package services;

import javax.xml.stream.XMLStreamException;

public class ValidationThread extends Thread {

  private String url;

  public ValidationThread(String xmlUrlToValidate) {
    this.url = xmlUrlToValidate;
  }

  public void run() {
    System.out.println("started thread for url=" + url);
    StreamXMLFile streamXMLFile = new StreamXMLFile(this.url);

    try {
      streamXMLFile.StreamFile();
    } catch (XMLStreamException e) {
      e.printStackTrace();
    }
  }
}