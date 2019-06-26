package socket;

import java.io.IOException;
import java.util.ArrayList;

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

  public void sendMessage(String sessionId, String message) throws IOException {
    getSession(sessionId).getBasicRemote().sendText(message);
  }
}