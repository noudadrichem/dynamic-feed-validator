package persistence;

import java.sql.*;

import models.Message;

public class PostgresMessageDaoImpl extends PostgresBaseDao {

  public boolean saveMessage(Message message) {
    try (Connection con = super.getConnection()) {

      PreparedStatement pstmt = con.prepareStatement(
        "insert into message(title, description, type, feed_id) values (?, ?, ? ,?)"
      );
      pstmt.setString(1, message.getTitle());
      pstmt.setString(2, message.getDescription());
      pstmt.setString(3, message.getType());
      pstmt.setString(4, message.getfeedId());
      pstmt.executeQuery();

			return true;
		} catch (Exception e) {
      e.printStackTrace();

			return false;
		}
  }

}