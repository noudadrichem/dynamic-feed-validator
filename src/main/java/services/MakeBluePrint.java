package services;

import java.util.ArrayList;

public class MakeBluePrint {

  private ArrayList<String> allUsedKeys = new ArrayList<String>();

  public boolean add(String key) {
    if(!allUsedKeys.contains(key)) {
      return allUsedKeys.add(key);
    }
    return false;
  }

  public ArrayList<String> get() {
    return allUsedKeys;
  }

  // public boolean save() {
  //   dao.save()
  // }

}