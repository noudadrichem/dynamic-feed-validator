package endpoints;

import javax.json.Json;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObjectBuilder;
import javax.ws.rs.*;

import models.Feed;
import persistence.feed.PostgresFeedDao;
import models.PostUrlObj;
import services.ValidationThread;

@Path("/feed")
public class FeedService {
  private PostgresFeedDao dao = new PostgresFeedDao();

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
  public String pingThePong(@PathParam("id") String id) throws ClassNotFoundException {
    JsonObjectBuilder job = Json.createObjectBuilder();

    Feed feed = dao.getFeedByid(id);

    job
      .add("id", feed.getId())
      .add("title", feed.getTitle())
      .add("description", feed.getDescription())
      .add("feedLink", feed.getFeedLink());

    return job.build().toString();
  }

  @POST
  @Path("/upload")
  @Produces("application/json")
  public String uploadXMLFeedUrl(PostUrlObj uploadedObject) {
    System.out.println("made contact");

    try {
      String XMLURL = uploadedObject.getUrl();
      JsonObjectBuilder messageBuilder = Json.createObjectBuilder();

      if(XMLURL.startsWith("http")) {
        messageBuilder.add("message", "Succesfully upload URL");

        ValidationThread validationThread = new ValidationThread(XMLURL);
        validationThread.start();

        System.out.println("validation thread status = " + validationThread.toString());

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
}