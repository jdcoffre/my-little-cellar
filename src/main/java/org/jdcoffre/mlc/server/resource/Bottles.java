package org.jdcoffre.mlc.server.resource;

import com.codahale.metrics.annotation.Timed;
import org.jdcoffre.mlc.server.api.Bottle;
import org.jdcoffre.mlc.server.db.Database;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;
import java.io.IOException;
import java.util.List;

@Path("/bottles")
@Produces(MediaType.APPLICATION_JSON)
public class Bottles {

    private final Database db;

    public Bottles(final Database db) {
        this.db = db;
    }

    @GET
    @Timed
    public List<Bottle> getBottles() {
        return db.getBottles();
    }

    @POST
    @Timed
    public Response postBottle(@Valid @NotNull Bottle bottle) throws IOException {
        if(db.exist(bottle)){
            return Response.status(Response.Status.CONFLICT).build();
        }

        db.addBottle(bottle);
        return Response.created(UriBuilder.fromResource(Bottles.class).build()).build();
    }

}
