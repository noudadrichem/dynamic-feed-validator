package endpoints;


import javax.json.*;
import javax.ws.rs.*;
import javax.ws.rs.core.*;

import pojos.UploadedObject;

@Path("/xmlservice")
public class UploadXMLFeedUrl {

  @POST
  @Path("/upload")
  @Produces("application/json")
  public String uploadXMLFeedUrl(UploadedObject uploadedObject) {
    try {
      JsonObjectBuilder messageBuilder = Json.createObjectBuilder();
      messageBuilder.add("message", "Succesfully upload URL");

      return messageBuilder.build().toString();
    } catch(Exception e) {
      e.printStackTrace();
      JsonObjectBuilder messageBuilder = Json.createObjectBuilder();
      messageBuilder.add("message", "Failed to upload URL");

      return messageBuilder.build().toString();
    }
  }
}