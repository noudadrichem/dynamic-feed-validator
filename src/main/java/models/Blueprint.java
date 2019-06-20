package models;

import java.util.ArrayList;

public class Blueprint {

  private int blueprintId;
  private ArrayList<BlueprintKey> keys;
  private String feedId;

  public Blueprint(int blueprintId, ArrayList<BlueprintKey> keys, String feedId) {
    this.blueprintId = blueprintId;
    this.keys = keys;
    this.feedId = feedId;
  }

public int getBlueprintId() {
	return blueprintId;
}

public void setBlueprintId(int blueprintId) {
	this.blueprintId = blueprintId;
}

public ArrayList<BlueprintKey> getKeys() {
	return keys;
}

public boolean addKey(BlueprintKey key) {
  return keys.add(key);
}

public String getFeedId() {
	return feedId;
}

public void setFeedId(String feedId) {
	this.feedId = feedId;
}

}