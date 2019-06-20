package endpoints;

import javax.json.Json;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObjectBuilder;
import javax.ws.rs.*;

import models.Blueprint;
import models.BlueprintKey;
import persistence.blueprint.PostgresBlueprintDao;

@Path("/blueprint")
public class BlueprintService {
  
  private PostgresBlueprintDao dao = new PostgresBlueprintDao();

  @GET
  @Path("/{feedId}")
  @Produces("application/json")
  public String getAll(@PathParam("feedId") String feedId) throws ClassNotFoundException {
    
    Blueprint blueprint = dao.getBlueprintByFeedId(feedId);
    JsonObjectBuilder job = Json.createObjectBuilder();
    JsonArrayBuilder jab = Json.createArrayBuilder();

    if(blueprint.equals(null)) {
      job.add("message", "kapot");
    } else {
      for(String key : blueprint.getKeys()) {
        jab.add(key);
      }

      job
        .add("feedId", blueprint.getFeedId())
        .add("keys", jab);
    }

    return job.build().toString();
  }
}