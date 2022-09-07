package br.com.filmes.service;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import br.com.filmes.dao.MoviesDao;
import br.com.filmes.model.Movies;

@ApplicationScoped
public class MovieService {
    
    private MoviesDao moviesDao;

    public MovieService(MoviesDao moviesDao){
        this.moviesDao = moviesDao;
    }

    @Produces(MediaType.APPLICATION_JSON)
    public List<Movies> listarFilmes(){
        return moviesDao.listarFilmes();
    }

    @Produces(MediaType.APPLICATION_JSON)
    public List<Movies> adicionarFilmes(List<Movies> filmes) {
        return moviesDao.adicionarFilmes(filmes);

    }

    @Produces(MediaType.APPLICATION_JSON)
    public Movies buscarFilmePeloNome(String titulo){
        return moviesDao.buscarFilmePeloNome(titulo.toLowerCase());
    }


}
