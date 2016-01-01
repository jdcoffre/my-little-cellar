package org.jdcoffre.mlc.server.resource;

import org.jdcoffre.mlc.server.view.Root;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/")
@Produces(MediaType.TEXT_HTML)
public class Webapp {

    @GET
    public Root getRootView(){
        return new Root();
    }
}
