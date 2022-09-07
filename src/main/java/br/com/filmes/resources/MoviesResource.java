package br.com.filmes.resources;

import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import br.com.filmes.model.Movies;
import br.com.filmes.service.MovieService;


@Path("/movies")
@ApplicationScoped
public class MoviesResource {

    private MovieService movieService;

    public MoviesResource(MovieService movieService){
        this.movieService = movieService;
    }

    @Path("/listar")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response listarFilmes() {
        return Response.ok(movieService.listarFilmes()).build();
    }


    @Path("/titulo")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public void infoMovies(@PathParam("titulo") String titulo){
        
    }
    
}
