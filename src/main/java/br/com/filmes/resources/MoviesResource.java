package br.com.filmes.resources;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import br.com.filmes.model.Movies;



@Path("/movies")
public class MoviesResource {
    @GET
    @Produces(MediaType.APPLICATION_JSON) //tipo de conteúdo que o método irá retornar
    public String nomeFilme() {
        return "Titanic";
    }


    @Path("/titulo")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public void infoMovies(@PathParam("titulo") String titulo){
        Movies movie = new Movies();
        movie.getTitulo();
    }
    
}
