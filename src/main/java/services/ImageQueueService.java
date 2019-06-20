package services;

import java.util.LinkedList;
import java.util.Queue;
import java.util.ArrayList;

public class ImageQueueService {

  private Queue<String> allImageLinks;
    
  public ImageQueueService() {
    this.allImageLinks = new LinkedList<String>();
  }

  public void startQueValidation() {

  }

  public void addUrlToQueue(String url) {
    allImageLinks.add(url);
  }
  
}