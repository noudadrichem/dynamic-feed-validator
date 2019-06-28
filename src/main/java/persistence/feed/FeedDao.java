package persistence.feed;

import java.util.ArrayList;

import models.Feed;

public interface FeedDao {
     
  public boolean saveFeed(Feed feed) throws ClassNotFoundException;
   
  public boolean doesFeedExsist(String feedLink) throws ClassNotFoundException;
   
  public String getFeedIdByLink(String feedLink) throws ClassNotFoundException;
   
  public ArrayList<Feed> getAllFeedsByUser(String userId) throws ClassNotFoundException;
   
  public Feed getFeedByid(String feedId) throws ClassNotFoundException;

  public boolean deleteFeed(String feedId);

  public boolean updateFeed(String feedId, String key, String value);
}