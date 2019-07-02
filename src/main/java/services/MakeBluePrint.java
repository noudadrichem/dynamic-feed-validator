package services;

import java.util.ArrayList;

import models.BlueprintKey;
import persistence.blueprint.PostgresBlueprintDao;

public class MakeBluePrint {

  private static PostgresBlueprintDao blueprintDao = new PostgresBlueprintDao();

  private ArrayList<String> allUsedKeys = new ArrayList<String>();

  public boolean add(String key) {
    return !allUsedKeys.contains(key) ? allUsedKeys.add(key) : false;
  }

  public ArrayList<String> getAllUsedKeys() {
    return allUsedKeys;
  }

  public void save(String feedId) throws ClassNotFoundException {
    if(blueprintDao.doesBlueprintExsist(feedId)) {
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

}