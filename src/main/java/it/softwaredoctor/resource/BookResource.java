package it.softwaredoctor.resource;

import it.softwaredoctor.dto.BookDTO;
import it.softwaredoctor.service.BookService;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.util.List;

@Path("/books")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class BookResource {

    @Inject
    BookService bookService;

    @GET
    public Response getAll() {
        List<BookDTO> books = bookService.listAll();
        return Response.ok(books).build();
    }

    @POST
    public Response create(BookDTO dto) {
        bookService.create(dto);
        return Response.status(Response.Status.CREATED).build();
    }
}
