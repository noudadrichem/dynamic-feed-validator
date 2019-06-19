package persistence.message;

import java.sql.*;
import java.util.ArrayList;

import models.Message;

import persistence.PostgresBaseDao;

public class PostgresMessageDao extends PostgresBaseDao {

  public boolean saveMessage(Message message) {
    try (Connection con = super.getConnection()) {
      if(!this.getAllMessageHashesByFeedId(message.getfeedId()).contains(message.getMessageHashCode())) {
        System.out.println("deze message bestaat wel al maar oke");
        PreparedStatement pstmt = con.prepareStatement(
          "insert into message(title, description, type, feed_id, hashed) values (?, ?, ? ,?, ?)"
        );
        pstmt.setString(1, message.getTitle());
        pstmt.setString(2, message.getDescription());
        pstmt.setString(3, message.getType());
        pstmt.setString(4, message.getfeedId());
        pstmt.setString(5, message.getMessageHashCode());
        pstmt.executeUpdate();

        return true;
      }
		} catch (Exception e) {
      e.printStackTrace();
    }

    return false;
  }

  public ArrayList<String> getAllMessageHashesByFeedId(String feedId) {
  	ArrayList<String> tempList = new ArrayList<String>();
		
		try (Connection con = super.getConnection()) {
			PreparedStatement ps = con.prepareStatement("SELECT * FROM message WHERE feed_id = ?");
			ps.setString(1, feedId);
			
			ResultSet result = ps.executeQuery();
			
			while(result.next()) {
				tempList.add(
          result.getString("hashed")
        );
			}
			
		} catch(Exception e) {
      e.printStackTrace();
    }

    return tempList;
	}



}