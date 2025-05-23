package br.com.filmes.resources;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.validation.Valid;
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

import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.parameters.RequestBody;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponses;

import br.com.filmes.model.MoviesDto;
import br.com.filmes.service.MovieService;


@Path("/movies")
@ApplicationScoped
public class MoviesResource {

    @Inject
    private MovieService movieService;


    @Path("/listar/todos")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @APIResponses(value = {
        @APIResponse(responseCode = "200", description = "Lista de filmes retornada com sucesso"),
    })
    @Operation(
        summary = "Lista todos os filmes da base",
        description = "REST Endpoint que retorna todos os filmes da base")
    public Response listarTodasInfoFilmes() {
        return Response.ok(movieService.listarTodosFilmes()).build();
    }

    @Path("/listar/{pag}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @APIResponses(value = {
        @APIResponse(responseCode = "200", description = "Lista de filmes retornada com sucesso"),
    })
    @Operation(
        summary = "Lista os filmes com paginação",
        description = "REST Endpoint que retorna os filmes de acordo com o número da página passado.")
    public Response listarFilmes(@PathParam("pag") int pag) throws Exception {
        return Response.ok(movieService.listarFilmes(pag)).build();
    }

    @Path("/buscar/{titulo}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @APIResponses(value = {
        @APIResponse(responseCode = "200", description = "Filme encontado com sucesso"),
        @APIResponse(responseCode = "404", description = "Filme não encontrado"),
    })
    @Operation(
        summary = "Busca o filme pelo título",
        description = "REST Endpoint que retorna o filme, com base no título, se encontado na base.")
    public Response buscarFilmePeloNome(@PathParam("titulo") String titulo){
        return movieService.buscarFilmePeloNome(titulo);
        
    }

    @Path("/adicionar")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @APIResponses(value = {
        @APIResponse(responseCode = "201", description = "Filme cadastrado com sucesso"),
    })
    @Operation(
        summary = "Cadastra novo filme na base",
        description = "REST Endpoint que cadastra o filme e retorna os dados cadastrado.")
    public Response adicionarFilmes(@Valid @RequestBody MoviesDto filme){
        return movieService.adicionarFilmes(filme);
    }

    @Path("/atualizar/{id}")
    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @APIResponses(value = {
        @APIResponse(responseCode = "200", description = "Filme atualizado com sucesso"),
    })
    @Operation(
        summary = "Atualiza dados de um filme",
        description = "REST Endpoint que atualiza os dados de um filme e retorna os dados atualizados.")
    public Response atualizarFilme(@Valid @RequestBody MoviesDto filmeAtualizado, @PathParam("id") Long id){
        return Response.ok(movieService.atualizarFilme(filmeAtualizado, id)).build();
    }

    @Path("/deletar/{id}")
    @DELETE
    @APIResponses(value = {
        @APIResponse(responseCode = "200", description = "Filme deletado com sucesso"),
        @APIResponse(responseCode = "404", description = "Filme não encontrado"),
    })
    @Operation(
        summary = "Deleta filme da base",
        description = "REST Endpoint que deleta o filme da base.")
    public Response deletarFilme(@PathParam("id") Long id){
        return movieService.deletarFilme(id);
    }
    
}
