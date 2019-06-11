package persistence;

import java.sql.*;
import java.text.*;

import models.Feed;
import models.Product;

public class PostgresFeedDaoImpl extends PostgresBaseDao {

  public boolean saveFeed(Feed feed) throws ClassNotFoundException {
    try (Connection con = super.getConnection()) {

      PreparedStatement pstmt = con.prepareStatement(
        "insert into feed(feed_id, title, description, feed_link, publication_date, account_id) values(?,?,?,?,?,?)"
      );
      pstmt.setString(1, feed.getId());
      pstmt.setString(2, feed.getTitle());
      pstmt.setString(3, feed.getDescription());
      pstmt.setString(4, feed.getFeedLink());
      pstmt.setString(5, feed.getPublicationDate());
      pstmt.setInt(6, 1);
      pstmt.executeQuery();

			return true;
		} catch (SQLException e) {
      e.printStackTrace();

			return false;
		}
  }

  public boolean saveProduct(Product product, String feed_id) throws ClassNotFoundException {
    try (Connection con = super.getConnection()) {

      PreparedStatement pstmt = con.prepareStatement(
        "insert into product(hashed, feed_id) values(?, ?)"
      );
      pstmt.setString(1, product.getProductHashCode());
      pstmt.setString(2, feed_id);
      pstmt.executeQuery();

      return true;
    } catch (SQLException e) {
      e.printStackTrace();

      return false;
    }
  }

}