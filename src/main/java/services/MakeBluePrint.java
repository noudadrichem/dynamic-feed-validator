package services;

import java.util.ArrayList;

import models.BlueprintKey;
import persistence.blueprint.PostgresBlueprintDao;

public class MakeBluePrint {

  private static final PostgresBlueprintDao blueprintDao = new PostgresBlueprintDao();
  private String feedId;
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

  public void save(String feedId) {
    for(String key : allUsedKeys) {
      blueprintDao.saveBlueprint(
        new BlueprintKey(
          key,
          feedId
        )
      );
    }
  }

}