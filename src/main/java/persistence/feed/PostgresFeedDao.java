package persistence.feed;

import java.sql.*;
import java.text.*;
import java.util.ArrayList;

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


  public ArrayList<Feed> getAllFeedsByUser(String userId) throws ClassNotFoundException {
    ArrayList<Feed> tempFeeds = new ArrayList<Feed>();
    try (Connection con = super.getConnection()) {

      PreparedStatement ps = con.prepareStatement("SELECT * FROM feed WHERE account_id = ?");
      ps.setInt(1, Integer.parseInt(userId));
      ResultSet result = ps.executeQuery();
    
      while(result.next()) {
        tempFeeds.add(new Feed(
          result.getString("feed_id"),
          result.getString("title"),
          result.getString("description"),
          result.getString("feed_link")
        ));
      }
      
      return tempFeeds;
    } catch (SQLException e) {
      e.printStackTrace();

			return null;
    }
  }

  public Feed getFeedByid(String feedId) throws ClassNotFoundException {
    try (Connection con = super.getConnection()) {

      PreparedStatement ps = con.prepareStatement("SELECT * FROM feed WHERE feed_id = ?");
      ps.setString(1, feedId);
      ResultSet result = ps.executeQuery();
    
      return result.next() 
        ? new Feed(
          result.getString("feed_id"),
          result.getString("title"),
          result.getString("description"),
          result.getString("feed_link")
          ) 
        : null;
      
    } catch (SQLException e) {
      e.printStackTrace();

			return null;
    }

  }



}