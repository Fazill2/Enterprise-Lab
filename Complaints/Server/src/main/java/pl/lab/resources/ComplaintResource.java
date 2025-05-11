package pl.lab.resources;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import pl.lab.dto.ComplaintDTO;
import pl.lab.service.ComplaintService;

import java.util.List;

@RequestScoped
@Path("/complaints")
public class ComplaintResource {

    @Inject
    private ComplaintService service;

    @GET
    @Produces(jakarta.ws.rs.core.MediaType.APPLICATION_JSON)
    public List<ComplaintDTO> getAllComplaints(@QueryParam("status") String status) {
        return service.findAll(status);
    }
    @GET
    @Path("{id}")
    @Produces(jakarta.ws.rs.core.MediaType.APPLICATION_JSON)
    public ComplaintDTO getComplaint(@PathParam("id") Long id) {
        return service.find(id);
    }
    @POST
    @Consumes(jakarta.ws.rs.core.MediaType.APPLICATION_JSON)
    public void postComplaint(ComplaintDTO complaint) {
        service.create(complaint);
    }
    @PUT
    @Consumes(jakarta.ws.rs.core.MediaType.APPLICATION_JSON)
    public void putComplaint( ComplaintDTO
            complaint) {
        service.edit(complaint);
    }
    @DELETE
    @Path("{id}")
    public void deleteComplaint(@PathParam("id") Long id) {
        service.remove(service.find(id));
    }

    @GET
    @Path("{id}/status")
    @Produces(jakarta.ws.rs.core.MediaType.TEXT_PLAIN)
    public String checkStatus(@PathParam("id") Long id) {
        return service.find(id).getStatus();
    }
}
