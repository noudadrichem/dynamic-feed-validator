package endpoints;

import java.util.ArrayList;

import javax.json.Json;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObjectBuilder;
import javax.ws.rs.*;

import models.Feed;
import models.Message;
import persistence.blueprint.PostgresBlueprintDao;
import persistence.feed.PostgresFeedDao;
import persistence.message.PostgresMessageDao;
import persistence.product.PostgresProductDao;
import models.PostUrlObj;
import services.ValidationThread;

@Path("/feed")
public class FeedService {
  private PostgresFeedDao dao = new PostgresFeedDao();
  private PostgresMessageDao messageDao = new PostgresMessageDao();
  private PostgresProductDao productDao = new PostgresProductDao();
  private PostgresBlueprintDao bluePrintDao = new PostgresBlueprintDao();

  private final String USER_ID = "1";

  @GET
  @Path("/all")
  @Produces("application/json")
  public String getAll() throws ClassNotFoundException {
    JsonArrayBuilder jab = Json.createArrayBuilder();
    
    for(Feed feed : dao.getAllFeedsByUser(USER_ID)) {
      JsonObjectBuilder job = Json.createObjectBuilder();
      job
        .add("id", feed.getId())
        .add("title", feed.getTitle())
        .add("description", feed.getDescription())
        .add("feedLink", feed.getFeedLink());

      jab.add(job);
    }

    return jab.build().toString();
  }

  @GET
  @Path("/{id}")
  @Produces("application/json")
  public String pingThePong(@PathParam("id") String feedId) throws ClassNotFoundException {
    JsonObjectBuilder job = Json.createObjectBuilder();

    Feed feed = dao.getFeedByid(feedId);

    ArrayList<Message> messages = messageDao.getAllMessagesByFeedId(feedId);
    JsonArrayBuilder jab = Json.createArrayBuilder();
    for(Message message : messages) {
      JsonObjectBuilder jobMessage = Json.createObjectBuilder();
      jobMessage  
        .add("title", message.getTitle())
        .add("description", message.getDescription())
        .add("productId", message.getProductId())
        .add("feedId", message.getfeedId())
        .add("type", message.getType())
        .add("hashed", message.getMessageHashCode());

      jab.add(jobMessage);
    }

    job
    .add("id", feed.getId())
    .add("title", feed.getTitle())
    .add("description", feed.getDescription())
    .add("feedLink", feed.getFeedLink())
    .add("messages", jab);

    return job.build().toString();
  }

  @POST
  @Path("/upload")
  @Produces("application/json")
  public String uploadXMLFeedUrl(PostUrlObj uploadedObject) {
    try {
      String XMLURL = uploadedObject.getUrl();
      JsonObjectBuilder messageBuilder = Json.createObjectBuilder();

      if(XMLURL.startsWith("http")) {
        messageBuilder.add("message", "Succesfully upload URL");

        ValidationThread validationThread = new ValidationThread(XMLURL);
        validationThread.start();

      } else {
        messageBuilder.add("message", "Not a valid URL");
      }
      
      return messageBuilder.build().toString();

    } catch(Exception e) {
      e.printStackTrace();
      JsonObjectBuilder messageBuilder = Json.createObjectBuilder();
      messageBuilder.add("message", "Failed to upload URL");

      return messageBuilder.build().toString();
    }
  }

  @DELETE
  @Path("/delete/{id}")
  @Produces("application/json")
  public String deleteFeed(@PathParam("id") String feedId) {
    JsonObjectBuilder messageBuilder = Json.createObjectBuilder();

    try {
      boolean isSuccesfullyDeleted = (
        bluePrintDao.deleteBlueprint(feedId) &&
        productDao.deleteProdcut(feedId) &&
        messageDao.deleteMessage(feedId) &&
        dao.deleteFeed(feedId)
      );
      messageBuilder
        .add("message", isSuccesfullyDeleted ? "Succesfully deleted feed." : "Failed to delete feed.")
        .add("success", isSuccesfullyDeleted);

      return messageBuilder.build().toString();
    } catch(Exception e) {
      messageBuilder.add("message", "Failed to delete feed.");
      return messageBuilder.build().toString();
    }
  }
}