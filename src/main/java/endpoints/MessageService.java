// package endpoints;

// import java.io.IOException;
// import java.io.OutputStream;
// import java.net.ServerSocket;
// import java.net.Socket;

// import javax.json.Json;
// import javax.json.JsonArrayBuilder;
// import javax.json.JsonObjectBuilder;
// import javax.ws.rs.*;
// import javax.ws.rs.core.Context;
// import javax.ws.rs.sse.OutboundSseEvent;
// import javax.ws.rs.sse.Sse;
// import javax.ws.rs.sse.SseBroadcaster;
// import javax.ws.rs.sse.SseEventSink;

// import models.Message;
// import persistence.message.PostgresMessageDao;

// import javax.websocket.OnClose;
// import javax.websocket.OnMessage;
// import javax.websocket.OnError;
// import javax.websocket.OnOpen;
// import javax.websocket.Session;
// import javax.websocket.server.PathParam;
// import javax.websocket.server.ServerEndpoint;

// import java.util.Collections;
// import java.util.HashMap;
// import java.util.HashSet;
// import java.util.Set;
// import java.util.concurrent.CopyOnWriteArraySet;

// import org.codehaus.jettison.json.JSONException;
// import org.codehaus.jettison.json.JSONObject;
// import org.glassfish.jersey.server.internal.monitoring.EmptyRequestEventBuilder;

// @Path("/message")
// public class MessageService {

//   private Sse sse;
//   private EmptyRequestEventBuilder eventBuilder;
//   private SseBroadcaster sseBroadcaster;

//   @GET
//   @Path("subscripte")
//   @Produces("text/event-stream")
//   public void getStockPrices(@Context SseEventSink sseEventSink /*..*/) {
//       int lastEventId = //..;;
//       while (running) {
//           Stock stock = stockService.getNextTransaction(lastEventId);
//           if (stock != null) {
//               OutboundSseEvent sseEvent = this.eventBuilder
//                 .name("stock")
//                 .id(String.valueOf(lastEventId))
//                 .mediaType(MediaType.APPLICATION_JSON_TYPE)
//                 .data(Stock.class, stock)
//                 .reconnectDelay(3000)
//                 .comment("price change")
//                 .build();
//               sseEventSink.send(sseEvent);
//               lastEventId++;
//           }
//        //..
//       }
//       sseEventSink.close();
//   }

//   // @Context
//   // public void setSse(Sse sse) {
//   //   this.sse = sse;
//   //   this.eventBuilder = sse.newEventBuilder();
//   //   this.sseBroadcaster = sse.newBroadcaster();

//   //   // OutboundSseEvent sseEvent = this.eventBuilder
//   //   //   .name("stock")
//   //   //   .id(String.valueOf(lastEventId))
//   //   //   .mediaType(MediaType.APPLICATION_JSON_TYPE)
//   //   //   .data(Stock.class, stock)
//   //   //   .reconnectDelay(4000)
//   //   //   .comment("price change")
//   //   //   .build();
//   // }
// }

// // @ServerEndpoint("/message/{account_id}")
// // public class MessageService {

// //   private Session session;
// //   private static Set<Message> Message = new CopyOnWriteArraySet<>();
// //   private static HashMap<String, String> feeds = new HashMap<>();
// //   private PostgresMessageDao dao = new PostgresMessageDao();

// //   @OnOpen
// //   public void onOpen(Session session) throws IOException {
// //     this.session = session;
// //     System.out.println("socket openend");
// //   }

// //   @OnMessage
// //   public void onMessage(Session session, Message message) throws IOException {
// //     // Handle new messages
// //     System.out.println("socket message recieved");
// //   }

// //   @OnClose
// //   public void onClose(Session session) throws IOException {
// //     // WebSocket connection closes
// //     System.out.println("socket closed");
// //   }

// //   @OnError
// //   public void onError(Session session, Throwable throwable) {
// //     // Do error handling here
// //     System.out.println("socket error");
// //   }
// // }
