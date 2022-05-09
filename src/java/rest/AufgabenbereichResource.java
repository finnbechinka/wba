package rest;

import classes.Artefakt;
import classes.Aufgabenbereich;
import java.io.Serializable;
import java.net.URI;
import java.util.List;
import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.HeuristicMixedException;
import javax.transaction.HeuristicRollbackException;
import javax.transaction.NotSupportedException;
import javax.transaction.RollbackException;
import javax.transaction.SystemException;
import javax.transaction.UserTransaction;
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
@Stateless
@TransactionManagement(TransactionManagementType.BEAN)
@Path("scope")    //Pfad der Ressource wird gesetzt

public class AufgabenbereichResource implements Serializable {
    @PersistenceContext(unitName = "JPA_PU")   //Entity Manager muss vom Payara zum Start in einer REST-Ressource gefunden werden
    private EntityManager em;
    

    @Resource
    private UserTransaction utx;

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response create(AufgabenbereichAdapter ab) {
        try {
            this.utx.begin();
            //adapter in Objekt umwandeln - Adapater zur Umwandlung des Datums von JSON und für Referenzen notwendig
            Aufgabenbereich auf = ab.toAufgabenbereich();  
            this.em.persist(auf);          // em speichert in die Tabelle
            this.utx.commit();
            
            URI location = URI.create("/project?id=" + auf.getId());  // hier kann man das angelegte abrufen
            ResponseBuilder rb = Response.created(location);   // response 201 für cerated
            // Example for createing a HATEOAS link
            URI delLocLink = URI.create("/project/delete?id=" + auf.getId()); //hier kann man das angelegte löschen
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
        try {
            if(id==null){
                Query query = this.em.createNamedQuery("aufgabenbereich.findAll",Aufgabenbereich.class);
                List<Aufgabenbereich> p = (List<Aufgabenbereich>) query.getResultList();
                ResponseBuilder rb = Response.ok(p);
                
                return rb.build();
            }else{
                Query query = this.em.createNamedQuery("aufgabenbereich.findById",Aufgabenbereich.class);
                query.setParameter("id", id);
                Aufgabenbereich p = (Aufgabenbereich) query.getSingleResult();
                ResponseBuilder rb = Response.ok(p);
                
                return rb.build();
            }

        } catch (Exception e) {
            // Better to add a error message here...
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
        }
    }
    
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response update(@QueryParam("id") Long id, Aufgabenbereich ab) {
        ab.setId(id);
        ResponseBuilder rb = Response.ok(ab);

        return rb.build();
    }
    
    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    public Response delete(@QueryParam("id") Long id) {
        ResponseBuilder rb = Response.ok("deleted");

        return rb.build();
    }
}
