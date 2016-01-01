package org.jdcoffre.mlc.server.resource;

import com.codahale.metrics.annotation.Timed;
import com.google.common.base.Optional;
import org.jdcoffre.mlc.server.api.Bottle;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

@Path("/bottles")
@Produces(MediaType.APPLICATION_JSON)
public class Bottles {

    @GET
    @Timed
    public Bottle getBottle(@QueryParam("name") Optional<String> name) {
        return new Bottle();
    }

}
