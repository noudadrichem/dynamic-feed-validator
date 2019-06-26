package persistence.message;

import java.util.ArrayList;

import models.Message;

public interface MessageDao {
     
  abstract public boolean saveMessage(Message message);

  abstract public ArrayList<String> getAllMessageHashesByFeedId(String feedId);
   
  abstract public ArrayList<Message> getAllMessagesByFeedId(String feedId);
   
  abstract public boolean deleteMessage(String feedId);
  
  abstract public boolean updateMessage(String messageId, String key, String value);
}