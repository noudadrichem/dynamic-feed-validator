package persistence.message;

import java.sql.*;
import java.util.ArrayList;


import models.Message;

import persistence.PostgresBaseDao;

public class PostgresMessageDao extends PostgresBaseDao implements MessageDao {

  public boolean saveMessage(Message message) {
    try (Connection con = super.getConnection()) {

      System.out.println("from postgresmesssage dao" + message.getProductId());

      if (!this.getAllMessageHashesByFeedId(message.getfeedId()).contains(message.getMessageHashCode())) {

        PreparedStatement pstmt = con.prepareStatement(
            "insert into message(title, description, type, feed_id, hashed, product_id) values (?, ?, ? ,?, ?, ?)");
        pstmt.setString(1, message.getTitle());
        pstmt.setString(2, message.getDescription());
        pstmt.setString(3, message.getType());
        pstmt.setString(4, message.getfeedId());
        pstmt.setString(5, message.getMessageHashCode());
        pstmt.setString(6, message.getProductId());
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
      PreparedStatement ps = con.prepareStatement("SELECT hashed FROM message WHERE feed_id = ?");
      ps.setString(1, feedId);

      ResultSet result = ps.executeQuery();

      while (result.next()) {
        tempList.add(result.getString("hashed"));
      }

    } catch (Exception e) {
      e.printStackTrace();
    }

    return tempList;
  }

  public ArrayList<Message> getAllMessagesByFeedId(String feedId) {
    ArrayList<Message> tempList = new ArrayList<Message>();

    try (Connection con = super.getConnection()) {
      PreparedStatement ps = con.prepareStatement("SELECT * FROM message WHERE feed_id = ?");
      ps.setString(1, feedId);

      ResultSet result = ps.executeQuery();

      while (result.next()) {
        tempList.add(new Message(result.getString("title"), result.getString("description"),
            result.getString("product_id"), result.getString("type"), result.getString("feed_id")));
      }

    } catch (Exception e) {
      e.printStackTrace();
    }

    return tempList;
  }

  public boolean deleteMessage(String feedId) {
    try (Connection con = super.getConnection()) {
      PreparedStatement ps = con.prepareStatement("delete from message where feed_id = ?");
      ps.setString(1, feedId);
      ps.execute();

      return true;
    } catch (Exception e) {
      e.printStackTrace();
      return false;
    }
  }

  public boolean updateMessage(String messageId, String key, String value) {
    try (Connection con = super.getConnection()) {
      PreparedStatement ps = con.prepareStatement("update message set where ?, ? where message_id = ?");
      ps.setString(1, key);
      ps.setString(2, value);
      ps.setString(3, messageId);
      ps.execute();

      return true;
    } catch (Exception e) {
      e.printStackTrace();
      return false;
    }
  }

}