package models;

import java.util.ArrayList;

public class BlueprintKey {

  private int blueprintId;
  private String key;
  private String feedId;

  public BlueprintKey(String key, String feedId) {
    this.key = key;
    this.feedId = feedId;
  }

public int getBlueprintId() {
	return blueprintId;
}

public void setBlueprintId(int blueprintId) {
	this.blueprintId = blueprintId;
}

public String getKey() {
	return key;
}

public void setKey(String key) {
	this.key = key;
}

public String getFeedId() {
	return feedId;
}

public void setFeedId(String feedId) {
	this.feedId = feedId;
}

}