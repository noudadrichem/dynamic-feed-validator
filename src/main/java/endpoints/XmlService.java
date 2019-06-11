package endpoints;

import javax.json.*;
import javax.ws.rs.*;

import models.PostUrlObj;
import services.ValidationThread;

@Path("/xmlservice")
public class XmlService {

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

  @GET
  @Path("/all")
  @Produces("application/json")
  public String getAllFeeds() {
    JsonObjectBuilder messageBuilder = Json.createObjectBuilder();

    messageBuilder.add("get", "all feeds");

    return messageBuilder.build().toString();
  }
}