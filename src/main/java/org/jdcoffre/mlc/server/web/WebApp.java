package org.jdcoffre.mlc.server.web;

import io.dropwizard.views.View;

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
