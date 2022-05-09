package rest;

import classes.Projekt;
import java.io.Serializable;
import java.net.URI;
import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.transaction.HeuristicMixedException;
import javax.transaction.HeuristicRollbackException;
import javax.transaction.NotSupportedException;
import javax.transaction.RollbackException;
import javax.transaction.SystemException;
import javax.transaction.UserTransaction;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.DELETE;
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
@Stateless
@TransactionManagement(TransactionManagementType.BEAN)
@Path("project")    //Pfad der Ressource wird gesetzt
public class ProjektResource implements Serializable {
    @PersistenceContext(unitName = "JPA_PU")   //Entity Manager muss vom Payara zum Start in einer REST-Ressource gefunden werden
    private EntityManager em;
    

    @Resource
    private UserTransaction utx;

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response create(ProjektAdapter pa) {
        try {
            this.utx.begin();
            //adapter in Objekt umwandeln - Adapater zur Umwandlung des Datums von JSON und für Referenzen notwendig
            Projekt proj = pa.toProject();  
            this.em.persist(proj);          // em speichert in die Tabelle
            this.utx.commit();
            
            URI location = URI.create("/project?id=" + proj.getId());  // hier kann man das angelegte abrufen
            ResponseBuilder rb = Response.created(location);   // response 201 für cerated
            // Example for createing a HATEOAS link
            URI delLocLink = URI.create("/project/delete?id=" + proj.getId()); //hier kann man das angelegte löschen
            rb.link(delLocLink, "delete");
            return rb.build();

        } catch (NotSupportedException | SystemException | RollbackException | HeuristicMixedException | HeuristicRollbackException | SecurityException | IllegalStateException ex) {
            // Better to add a error message here...
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response get(@QueryParam("id") Long id) {
        Projekt proj = new Projekt();
        proj.setId(id);
        proj.setTitel("exampleTitel");
        ResponseBuilder rb = Response.ok(proj);

        return rb.build();
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response update(@QueryParam("id") Long id, ProjektAdapter pa) {
        Projekt proj = pa.toProject();
        proj.setId(id);
        ResponseBuilder rb = Response.ok(proj);

        return rb.build();
    }

    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    public Response delete(@QueryParam("id") Long id) {
        ResponseBuilder rb = Response.ok("deleted");

        return rb.build();
    }
}
