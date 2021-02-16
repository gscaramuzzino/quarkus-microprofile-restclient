package org.gs.proxy;

import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;
import org.gs.model.Episode;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/shows")
@Produces(MediaType.APPLICATION_JSON)
@RegisterRestClient
public interface EpisodeProxy {

  @GET
  @Path("/{id}/episodes")
  List<Episode> get(@PathParam("id") Long id);
}
