package persistence.feed;

import java.sql.*;
import java.text.*;

import models.Feed;
import models.Product;
import persistence.PostgresBaseDao;

public class PostgresFeedDao extends PostgresBaseDao {

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
      pstmt.executeUpdate();

			return true;
		} catch (SQLException e) {
      e.printStackTrace();

			return false;
		}
  }

  public boolean doesFeedExsist(String feedLink) throws ClassNotFoundException {
    try (Connection con = super.getConnection()) {

      PreparedStatement ps = con.prepareStatement("SELECT * FROM feed WHERE feed_link = ?");
			ps.setString(1, feedLink);
			
      ResultSet result = ps.executeQuery();

      return !result.next();
    } catch (SQLException e) {
      e.printStackTrace();

			return false;
		}
  }

  public String getFeedIdByLink(String feedLink) throws ClassNotFoundException {
    try (Connection con = super.getConnection()) {

      PreparedStatement ps = con.prepareStatement("SELECT * FROM feed WHERE feed_link = ?");
			ps.setString(1, feedLink);
			
      ResultSet result = ps.executeQuery();
      String feedId = "";
      while(result.next()) {
        feedId = result.getString("feed_id");
      }

      return feedId;
    } catch (SQLException e) {
      e.printStackTrace();

			return null;
		}
  }



}