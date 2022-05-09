package rest;

import classes.Artefakt;
import classes.Projekt_Aufgabenbereich;
import java.io.Serializable;
import java.net.URI;
import javax.annotation.Resource;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;

/**
 * REST interface for executeing imports
 *
 * @author
 */
@Path("artefact")    //Pfad der Ressource wird gesetzt

public class ArtefaktResource implements Serializable {

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response create(Artefakt art) {
        URI location = URI.create("/artefact?id=" + art.getId());  // hier ann man das angelegte abrufen
        ResponseBuilder rb = Response.created(location);

        URI delLocLink = URI.create("/artefact/delete?id=" + art.getId()); //hier kann man das angelegte löschen
        rb.link(delLocLink, "delete");

        rb.entity(art);
        return rb.build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response get(@QueryParam("id") Long id) {
        Artefakt art = new Artefakt();
        art.setId(id);
        art.setTitel("artefakt titel");
        ResponseBuilder rb = Response.ok(art);

        return rb.build();
    }
    
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response update(@QueryParam("id") Long id, Artefakt art) {
        art.setId(id);
        ResponseBuilder rb = Response.ok(art);

        return rb.build();
    }
    
    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    public Response delete(@QueryParam("id") Long id) {
        ResponseBuilder rb = Response.ok("deleted");

        return rb.build();
    }
}
