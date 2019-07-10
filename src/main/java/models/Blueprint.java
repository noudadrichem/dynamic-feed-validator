package models;

import java.util.ArrayList;

public class Blueprint {

  private ArrayList<String> keys;
  private String feedId;

  public Blueprint(ArrayList<String> keys, String feedId) {
    this.keys = keys;
    this.feedId = feedId;
  }

  public ArrayList<String> getKeys() {
    return keys;
  }

  public boolean addKey(String key) {
    return keys.add(key);
  }

  public String getFeedId() {
    return feedId;
  }

  public void setFeedId(String feedId) {
    this.feedId = feedId;
  }

}