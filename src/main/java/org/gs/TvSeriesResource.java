package org.gs;

import org.eclipse.microprofile.rest.client.inject.RestClient;
import org.gs.model.Episode;
import org.gs.model.TvSeries;
import org.gs.proxy.EpisodeProxy;
import org.gs.proxy.TvSeriesProxy;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Path("/tvseries")
public class TvSeriesResource {

  @RestClient TvSeriesProxy proxy;
  @RestClient
  EpisodeProxy episodeProxy;

  private List<TvSeries> tvSeriesList = new ArrayList<>();

  @GET
  @Produces(MediaType.APPLICATION_JSON)
  public Response get(@QueryParam("title") String title) {
    TvSeries tvSeries = proxy.get(title);
    List<Episode> episodes = episodeProxy.get(tvSeries.getId());
    tvSeriesList.add(tvSeries);
    return Response.ok(episodes).build();
  }
}
