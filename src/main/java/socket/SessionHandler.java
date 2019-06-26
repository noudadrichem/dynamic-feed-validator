package socket;

import java.io.IOException;
import java.util.List;

import javax.websocket.Session;

import models.Message;

public class SessionHandler {

  private static SessionHandler sessionHandler = null;
  public Session session;

  // public ArrayList<\> subscribers;
  private SessionHandler(Session session) {
    this.session = session;
  }

  public static SessionHandler setInstance(Session session) {
    if (sessionHandler == null) {
      sessionHandler = new SessionHandler(session);
    }
    return sessionHandler;
  }

  public static SessionHandler getInstance() {
    return sessionHandler;
  }

  public void setSession(Session session) {
    this.session = session;
  }

  public Session getSession() {
    return this.session;
  }

  public void sendMessage(String message) throws IOException {
    // hier moet dan een session iets komen die een message stuurt
    this.session.getBasicRemote().sendText(message);
  }
}