package endpoints;

import javax.json.Json;
import javax.json.JsonObjectBuilder;
import javax.ws.rs.*;

@Path("/ping")
public class MainEndpoint {
  @GET
  @Produces("application/json")
  public String ping() {
    JsonObjectBuilder pingObject = Json.createObjectBuilder();
    pingObject
      .add("ping", "pong");

    return pingObject.build().toString();
  }

  @GET
  @Path("/pong")
  public String pong() {
    return "<h1>Dit is h1 in HTML</h1>";
  }

  @GET
  @Path("/a/{message}")
  @Produces("application/json")
  public String pingThePong(@PathParam("message") String message) {
    JsonObjectBuilder pingObject = Json.createObjectBuilder();
    pingObject
      .add("message", message);

    return pingObject.build().toString();
  }
}