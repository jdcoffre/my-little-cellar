package org.jdcoffre.mlc.server.resource;

import io.dropwizard.views.View;
import org.jdcoffre.mlc.server.view.BottleForm;
import org.jdcoffre.mlc.server.view.CellarForm;

import javax.ws.rs.GET;
import javax.ws.rs.Path;


@Path("/")
public class WebApp {

    @GET
    @Path("/bottle/new")
    public View getBottleForm(){
        return new BottleForm();
    }

    @GET
    @Path("/cellar")
    public View getCellar(){
        return new CellarForm();
    }

}
