package persistence.blueprint;

import java.sql.*;
import java.util.ArrayList;

import models.Blueprint;
import models.BlueprintKey;

import persistence.PostgresBaseDao;

public class PostgresBlueprintDao extends PostgresBaseDao {

  private String dikke = "jatoch";

  public boolean saveBlueprint(BlueprintKey blueprintKey) {
    try (Connection con = super.getConnection()) {

      PreparedStatement pstmt = con.prepareStatement(
        "insert into blueprint(key, feed_id) values (?, ?)"
      );
      pstmt.setString(1, blueprintKey.getKey());
      pstmt.setString(2, blueprintKey.getFeedId());
      pstmt.executeUpdate();  

      return true;
		} catch (Exception e) {
      e.printStackTrace();
    }

    return false;
  }
  
  public Blueprint getBlueprintByFeedId(String feedId) {
		try (Connection con = super.getConnection()) {
			PreparedStatement ps = con.prepareStatement("select * from blueprint where feed_id = ?");
			ps.setString(1, feedId);
      
      ResultSet result = ps.executeQuery();

      ArrayList<String> keys = new ArrayList<String>();
      while(result.next()) {
        keys.add(result.getString("key"));
      }

      return new Blueprint(
        keys,
        feedId
      );
			
		} catch(Exception e) {
      e.printStackTrace();
      return null;
    }
  }

  public boolean doesBlueprintExsist(String feedId) throws ClassNotFoundException {
    try (Connection con = super.getConnection()) {
      PreparedStatement ps = con.prepareStatement("select * from blueprint WHERE feed_id = ?");
			ps.setString(1, feedId);
			
      ResultSet result = ps.executeQuery();

      return !result.next();
    } catch (SQLException e) {
      e.printStackTrace();
			return false;
		}
  }

  public boolean updateBlueprint(String columnName, String newValue, int blueprintId) {
		try (Connection con = super.getConnection()) {
			PreparedStatement ps = con.prepareStatement("update blueprint set ? = ? where blueprint_id = ?");
			ps.setString(1, columnName);
			ps.setString(2, newValue);
			ps.setInt(3, blueprintId);
      
      ps.executeUpdate();

      return true;
			
		} catch(Exception e) {
      e.printStackTrace();
      return false;
    }
  }

  public boolean deleteBlueprint(String feedId) {
		try (Connection con = super.getConnection()) {
			PreparedStatement ps = con.prepareStatement("delete from blueprint where feed_id = ?");
			ps.setString(1, feedId);
      ps.execute();

      return true;
		} catch(Exception e) {
      e.printStackTrace();
      return false;
    }
  }
}