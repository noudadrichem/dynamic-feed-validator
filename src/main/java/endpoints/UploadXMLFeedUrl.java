package endpoints;

import javax.json.*;
import javax.ws.rs.*;
import org.w3c.dom.Document;
import org.w3c.dom.Element;


import pojos.PostUrlObj;
import services.ReadXMLFile;

@Path("/xmlservice")
public class UploadXMLFeedUrl {

  @POST
  @Path("/upload")
  @Produces("application/json")
  public String uploadXMLFeedUrl(PostUrlObj uploadedObject) {
    System.out.println("made contact");

    try {
      JsonObjectBuilder messageBuilder = Json.createObjectBuilder();
      String XMLURL = uploadedObject.getUrl();
      ReadXMLFile readXMLFile = new ReadXMLFile(XMLURL);

      Document doc = readXMLFile.StreamXMLFile();

      Element root = doc.getDocumentElement();
      System.out.println(root.getTagName());
      // Document loaded = readXMLFile.loadDocument();

      // System.out.println("loaded");
      // System.out.println(loaded.getFirstChild().getNodeName());
      
      messageBuilder
        .add("message", "Succesfully upload URL");

      return messageBuilder.build().toString();
    } catch(Exception e) {
      e.printStackTrace();
      JsonObjectBuilder messageBuilder = Json.createObjectBuilder();
      messageBuilder.add("message", "Failed to upload URL");

      return messageBuilder.build().toString();
    }
  }
}