package br.com.tiago.csv;

import javax.enterprise.context.RequestScoped;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;


@RequestScoped
@Path("/csv")
public class Resource {

    @GET
    @Produces("text/csv")
    public Response createCSV() {
        return Response.ok("Olá").build();
    }
}
