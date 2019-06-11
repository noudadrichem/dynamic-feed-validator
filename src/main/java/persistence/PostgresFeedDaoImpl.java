package persistence;

import java.sql.*;
import java.text.*;

import models.Feed;

public class PostgresFeedDaoImpl extends PostgresBaseDao {

  public boolean saveFeed(Feed feed) throws ClassNotFoundException {
    try (Connection con = super.getConnection()) {

      Date newDate = new Date(2019, 5, 13);

      PreparedStatement pstmt = con.prepareStatement(
        "insert into feed(title, description, feed_link, publication_date, product_id, account_id) values(?,?,?,?,?,?)"
      );
      pstmt.setString(1, feed.getTitle());
      pstmt.setString(2, feed.getDescription());
      pstmt.setString(3, feed.getFeedLink());
      pstmt.setDate(4, newDate);
      pstmt.setInt(5, 1);
      pstmt.setInt(6, 1);
      pstmt.executeQuery();

			return true;
		} catch (SQLException sqle) {
			sqle.printStackTrace();
			return false;
		}
  }

}