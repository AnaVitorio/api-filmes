package br.com.filmes.dao;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;

import br.com.filmes.model.Movies;

@ApplicationScoped
public class MoviesDao {

    public List<Movies> listarFilmes(){
        List<Movies> listaFilmes = Movies.findAll().list();
        return listaFilmes;
    }
}
