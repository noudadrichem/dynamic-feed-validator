package endpoints;

import javax.json.*;
import javax.ws.rs.*;

import models.PostUrlObj;
import services.ValidationThread;

@Path("/xmlservice")
public class UploadXMLFeedUrl {

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