package socket;

import java.io.IOException;
import java.util.ArrayList;

import javax.json.Json;
import javax.json.JsonObjectBuilder;
import javax.websocket.Session;

import models.Message;

public class SessionHandler {

  private static SessionHandler sessionHandler = null;
  private static ArrayList<Session> sessions = new ArrayList<Session>();

  private SessionHandler() {}

  public static SessionHandler setInstance() {
    if (sessionHandler == null) {
      sessionHandler = new SessionHandler();
    }
    return sessionHandler;
  }

  public static SessionHandler getInstance() {
    return sessionHandler;
  }

  public Session getSession(String id) {
    Session tempSes = null;
    for(Session session : sessions) {
      if(session.getId().equals(id)) {
        tempSes = session;
      }
    }
    return tempSes;
  }

  public void addSession(Session session) {
    sessions.add(session);
  }

  public void sendToSocket(Message message, String socketSessionId) {
    JsonObjectBuilder messageJsonObj = Json.createObjectBuilder();
      messageJsonObj
        .add("title", message.getTitle())
        .add("description", message.getDescription())
        .add("productId", message.getProductId())
        .add("feedId", message.getfeedId())
        .add("type", message.getType())
        .add("hashed", message.getMessageHashCode());

    try {
      sessionHandler.getSession(socketSessionId).getBasicRemote().sendText(messageJsonObj.build().toString()); 
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}