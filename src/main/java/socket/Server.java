package socket;

import java.io.IOException;

import javax.websocket.*;
import javax.websocket.server.ServerEndpoint;

@ServerEndpoint("/socket")
public class Server {

  @OnOpen
  public void onOpen(Session session) {
    System.out.println("Open Connection session id=" + session.getId());

    // hier moet de session handler singleton gemaakt worden
    SessionHandler.setInstance(session);
  }

  @OnClose
  public void onClose() {
    System.out.println("Close Connection ...");
  }

  @OnMessage
  public void onMessage(String message) throws IOException, EncodeException {
    System.out.println("Message from the client: " + message);
  }

  @OnError
  public void onError(Throwable e) {
    e.printStackTrace();
  }
}