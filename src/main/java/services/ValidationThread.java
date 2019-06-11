package services;

import javax.xml.stream.XMLStreamException;

public class ValidationThread extends Thread {

  private String url;

  public ValidationThread(String xmlUrlToValidate) {
    this.url = xmlUrlToValidate;
  }

  public void run() {
    System.out.println("started thread for url=" + url);
    ReadXMLFile readXMLFile = new ReadXMLFile(this.url);

    try {
      readXMLFile.StreamXMLFile();
    } catch (XMLStreamException e) {
      e.printStackTrace();
    }
  }
}