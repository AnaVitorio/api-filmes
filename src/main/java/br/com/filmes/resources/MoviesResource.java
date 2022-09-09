package br.com.filmes.resources;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.eclipse.microprofile.openapi.annotations.parameters.RequestBody;
import br.com.filmes.model.MoviesDto;
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


    @Path("/buscar/{titulo}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response buscarFilmePeloNome(@PathParam("titulo") String titulo){
        return Response.ok(movieService.buscarFilmePeloNome(titulo)).build();
        
    }

    @Path("/adicionar")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response adicionarFilmes(@RequestBody MoviesDto filme){
        return Response.ok(movieService.adicionarFilmes(filme)).build();
    }

    @Path("/atualizar/{id}")
    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response atualizarFilme(@RequestBody MoviesDto filmeAtualizado, @PathParam("id") Long id){
        return Response.ok(movieService.atualizarFilme(filmeAtualizado, id)).build();
    }

    @Path("/deletar/{id}")
    @DELETE
    public Response deletarFilme(@PathParam("id") Long id){
        return movieService.deletarFilme(id);
    }
    
}
