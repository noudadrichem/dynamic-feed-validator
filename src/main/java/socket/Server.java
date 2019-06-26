package socket;

import java.io.IOException;

import javax.websocket.*;
import javax.websocket.server.ServerEndpoint;

import models.Message;

@ServerEndpoint("/socket")
public class Server {

  
  private Session session;
  private String sessionId; 

  @OnOpen
  public void onOpen(Session session) {
    System.out.println("Open Connection session id=" + session.getId());

    this.sessionId = session.getId();
    this.session = session;
  }

  @OnClose
  public void onClose() {
    System.out.println("Close Connection ...");
  }

  @OnMessage
  public String onMessage(String message) {
    System.out.println("Message from the client: " + message);
    String echoMsg = "Echo from the server : " + message;
    return echoMsg;
  }

  @OnError
  public void onError(Throwable e) {
    e.printStackTrace();
  }

  public void emitMessage(Message message) throws IOException, EncodeException {
    System.out.println("active feed Id from server=" + this.feedId);
    if(this.feedId.equals(message.getfeedId()) && this.feedId != null) {
      this.session.getBasicRemote().sendObject(message);
    }
  }

  public void setFeedId(String feedId) {
    this.feedId = feedId;
  }

}