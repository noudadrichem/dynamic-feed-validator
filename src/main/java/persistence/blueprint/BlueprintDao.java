package persistence.blueprint;

import models.Blueprint;
import models.BlueprintKey;

public interface BlueprintDao {
  public boolean saveBlueprint(BlueprintKey blueprintKey);

  public Blueprint getBlueprintByFeedId(String feedId);

  public boolean doesBlueprintExsist(String feedId) throws ClassNotFoundException;

  public boolean updateBlueprint(String columnName, String newValue, int blueprintId);

  public boolean deleteBlueprint(String feedId);
}