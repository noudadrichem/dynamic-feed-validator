package endpoints;

import javax.json.Json;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObjectBuilder;
import javax.ws.rs.*;

import models.Message;
import persistence.message.PostgresMessageDao;

@Path("/message")
public class MessageService {
  
  private static PostgresMessageDao dao = new PostgresMessageDao();

  @GET
  @Path("/all/{feedId}")
  @Produces("application/json")
  public String getAll(@PathParam("feedId") String feedId) throws ClassNotFoundException {
    JsonArrayBuilder jab = Json.createArrayBuilder();
    
    for(Message message : dao.getAllMessagesByFeedId(feedId)) {
      JsonObjectBuilder job = Json.createObjectBuilder();
      job
        .add("title", message.getTitle())
        .add("description", message.getDescription())
        .add("productId", message.getProductId())
        .add("feedId", message.getfeedId())
        .add("type", message.getType())
        .add("hashed", message.getMessageHashCode());

      jab.add(job);
    }

    return jab.build().toString();
  }
}