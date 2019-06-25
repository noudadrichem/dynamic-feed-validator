package endpoints;

import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

import javax.json.Json;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObjectBuilder;
import javax.ws.rs.*;

import models.Message;
import persistence.message.PostgresMessageDao;

import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnError;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
 
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

 
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;


@ServerEndpoint("/message/{account_id}")
public class MessageService {
 
    @OnOpen
    public void onOpen(Session session) throws IOException {
        // Get session and WebSocket connection
        System.out.println("socket openend");
    }
 
    @OnMessage
    public void onMessage(Session session, Message message) throws IOException {
        // Handle new messages
        System.out.println("socket message recieved");
    }
 
    @OnClose
    public void onClose(Session session) throws IOException {
        // WebSocket connection closes
        System.out.println("socket closed");
    }
 
    @OnError
    public void onError(Session session, Throwable throwable) {
        // Do error handling here
        System.out.println("socket error"); 
    }
}

// // @Path("/message")
// @ServerEndpoint("/message/{account-id}")
// public class MessageService {

//   private PostgresMessageDao dao = new PostgresMessageDao();

//   private static Set peers = Collections.synchronizedSet(new HashSet());

//   // @OnMessage
//   // public String onMessage(String message, Session session, @PathParam("account-id") String accountId) {
//   //   try {
//   //     JSONObject jObj = new JSONObject(message);
//   //     System.out.println("received message from account " + accountId);
//   //     for (Session s : peers) {
//   //       try {
//   //         s.getBasicRemote().sendText(message);
//   //         System.out.println("send message to peer ");
//   //       } catch (IOException e) {
//   //         e.printStackTrace();
//   //       }

//   //     }
//   //   } catch (JSONException e) {
//   //     e.printStackTrace();
//   //   }
//   //   return "message was received by socket mediator and processed: " + message;
//   // }

//   @OnOpen
//   public void onOpen(Session session, @PathParam("account-id") String accountId) {
//     System.out.println("mediator: opened websocket channel for account " + accountId);
//     peers.add(session);

//     try {
//       session.getBasicRemote().sendText("good to be in touch");
//     } catch (IOException e) {
//     }
//   }

//   @OnClose
//   public void onClose(Session session, @PathParam("account-id") String accountId) {
//     System.out.println("mediator: closed websocket channel for account " + accountId);
//     peers.remove(session);
//   }

//   // @GET
//   // @Path("/subscribe")
//   @OnOpen
//   public void provideServerSocket() throws IOException {

//     ServerSocket serverSocket = new ServerSocket(4040);
//     Socket socket = serverSocket.accept();

//     OutputStream output = socket.getOutputStream();
//     output.write("yeay sure output".getBytes());

//     serverSocket.close();
//   }
// }