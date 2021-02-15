package org.gs.proxy;

import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;
import org.gs.model.TvSeries;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

@Path("/singlesearch")
@Produces(MediaType.APPLICATION_JSON)
@RegisterRestClient
public interface TvSeriesProxy {

  @GET
  @Path("/shows")
  TvSeries get(@QueryParam("q") String query);
}
